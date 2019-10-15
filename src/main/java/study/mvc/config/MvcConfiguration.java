package study.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import study.mvc.interceptor.TestInterceptor;

/**
 * @author playjun
 * @since 2019 09 20
 */
@Configuration
@ComponentScan("study")
@EnableWebMvc
@ImportResource("classpath:mvc-config.xml")
<<<<<<< HEAD
public class MvcConfiguration extends WebMvcConfigurationSupport {

=======
public class MvcConfiguration extends WebMvcConfigurerAdapter {
>>>>>>> 389ec6e9ce3da712eb5b6a0b6b22747cd6c4d510

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
    }
}

