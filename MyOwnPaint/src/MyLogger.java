
import java.io.IOException;
import java.util.logging.*;

/**
 * W klasie MyLogger kreujemy logger, który pozwoli nam kontrolować na bieżąco co się dzieje podczas uruchamiania naszej aplikacji.
 * Informacje z loggera zostają przekazane do pliku "log.txt"
 */

public class MyLogger {
    private MyLogger(){
        throw new InstantiationError("MyLogger is a full static class");
    }
    
    public static final Logger logger = Logger.getGlobal();  //tworzymy logger
    public static void LoggerConfig()
    {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        logger.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("./log.txt");  //ustawiamy, żeby logger komunikaty wrzucał do pliku log.txt
            fh.setLevel(Level.ALL);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

        } catch (IOException | SecurityException e) {
           
        }

        logger.setLevel(Level.OFF);  //ustawiamy co ma wyrzucać logger
    }

}
