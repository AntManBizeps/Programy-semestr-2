import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    
    @FXML
    private Text myText;
    @FXML
    private TextField myTextField;
    @FXML
    private TextArea myTextArea;

    String arguments;
    String[] arrOfStr;



    @FXML
    public void onEnter(ActionEvent ae){
        arguments = myTextField.getText();
        arrOfStr = arguments.split(" ", 10);

        myTextArea.clear();
        System.out.println(arguments);
        try {
            for(int i=1; i<arrOfStr.length; i++){
                ProcessBuilder pb = new ProcessBuilder("./threesome", arrOfStr[0], arrOfStr[i]);
                pb.directory(new File("/home/antoni/Desktop/LetsTryAgain/src"));
                Process process = pb.start();
            
                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    myTextArea.appendText( line);
                    myTextArea.appendText("\n");
                }
            }
            // ProcessBuilder pb = new ProcessBuilder("./threesome", arrOfStr[0], arrOfStr[1], arrOfStr[2]);
            // pb.directory(new File("/home/antoni/Desktop/LetsTryAgain/src"));
            // Process process = pb.start();
        
            // InputStream inputStream = process.getInputStream();
            // BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // String line;
            // while ((line = reader.readLine()) != null) {
            //     System.out.println(line);
            // }
        
            
        


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}