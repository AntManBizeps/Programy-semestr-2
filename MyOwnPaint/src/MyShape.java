import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/** 
 * Klasa abstrakcyjna MyShape dziedziczy po klasie Shape.
 * Zawiera ona deklaracje zmiennych potrzebnych do konstrukcji figur dziedziczących po niej oraz defaultowy kolor dla tych figur.
 */

public abstract class MyShape extends Shape
{
    protected Color color = Color.BLACK;
    protected double x=0.0;
    protected double y=0.0;
    protected double radius=0.0;
    protected double height=0.0;
    protected double width=0.0;
    protected double x2=0.0;
    protected double y2=0.0;
    protected double x3=0.0;
    protected double y3=0.0;

}
