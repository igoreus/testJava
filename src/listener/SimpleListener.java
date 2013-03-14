package listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 14.03.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class SimpleListener implements ServletContextListener {

    static final Logger logger = Logger.getLogger(SimpleListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        logger.info("SimpleListener.contextInitialized: " + servletContext.getContextPath());
        servletContext.setAttribute("test", "test");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
