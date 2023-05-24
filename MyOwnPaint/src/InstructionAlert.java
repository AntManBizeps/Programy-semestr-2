import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * W klasie InstructionAlert tworzy się alert z instrukcją obsługi aplikacji, które użytkownik może wyświetlić za pomocą 
 * przycisku "Instruction".
 */

public class InstructionAlert {
    public InstructionAlert(ActionEvent event){                   //constructor

        Alert a = new Alert(AlertType.NONE,                 //Alert "Instruction" zostaje utworzony
        "Instrukcja obsługi:\n\nAby utworzyć prostokąt wybierz \"Rectangle\", a następnie za pomocą myszy wybierz 2 naprzeciwległe wierzchołki.\n\nAby utworzyć trójkąt wybierz \"Polygon\", a następnie wybierz 3 wierzchołki.\n\nAby utworzyć koło wybierz \"Circle\", a następnie wybierz środek koła oraz kraniec.\nAby przesunąć figurę zaznacz \"Move\" i przeciągnij figurę za pomocą myszy.\n\nAby obrócić figurę zaznacz \"Rotate\" i klikaj na figurę za pomocą lewego przycisku myszy.\nAby zmienić rozmiar figury zaznacz \"Rotate\" i trzymając kliknięty lewy klawisz myszy na wybranej figurze użyj scrolla.\n\nPo kliknięciu prawym przyciskiem myszy na figurę wyświetli się paleta kolorów oraz przycisk \"Delete\".\n",ButtonType.OK);
        
        a.setTitle("How to use?");
        a.show();
    }
}
