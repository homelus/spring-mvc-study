package study.mvc.controller.tms;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import study.core.annotation.TmsRequestMapping;

/**
 * @author playjun
 * @since 2019 09 25
 */
@Component
@TmsController
@ResponseBody
public class TmsController {

    @TmsRequestMapping("/api/jun")
    public String helloJun() {
        return "Hello Jun";
    }

}
