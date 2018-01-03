package nl.craftsmen.java9demo.bar;

import nl.craftsmen.java9demo.bar.util.BarHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Bar {

    private static final Logger logger = Logger.getLogger("log");

    private BarHelper barHelper;

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.execute();
    }

    public Bar() {
        this.barHelper = new BarHelper();
    }
    public void execute() {
        System.out.println(StringUtils.capitalize("this sentence should start with a capital 'T'"));
        logWithJavaLogger("This is logged with the java util logger");
        barHelper.execute();
    }

    private void logWithJavaLogger(String message) {
        logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.log(Level.ALL, message);
    }
}
