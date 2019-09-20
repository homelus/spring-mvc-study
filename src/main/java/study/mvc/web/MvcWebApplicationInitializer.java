package study.mvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author playjun
 * @since 2019 09 20
 */
public class MvcWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(MvcWebApplicationInitializer.class);

    @Override
    public void onStartUp(ServletContext servletContext) throws ServletException {
        logger.info("MvcWebApplicationInitializer Started");
    }
}
