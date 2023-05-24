//import com.sun.prism.paint.Color;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Klasa MyRectangle w konstruktorze tworzy obiekt Rectangle, nadaje mu kolor i dodaje do ArrayListy.
 * Konstruktor przyjmuje trzy argumenty: współrzędne 2 naprzeciwległych wierzchołków, ArrayListe na figury oraz numer prostokąta. 
 * MyRectangle dziedziczy po MyShape.
 */

public class MyRectangle extends MyShape{

    public MyRectangle(ArrayList<Double> cordinates, ArrayList<Rectangle> rectangles, int rectCounnter){
        this.x = Math.min(cordinates.get(0), cordinates.get(2));
        this.y = Math.min(cordinates.get(1), cordinates.get(3));
        this.height = Math.abs(cordinates.get(1)-cordinates.get(3));  //obliczamy wysokość
        this.width = Math.abs(cordinates.get(0)-cordinates.get(2));   //obliczamy szerokość
        rectangles.add(new Rectangle(this.x, this.y, this.width, this.height)); //tworzymy obiekt rectangle i dodajemy do ArrayList w pliku Controller
        rectangles.get(rectCounnter).setFill(color);;
    }
}
