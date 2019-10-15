package study.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import study.core.TmsTypeArgumentResolver;

import java.util.List;

/**
 * @author playjun
 * @since 2019 09 20
 */
@Configuration
@ComponentScan("study")
@EnableWebMvc
@ImportResource("classpath:mvc-config.xml")
public class MvcConfiguration extends WebMvcConfigurationSupport {


}

