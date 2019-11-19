package study.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import study.mvc.service.AsyncService;

/**
 * @author playjun
 * @since 2019 09 23
 */
@RestController
public class HomeApiController {

    private final static Logger logger = LoggerFactory.getLogger(HomeApiController.class);

    public HomeApiController() {
        logger.info("user api controller instantiate");
    }

    @Autowired
    private AsyncService asyncService;

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
     */
    @RequestMapping("/api/hello")
    public String helloMvc() {
        logger.info("hello api entrance");
        return "hello MVC";
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor
     */
    @RequestMapping("/api/hello2")
    public HttpEntity<String> helloMvcWithEntity() {
        logger.info("hello2 api entrance");
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.DeferredResultMethodReturnValueHandler
     */
    @RequestMapping("/api/hello3")
    public DeferredResult<String> helloMvcWithDeferredResult() {
        DeferredResult<String> result = new DeferredResult<>();
        asyncService.async(result);
        logger.info("hello3 api end");
        return result;
    }

}
