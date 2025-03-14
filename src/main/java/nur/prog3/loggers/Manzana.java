package nur.prog3.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Manzana {
    private static final Logger logger = LogManager.getRootLogger();
    public String mmm() {
        logger.info("Imprime manzana");
        return "manzana";
    }
}
