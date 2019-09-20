package study.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author playjun
 * @since 2019 09 20
 */
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController() {
        logger.info("user controller instantiate");
    }
}
