package study.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import study.mvc.config.MvcConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author playjun
 * @since 2019 09 23
 */
public class MvcWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(MvcWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext context) {
        logger.info("Start Mvc Container Initializer");
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setContextClass(AnnotationConfigWebApplicationContext.class);
        dispatcherServlet.setContextConfigLocation(MvcConfiguration.class.getName());
        ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
