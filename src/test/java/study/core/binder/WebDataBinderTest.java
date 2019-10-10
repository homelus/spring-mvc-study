package study.core.binder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;
import study.core.WebUser;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author playjun
 * @since 2019 10 04
 */
class WebDataBinderTest {

    @DisplayName("후에 바인딩 된 타겟의 결과값")
    @Test
    void bindAfter() throws Exception {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        mockRequest.setParameter("name", "lay");
        DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(mockRequest);
        ConfigurableWebBindingInitializer configurableWebBindingInitializer = new ConfigurableWebBindingInitializer();
        configurableWebBindingInitializer.setConversionService(new DefaultFormattingConversionService());
        WebDataBinderFactory factory = new ServletRequestDataBinderFactory(new ArrayList<>(), configurableWebBindingInitializer);

        WebUser webUser = new WebUser();
        ServletRequestDataBinder binder = (ServletRequestDataBinder) factory.createBinder(webRequest, webUser, "user");
        binder.bind(mockRequest);

        assertThat(webUser.getName()).isEqualTo("lay");
    }

    @DisplayName("전에 바인딩 된 타겟의 결과값")
    @Test
    void bindBefore() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name", "lay");

        DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(request);
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        initializer.setConversionService(new DefaultFormattingConversionService());
        WebDataBinderFactory factory = new ServletRequestDataBinderFactory(new ArrayList<>(), initializer);

        WebUser webUser = new WebUser();
        webUser.setId("ken");
        webUser.setAge(25);
        webUser.setName("yei");

        ServletRequestDataBinder binder = (ServletRequestDataBinder) factory.createBinder(webRequest, webUser, "kUser");
        binder.bind(request);

        WebUser user = (WebUser) binder.getTarget();
        assertThat(user.getName()).isEqualTo("lay");
        assertThat(user.getAge()).isEqualTo(25);
        assertThat(user.getId()).isEqualTo("ken");
    }

    @DisplayName("특정 값을 Enum 에 Mapping 한 결과값")
    @Test
    void typeConvert() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name", "lay");
        request.setParameter("type", "1");
        request.setParameter("birthDay", "1999-02-21");

        DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(request);
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("yyyy-MM-dd");

        conversionService.addFormatter(dateFormatter);
        initializer.setConversionService(conversionService);
        WebDataBinderFactory factory = new ServletRequestDataBinderFactory(new ArrayList<>(), initializer);

        WebUser webUser = new WebUser();
        ServletRequestDataBinder binder = (ServletRequestDataBinder) factory.createBinder(webRequest, webUser, "nUser");
        binder.bind(request);

        System.out.println(webUser.getBirthDate());
    }

}
