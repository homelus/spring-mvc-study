package study.mvc.controller.tms;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import study.core.annotation.TmsController;
import study.core.annotation.TmsLevelAttribute;
import study.core.annotation.TmsRequestMapping;
import study.core.annotation.TmsTypeAttribute;
import study.mvc.model.TmsLevel;
import study.mvc.model.TmsType;

/**
 * @author playjun
 * @since 2019 09 25
 */
@TmsController
@ResponseBody
public class TmsArgResolverController {

    @TmsRequestMapping("/api/tmsLevel")
    public String helloJun(@TmsLevelAttribute TmsLevel level, @TmsTypeAttribute TmsType type) {
        return "Hello. user level: " + level.name() + ", user type: " + type.name();
    }

}
