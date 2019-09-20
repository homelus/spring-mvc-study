package study.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;
import study.mvc.config.MvcConfiguration;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author playjun
 * @since 2019 09 20
 */
@HandlesTypes(WebApplicationInitializer.class)
public class MvcContainerInitializer implements ServletContainerInitializer {

    private static final Logger logger = LoggerFactory.getLogger(MvcContainerInitializer.class);

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        logger.info("Start Mvc Container Initializer");
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        dispatcherServlet.setContextClass(MvcConfiguration.class);

        ServletRegistration.Dynamic dispatcher = ctx.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
