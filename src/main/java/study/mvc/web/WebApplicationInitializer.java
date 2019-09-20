package study.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author playjun
 * @since 2019 09 20
 */
public interface WebApplicationInitializer {

    void onStartUp(ServletContext servletContext) throws ServletException;

}
