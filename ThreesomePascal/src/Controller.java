import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    
    @FXML
    private ChoiceBox<Integer> rowNumber;

    @FXML
    private TextArea textArea;
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        Integer[] items = {0,1,2,3,4,5,6,7,8,9,10};
        rowNumber.getItems().addAll(items);
        rowNumber.setOnAction(this::getNumber);
    }

    public void getNumber(ActionEvent event) {
        int number = rowNumber.getValue();
        textArea.clear();
        textArea.appendText("1\n");
        int element;

        for(int i=1; i<=number; i++){
            for(int j=0; j<=i; j++){
                element = newton(i, j);
                textArea.appendText(element + " ");
            }
            textArea.appendText("\n");

        }        



    }


    public static int newton(int n, int r) {
        if (r > n) {
            return 0; // niepoprawne wartości n i r
        } else if (r == 0 || r == n) {
            return 1; // podstawa rekurencji
        } else {
            return newton(n-1, r-1) + newton(n-1, r); // rekurencyjne obliczanie wartości
        }
    }

    


    



}
