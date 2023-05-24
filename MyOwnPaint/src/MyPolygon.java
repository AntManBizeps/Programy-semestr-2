import java.util.ArrayList;

import javafx.scene.shape.Polygon;

/**
 * Klasa MyPolygon w konstruktorze tworzy obiekt Polygon, nadaje mu kolor i dodaje do ArrayListy.
 * Konstruktor przyjmuje trzy argumenty: współrzędne wierzchołków trójkąta, ArrayListe na figury oraz numer trójkąta. 
 * MyPolygon dziedziczy po MyShape.
 */

public class MyPolygon extends MyShape {

    public MyPolygon(ArrayList<Double> cordinates, ArrayList<Polygon> polygons, int polyCounnter){
        this.x = cordinates.get(0);
        this.y = cordinates.get(1);
        this.x2 = cordinates.get(2);
        this.y2 = cordinates.get(3);
        this.x3 = cordinates.get(4);
        this.y3 = cordinates.get(5);

        polygons.add(new Polygon(this.x, this.y, this.x2, this.y2, this.x3, this.y3));  //tworzymy obiekt polygon i dodajemy do ArrayList w pliku Controller
        polygons.get(polyCounnter).setFill(color);;
    }
}
