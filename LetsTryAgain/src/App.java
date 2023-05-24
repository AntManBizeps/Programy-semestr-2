import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("screen.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Pascal's Triangle Elements");
            stage.show();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


