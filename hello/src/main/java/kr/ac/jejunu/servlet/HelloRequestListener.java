package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by jhkang on 5/13/16.
 */
public class HelloRequestListener implements ServletRequestListener {
    private final static Logger logger = LoggerFactory.getLogger(HelloRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("**********  request listener init  **********");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("**********  request listener destroy  **********");
    }
}
