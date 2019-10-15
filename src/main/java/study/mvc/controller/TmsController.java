package study.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.mvc.exception.UserNotFoundException;

@Controller
public class TmsController {

    @RequestMapping
    public String notFoundUser(@RequestParam("userId") String userId) {
        throw new UserNotFoundException(userId);
    }

}
