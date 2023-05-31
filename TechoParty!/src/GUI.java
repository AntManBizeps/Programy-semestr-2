import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUI {
    public GUI(Stage stage){
        try {
            // Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));  //ładujemy plik fxml opracowany w SceneBuilder
            // // Group root = new Group();
            // Scene scene = new Scene(root);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
            Parent root = loader.load();

        // Przekazanie referencji do obiektu Stage do kontrolera
            Controller controller = loader.getController();
            controller.setStage(stage);

            Image icon = new Image("techno.jpg");
            stage.getIcons().add(icon);
    
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("TechnoParty - parameters");
            stage.setResizable(true);
            stage.show();
            
    
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
