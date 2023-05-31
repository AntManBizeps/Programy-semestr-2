
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private TextField myM, myN, myK, myP;

    @FXML 
    private Pane myPane;

    private int n=0, m=0, k=0;
    private double p=0.0;

    private Stage mainStage;

    public void setStage(Stage stage) {
        this.mainStage = stage;
    }

    public void SubmitClicked(ActionEvent event) 
    {
        try {
            m = Integer.parseInt(myM.getText());
            n = Integer.parseInt(myN.getText());
            k = Integer.parseInt(myK.getText());
            p = Double.parseDouble(myP.getText());
            NewBoard newBoard = new NewBoard(mainStage, m, n, k, p);



        } catch (Exception e) {
            Text text = new Text("Nie prawidłowy format danych.");
            myPane.getChildren().add(text);
            text.setLayoutX(30.0);
            text.setLayoutY(150.0);
        }
    }


    





    
}
