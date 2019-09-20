package study.mvc.config;

import org.springframework.context.annotation.Bean;
import study.mvc.controller.UserController;

/**
 * @author playjun
 * @since 2019 09 20
 */
public class MvcConfiguration {

    @Bean
    public UserController userController() {
        return new UserController();
    }

}

