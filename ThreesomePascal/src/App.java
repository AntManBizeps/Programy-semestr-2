


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class App extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene  = new Scene(root);

            Image icon = new Image("images.png");
            stage.getIcons().add(icon);
            
            
            stage.setScene(scene);
            stage.setTitle("Pascal's Triangle");
            stage.show();
 
        } catch(Exception e) {
            e.printStackTrace();
        }



        



        
        
    } 
}