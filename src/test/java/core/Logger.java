package core;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static final org.apache.logging.log4j.Logger LOG4J = LogManager.getLogger(Logger.class);
    private static volatile Logger instance = null;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String message) {
        LOG4J.info(message);
    }

    public void warn(String message) {
        LOG4J.warn(message);
    }

    public void logTestName(final String testName) {
        String formattedName = String.format("=====================  Test case: '%s' =====================", testName);

        StringBuilder delims = new StringBuilder();
        for (int i = 0; i < formattedName.length(); i++) {
            delims.append("-");
        }
        info(delims.toString());
        info(formattedName);
        info(delims.toString());
    }

    public void logTestEnd(final String testName, boolean isPassed) {
        info("");
        String result = isPassed ? "Passed" : "Failed";
        String formattedEnd = String.format("***** Test case: '%s' %s *****", testName, result);

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < formattedEnd.length(); i++) {
            stars.append("*");
        }
        info(stars.toString());
        info(formattedEnd);
        info(stars.toString());
        info("");
    }
}
