package study.mvc.controller.initBinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.mvc.model.TmsUser;

import java.beans.PropertyEditorSupport;

@Controller
@ResponseBody
public class TmsInitBinderController {

    private final static Logger logger = LoggerFactory.getLogger(TmsInitBinderController.class);

    public TmsInitBinderController() {
        logger.info("init binder controller instantiate");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new TmsValidator());
        dataBinder.registerCustomEditor(TmsUser.class, new TmsEditor());
    }

    @RequestMapping("/api/ib/tmsUser")
    public String tmsUser(/*String title,*/
                          @Validated TmsUser tmsName) {
        return tmsName.toString();
    }

//    @RequestMapping("/api/tmsInvalidUser")
//    public String tmsInvalidUser(String title, TmsUser tmsName) {
//        tmsName.setId(title);
//        return tmsName.toString();
//    }

    private static class TmsEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            System.out.println("text: " + text);
            TmsUser tmsName = new TmsUser();
            tmsName.setName("TMS-" + text);
            setSource(tmsName);
        }
    }

    private static class TmsValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return TmsUser.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            TmsUser tmsName = (TmsUser) target;
            if (tmsName.startWithTms()) {
                errors.reject("invalid", "tms not supported");
            }
        }
    }

}
