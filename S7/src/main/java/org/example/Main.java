package org.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger("Basic Logger");
    public static void main(String[] args) {
        logger.addHandler(new ConsoleHandler());
        logger.setUseParentHandlers(false);
        logger.log(new LogRecord(Level.INFO, "я родился)))"));
        logger.info("Я родился");
        logger.log(Level.INFO, "Я родился");
        ViewCalculator calculator = new ViewCalculator(new CalculatorFactory());
        calculator.run();
    }
}
