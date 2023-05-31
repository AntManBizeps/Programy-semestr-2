import java.util.ArrayList;

import javax.swing.text.FlowView.FlowStrategy;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle {
    protected Rectangle rectangle;
    protected MyThreadThing squareThreadThing;
    protected double red;
    protected double green;
    protected double blue;
    protected ArrayList<Square> neighbours = new ArrayList<Square>();
    // private volatile boolean isPaused=false;
    private double p;
    private Object myMutex = new Object();

    public Object getMyMutex() {
        return myMutex;
    }

    // public synchronized void changeThread(){
    //     isPaused = !isPaused;
    //     notify();
    // }

    // public synchronized void pauseThread() {
    //     isPaused = true;
    //     }
    
    // public synchronized void resumeThread() {
    //     isPaused = false;
    //     notify(); // Wznawianie wątku
    // }
    
    // public synchronized boolean getPauseValue(){
    //     return isPaused;
    // }

    // public synchronized void setPauseValue(boolean value){
    //     isPaused = value;
    // }

    public Square(double p, double width, double height){
        this.p = p;
        rectangle = new Rectangle(width, height);
        rectangle.setStroke(Color.PURPLE);
        rectangle.setOnMouseClicked(OnMousePressedEventHandler);
    }

    public void setSqThreadThing(MyThreadThing sqMyThreadThing){
        this.squareThreadThing = sqMyThreadThing;
    }
    
    public void setFromNeigboursColor(){
        double neighboursAlive = 0.0;
        red = 0.0;
        green = 0.0;
        blue = 0.0;

        synchronized(myMutex)
        {
            for (int i=0; i<4; i++) 
            {
                synchronized(neighbours.get(i).getMyMutex())
                {

                    
                    if ((neighbours.get(i).squareThreadThing.getState()) == Thread.State.WAITING)
                    {
                        continue;
                    }

                    red += neighbours.get(i).red;
                    green += neighbours.get(i).green;
                    blue += neighbours.get(i).blue;
                    neighboursAlive++;
                }
            }
        }

        if(neighboursAlive>0.0){
            red = red/neighboursAlive;
            green = green/neighboursAlive;
            blue = blue/neighboursAlive;
        } else return;

        Platform.runLater(() -> rectangle.setFill(Color.color(red, green, blue))); 
    }

    public void setRandomColor(){
        synchronized(myMutex){
            red = RandomGenerator.randomDouble();
            green = RandomGenerator.randomDouble();
            blue = RandomGenerator.randomDouble();

            Platform.runLater(() -> rectangle.setFill(Color.color(red, green, blue))); 
        }
        
    }

    public synchronized void doTaskAction(){
        if(RandomGenerator.randomDouble() <= (1.0-p)){
            setFromNeigboursColor();
                     
        }else {
            setRandomColor();
            
        }
    }

    //obsługa zdarzenia klikniecia klawisza myszy
    EventHandler<MouseEvent> OnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
          if(t.getButton() == MouseButton.PRIMARY){  //dla lewego klawisza
                synchronized(this){
                    if(squareThreadThing.isPaused==false){
                        squareThreadThing.setBlocked();
                    } else {
                        squareThreadThing.setBlocked();
                    }
                }

          }
        }
    };
}
