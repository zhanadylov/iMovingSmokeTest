package org.example.hooks.logs;

import org.apache.logging.log4j.LogManager;
//import org.slf4j.Logger;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jDemo {

//    private static Logger logger = LogManager.getLogger(Log4jDemo.class);

    public static Logger logger;

    static {
        System.setProperty("logback.configurationFile", "logback.xml");
        logger = LogManager.getLogger(Log4jDemo.class);
    }

    public static void main(String[] args) {
        logger.info("Info message!");
        logger.debug("Debug message");
        logger.trace("Trace message");
        logger.warn("Warn message");
        logger.error("Error message");
    }
}
