

import java.beans.EventHandler;

import javafx.application.Platform;
import javafx.concurrent.Task;

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NewBoard extends Controller {
    protected Stage boardStage;
    protected volatile static boolean stopThreads;
    protected double width, height;


    public NewBoard(Stage stage, int m, int n, int k, double p)
    {
        Board board = new Board(n, m);
        boardStage = stage;
        stage.setTitle("Techno Party!");
        GridPane myGridPane = new GridPane();
        myGridPane.setPrefSize(800.0, 800.0);

                // Utwórz ograniczenia kolumny
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(800.0/(double)m);
        columnConstraints.setHgrow(Priority.ALWAYS);

        // Utwórz ograniczenia wiersza
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(800.0/(double)n);
        rowConstraints.setVgrow(Priority.ALWAYS);

        
        // Ustawienie preferowanego rozmiaru kolumn i wierszy
        for (int i = 0; i < n; i++) {
            myGridPane.getColumnConstraints().add(columnConstraints); // Ustawienie szerokości kolumny
        }
        for (int i = 0; i < m; i++) {
            myGridPane.getRowConstraints().add(rowConstraints); // Ustawienie wysokości wiersza
        }
        height = (800.0/(double)m);
        width = (800.0/(double)n);
        // Dodaj Listener dla zmiany rozmiaru siatki
        myGridPane.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            columnConstraints.setPrefWidth(newWidth.doubleValue() / myGridPane.getColumnCount());
        });

        myGridPane.heightProperty().addListener((obs, oldHeight, newHeight) -> {
            rowConstraints.setPrefHeight(newHeight.doubleValue() / myGridPane.getRowCount());
        });
        
        try {
            Object mutex = new Object();
            // Dodanie elementów do siatki
            for (int row = 0; row < m; row++) {
                for (int col = 1; col <= n; col++) {
                    //Label label = new Label((row) + ", " + (col));
                    // Rectangle rectangle = new Rectangle();
                    // rectangle.setWidth(50);
                    // rectangle.setHeight(50);
                    // rectangle.setStroke(Color.PURPLE);
                    //rectangle.setOnMouseClicked(OnMousePressedEventHandler);
                    Square square = new Square(p, width, height);
                    MyThreadThing myThreadThing = new MyThreadThing(square, k, mutex);
                    square.squareThreadThing = myThreadThing;
                    square.setSqThreadThing(myThreadThing);
                    myThreadThing.count = row*m + col;
                    myThreadThing.start();
                    
                    //myThreadThing.join();
                    //myThreadThing.setDaemon(stopThreads);
                    //Platform.runLater(myThreadThing);
                    
                    myGridPane.add(myThreadThing.square.rectangle, col-1, row); // Dodanie etykiety do określonej komórki siatki
                    board.threadsChart[row][col-1] = myThreadThing;
                    board.squaresChart[row][col-1] = square;
                }
            }

            for (int row = 0; row < m; row++){
                for (int col = 0; col < n; col++){

                    board.squaresChart[row][col].neighbours.add(board.squaresChart[(row+1)%m][col]);
                    board.squaresChart[row][col].neighbours.add(board.squaresChart[(row-1 + m)%m][col]);
                    board.squaresChart[row][col].neighbours.add(board.squaresChart[row][(col+1)%n]);
                    board.squaresChart[row][col].neighbours.add(board.squaresChart[row][(col-1 + n)%n]);
                    //board.threadsChart[row][col].neighbours.add(board.threadsChart[(row+1)%m][(col+1)%n]);

                }
            }
            // for (int row = 0; row < m; row++){
            //     for (int col = 0; col < n; col++){
            //         board.threadsChart[row][col].start();
            //         board.threadsChart[row][col].join();
            //         board.threadsChart[row][col].setDaemon(stopThreads);
            //     }
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Scene newScene = new Scene(myGridPane, 50*m, 50*n);

        boardStage.setScene(newScene); 
        boardStage.show();
    }
        
    public static void stopThreads() {
        stopThreads = true;
    }

    
}

    

