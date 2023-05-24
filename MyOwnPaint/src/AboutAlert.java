import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * W klasie AboutAlert tworzy się alert z podstawowymi informacjami o aplikacji, które użytkownik może wyświetlić za pomocą 
 * przycisku "About".
 */

public class AboutAlert {
    public AboutAlert(ActionEvent event){                   //constructor

        Alert a = new Alert(AlertType.NONE,                 //Alert "About" jest tworzony
        "Nazwa: Paint\nAutor: Antoni\nPrzeznaczenie: Program graficzny\nLicencja do: Infinity",ButtonType.OK);
        
        a.setTitle("About");
        a.show();
    }
}