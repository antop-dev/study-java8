package ch05.sec03;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalLogger {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("antop");
        logger.setLevel(Level.FINER);
        logger.setUseParentHandlers(false);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.entering("antop", "read", new Object[]{1, 2, 3});
        logger.exiting("antop", "read", 10);
    }

}