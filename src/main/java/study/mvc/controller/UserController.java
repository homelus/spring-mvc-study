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
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController() {
        logger.info("user controller instantiate");
    }

    @RequestMapping("/app/hello")
    public String helloMvc() {
        return "home.jsp";
    }
}
