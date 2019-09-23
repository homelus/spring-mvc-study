package study.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author playjun
 * @since 2019 09 20
 */
public class WebServerLauncher {

    private static final Logger logger = LoggerFactory.getLogger(WebServerLauncher.class);

    public static void main(String[] args) throws LifecycleException {
        String webappDirLocation = "webapp/";
        String webappPath = new File(webappDirLocation).getAbsolutePath();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.addWebapp("/", webappPath);
        tomcat.setSilent(true);
        logger.info("server start, webapp path: {}", webappPath);

        tomcat.start();
        tomcat.getServer().await();
    }

}
