package study.core;

import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author playjun
 * @since 2019 10 04
 */
public class WebDataBinderTest {

    @Test
    void binderTest() throws Exception {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        mockRequest.setParameter("name", "jun");
        DispatcherServletWebRequest webRequest = new DispatcherServletWebRequest(mockRequest);
        ConfigurableWebBindingInitializer configurableWebBindingInitializer = new ConfigurableWebBindingInitializer();
        configurableWebBindingInitializer.setConversionService(new DefaultFormattingConversionService());
        WebDataBinderFactory factory = new ServletRequestDataBinderFactory(new ArrayList<>(), configurableWebBindingInitializer);


        WebUser webUser = new WebUser();
        ServletRequestDataBinder binder = (ServletRequestDataBinder) factory.createBinder(webRequest, webUser, "user");
        binder.bind(mockRequest);

        assertThat(webUser.getName()).isEqualTo("jun");

    }

    private static class WebUser {
        private String id;
        private String name;
        private int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
