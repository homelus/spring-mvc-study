package study.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author playjun
 * @since 2019 09 20
 */
@Controller
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController() {
        logger.info("user controller instantiate");
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler
     */
    @RequestMapping("/app/hello")
    public String helloMvc() {
        return "home.jsp";
    }

}
