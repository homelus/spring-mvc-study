package study.mvc.controller.tms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.mvc.model.TmsName;

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
        dataBinder.registerCustomEditor(TmsName.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                System.out.println("text: " + text);
                TmsName tmsName = new TmsName();
                tmsName.setName("TMS-" + text);
                setSource(tmsName);
            }
        });
    }

    @RequestMapping("/api/tmsUser")
    public String tmsUser(String title, @RequestParam TmsName tmsName) {
        tmsName.setTitle(title);
        return tmsName.toString();
    }

//    @RequestMapping("/api/tmsInvalidUser")
//    public String tmsInvalidUser(String title, TmsName tmsName) {
//        tmsName.setTitle(title);
//        return tmsName.toString();
//    }

}
