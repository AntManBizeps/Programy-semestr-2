import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Klasa App dziedziczy po klasie Application. Launchujemy tutaj naszą aplikację, wprowadzamy do działania logger
 * oraz tworzymy obiekt klasy GUI.My
 */

public class App  extends Application{
    public static void main(String[] args) throws Exception {
        MyLogger.LoggerConfig();    //wprowadzamy loggera
        Application.launch(args);          
    }

    @Override
    public void start(Stage stage) throws IOException {
        final GUI gui = new GUI(stage);  //tworzymy obiekt GUI
    }
}
