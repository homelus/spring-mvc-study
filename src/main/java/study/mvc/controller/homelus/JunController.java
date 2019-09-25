package study.mvc.controller.homelus;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import study.core.annotation.HomelusController;
import study.core.annotation.HomelusRequestMapping;

/**
 * @author playjun
 * @since 2019 09 25
 */
@Component
@HomelusController
@ResponseBody
public class JunController {

    @HomelusRequestMapping("/api/jun")
    public String helloJun() {
        return "Hello Jun";
    }

}
