package study.mvc.controller.argumentResolver;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.mvc.model.TmsUser;

import java.util.HashMap;

/**
 * @author playjun
 * @since 2019 10 04
 */
@RestController
public class ArgResolverController {

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor
     */
    @RequestMapping("/api/t1/tmsUser")
    public String t1(TmsUser tmsUser) {
        return tmsUser.toString();
    }

    /**
     * Request 에서 parameter name 혹은 value() 값을 통해 조회한다.
     * String 타입이 아닌 경우 WebDataBinder 를 통해 타입을 변환한다.
     * @see org.springframework.web.method.annotation.RequestParamMethodArgumentResolver
     */
    @RequestMapping("/api/t2/tmsUser")
    public String t2(@RequestParam Integer count) {
        return count.toString();
    }

    // 혼합 테스트
    @RequestMapping("api/t1t2/tmsUser")
    public String t1t2(@RequestParam String name, TmsUser tmsUser) {
        return name + " : " + tmsUser.toString();
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver
     */
    @RequestMapping("/api/t3/tmsUser/{id}")
    public String t3(@PathVariable String id) {
        return id;
    }

    /**
     * 의미 없음
     * @see org.springframework.web.method.annotation.MapMethodProcessor
     */
    @RequestMapping("/api/t4/tmsUser")
    public String t4(HashMap<String, String> parameters) {
        return parameters.toString();
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor
     */
    @RequestMapping("/api/t5/tmsUser")
    public String t5(@ModelAttribute HashMap<String, String> parameters) {
        parameters.put("test", "test1");
        return parameters.toString();
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor
     */
    @RequestMapping("/api/t6/tmsUser")
    public String t6(@ModelAttribute TmsUser tmsUser) {
        return tmsUser.toString();
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
     *
     * @see org.springframework.http.converter.StringHttpMessageConverter
     * RequestBody 가 존재하는 경우 / Type 이 String 인 경우
     */
    @RequestMapping("/api/t7/tmsUser")
    public String t7(@RequestBody String data) {
        return data;
    }

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor
     *
     * @see org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter
     * RequestBody 가 존재하는 경우 / Type 이 MultiValueMap 인 경우
     * Content-Type 이 application-x-www.form-urlencoded 혹은 multipart/form-data 인 경우
     */
    @RequestMapping("/api/t8/tmsUser")
    public String t7(@RequestBody MultiValueMap<String, String> data) {
        return data.toString();
    }

}
