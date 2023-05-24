import java.util.ArrayList;

import javafx.scene.shape.Circle;

/**
 * Klasa MyCircle w konstruktorze tworzy obiekt Circle, nadaje mu kolor i dodaje do ArrayListy.
 * Konstruktor przyjmuje trzy argumenty: współrzędne środka oraz krańca koła, ArrayListe na figury oraz numer koła. 
 * MyCircle dziedziczy po MyShape.
 */

public class MyCircle extends MyShape{

    public MyCircle(ArrayList<Double> cordinates, ArrayList<Circle> circles, int circCounnter){
        this.x = cordinates.get(0);
        this.y = cordinates.get(1);
        this.radius = Math.sqrt(Math.pow((cordinates.get(2)-x), 2)+Math.pow((cordinates.get(3)-y), 2));  //obliczamy promień

        circles.add(new Circle(x, y, radius));   //tworzymy obiekt cirlce i dodajemy do ArrayList w pliku Controller
        circles.get(circCounnter).setFill(color);;
    }
}
