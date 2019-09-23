package study.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author playjun
 * @since 2019 09 20
 */
@Configuration
@ComponentScan("study.mvc")
@ImportResource("classpath:mvc-config.xml")
public class MvcConfiguration {

}

