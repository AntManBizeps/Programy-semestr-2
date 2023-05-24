import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * W klasie GUI tworzymy podstawy naszej aplikacji. Ładujemy plik "project.fxml" wygenerowany za pomocą
 * SceneBuilder'a i tworzymy na jego podstawie scene.
 */

public class GUI {
    public GUI(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("project.fxml"));  //ładujemy plik fxml opracowany w SceneBuilder
            Scene scene = new Scene(root);
    
            Image icon = new Image("PaintIcon.png");
            stage.getIcons().add(icon);
    
            stage.setScene(scene);
            stage.setTitle("Paint");
            stage.setResizable(true);
            stage.show();
            
    
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
