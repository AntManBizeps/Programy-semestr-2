import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Klasa Controller służy do obsługiwania eventów zachodzących w naszej aplikacji, które tworzy użytkownik.
 * Implementuje ona Initializable.
 */

public class Controller implements Initializable{

  /**
   * Na początku deklarujemy wszystkie elementy utworzone w SceneBuilder oraz wykorzystywane zmienne i ArrayListy służące
   * do przechowywania figur.
   * @param event
   */

   @FXML
   private Pane myPaintingPane;  //deklaracja elementów z pliku fxml

  @FXML
  private CheckBox myMoveBox;

  @FXML
  private CheckBox myRotateBox;

  @FXML
  private CheckBox myResizeBox;

   @FXML
   private Pane myMainPane;

   @FXML
   private HBox myHBox;

   @FXML
   private MenuBar myMenuBar;

   @FXML
   private MenuItem myCloseButton;

   @FXML
   private MenuItem mySaveButton;

   @FXML
   private MenuItem myAboutButton;

   @FXML
   private MenuItem myInstructionButton;

   @FXML
   private Button myRectangleButton;

   @FXML
   private Button myPolygonButton;

   @FXML
   private Button myCircleButton;

   // Tworzenie ArrayList obiektów typu Rectangle, Circle, Polygon
   protected ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
   protected ArrayList<Circle> circles = new ArrayList<Circle>();
   protected ArrayList<Polygon> polygons = new ArrayList<Polygon>();

   protected int rectCounter=0, circCounter=0, polyCounter=0;

   protected ArrayList<Double> cordinates = new ArrayList<>();  //lista na współrzędne

   private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY; //zmienne wykorzystane przy obsłudze poruszania obiektami

   private boolean move = false, rotate = false, resize = false;

   private static final double SCALE_DELTA = 1.1;

/**
 * W nadpisanej metodzie initialize łączymy ze sobą rozmiary sceny przeznaczonej do rysowania, Hbox'a oraz MenuBar'a 
 * ze sceną główną. Zastosowanie metody initialize pozwala nam wykonać te operacje przy uruchamianiu programu.
 * @param event
 */

  @Override
   public void initialize(URL arg0, ResourceBundle arg1){            //łączymy elementy z głównym pane, żeby sięs= ładnie skalowały
     myHBox.prefWidthProperty().bind(myMainPane.widthProperty());
    
     myMenuBar.prefWidthProperty().bind(myMainPane.widthProperty());

     myPaintingPane.prefWidthProperty().bind(myMainPane.widthProperty());
     myPaintingPane.prefHeightProperty().bind(myMainPane.heightProperty());


   }
/** 
 * AboutAlert jest metodą obsługującą kliknięcie przycisku "About" 
 * @param event
 * */

   public void AboutAlert(ActionEvent event){
     MyLogger.logger.log(Level.INFO, "AboutAlert");     //obsługa "about" alert
        AboutAlert alert = new AboutAlert(event);
   }

/** 
 * InstructionAlert jest metodą obsługującą kliknięcie przycisku "Instruction" 
 * @param event
 * */

   public void InstructionAlert(ActionEvent event){           //obsługa "instruction" alert
     MyLogger.logger.log(Level.INFO, "InstructionAlert");
    InstructionAlert alert = new InstructionAlert(event);
   }
/** 
 * MouseHandlerRect obsługuje proces wyboru współrzędnych prostokąta,a następnie tworzy obiekt MyRectangle.
 * W metodzie zostają również przypisane odpowiednie handlery do utworzonej figury.
 * @param event
 */
   public void MouseHandlerRect(MouseEvent event){          //obsługa wybierania współrzednych prostokąta
    if(event.getButton() == MouseButton.PRIMARY){
      MyLogger.logger.log(Level.INFO, "MouseClickedRect");
          cordinates.add(event.getX());        //na klikniecie myszą dostajemy współrzędne punktu
          cordinates.add(event.getY());
          if(cordinates.size()==4){  //sprawdzamy, czy mamy już 2 wierzchołki
            MyRectangle myrectangle = new MyRectangle(cordinates, rectangles, rectCounter);  //tworzymy obiekt myRectangle
            myPaintingPane.getChildren().add(rectangles.get(rectCounter));
            rectangles.get(rectCounter).setOnMousePressed(OnMousePressedEventHandler);  //ustawiamy odpowiednie handlery
            rectangles.get(rectCounter).setOnMouseDragged(OnMouseDraggedEventHandler);
            rectCounter++;
            cordinates.clear();
          }
      }
   }

   /**
    * RectangleClicked obsługuje zdarzenie kliknięcia na przycisk "Rectangle". Ustawia handler klikania myszą na 
    * odpowiadający prostokątowi. Deaktywuje również opcje edycji.
    * @param event
    */

   public void RectangleClicked(ActionEvent event){      //obsługa wybrania przycisku "recktangle"
     MyLogger.logger.log(Level.INFO, "RectangleButton");
     myPaintingPane.setOnMouseClicked(this::MouseHandlerRect);  //ustawiamy handler obsługujący wybieranie wierzchołków prostokąta
     myMoveBox.setSelected(false);
     myRotateBox.setSelected(false);
     myResizeBox.setSelected(false);
     move = false;
     rotate = false;
     resize = false;
   }

    /** 
 * MouseHandlerCirc obsługuje proces wyboru współrzędnych koła,a następnie tworzy obiekt MyCircle.
 * W metodzie zostają również przypisane odpowiednie handlery do utworzonej figury.
 * @param event
 */

   public void MouseHandlerCirc(MouseEvent event){  //obsługa wybierania współrzędnych koła
    if(event.getButton() == MouseButton.PRIMARY){
      MyLogger.logger.log(Level.INFO, "MouseClickedCirc");  
          cordinates.add(event.getX());  //na klikniecie myszą dostajemy współrzędne punktu
          cordinates.add(event.getY());
          if(cordinates.size()==4){  //sprawdzamy, czy mamy już środek i kraniec
            MyCircle mycirlce = new MyCircle(cordinates, circles, circCounter); //tworzymy obiekt koła 
            myPaintingPane.getChildren().add(circles.get(circCounter));
            circles.get(circCounter).setOnMousePressed(OnMousePressedEventHandler);  //ustawiamy odpowiednie Eventhandlery
            circles.get(circCounter).setOnMouseDragged(OnMouseDraggedEventHandler);
            circCounter++;
            cordinates.clear();
          }
      }
   }

      /**
    * CircleClicked obsługuje zdarzenie kliknięcia na przycisk "Circle". Ustawia handler klikania myszą na 
    * odpowiadający kołu. Deaktywuje również opcje edycji.
    * @param event
    */

   public void CircleClicked(ActionEvent event){   //obsługa kliknięcia "Circle"
     MyLogger.logger.log(Level.INFO, "CircleButton");
     myPaintingPane.setOnMouseClicked(this::MouseHandlerCirc);  //ustawiamy handler obsługujący wybieranie współrzędnych koła
     myMoveBox.setSelected(false);
     myRotateBox.setSelected(false);
     myResizeBox.setSelected(false);
     move = false;
     rotate = false;
     resize = false;
   }

/** 
 * MouseHandlerPoly obsługuje proces wyboru współrzędnych prostokąta,a następnie tworzy obiekt MyPolygon.
 * W metodzie zostają również przypisane odpowiednie handlery do utworzonej figury.
 * @param event
 */

   public void MouseHandlerPoly(MouseEvent event){  //obsługa wybierania współrzędnych trójkąta
    if(event.getButton() == MouseButton.PRIMARY){
      MyLogger.logger.log(Level.INFO, "MouseClickedPoly");
          cordinates.add(event.getX());  //przechwytujemy wybrane myszą wspórzędne
          cordinates.add(event.getY());
          if(cordinates.size()==6){  //sprawdzamy, czy mamy 3 wierzchołki
            MyPolygon mypolygon = new MyPolygon(cordinates, polygons, polyCounter);  //tworzymy obiekt myPolygon
            myPaintingPane.getChildren().add(polygons.get(polyCounter));
            polygons.get(polyCounter).setOnMousePressed(OnMousePressedEventHandler);  //ustawiamy odpowiednie EventHandlery
            polygons.get(polyCounter).setOnMouseDragged(OnMouseDraggedEventHandler);
            polyCounter++;
            cordinates.clear();
          }
      }
   }

      /**
    * PolygonClicked obsługuje zdarzenie kliknięcia na przycisk "Polygon". Ustawia handler klikania myszą na 
    * odpowiadający trójkątowi. Deaktywuje również opcje edycji.
    * @param event
    */

    public void PolygonClicked(ActionEvent event){   //obsługa klikniecią przycisku "Polygon"
      MyLogger.logger.log(Level.INFO, "PolygonButton");
      myPaintingPane.setOnMouseClicked(this::MouseHandlerPoly);  //ustawiamy odpowiedni handler do wyboru wierzchołków trójkąta
      myMoveBox.setSelected(false);
      myRotateBox.setSelected(false);
      myResizeBox.setSelected(false);
      move = false;
      rotate = false;
      resize = false;
    }

    /**
     * MoveClicked obsłguje zaznaczenie opcji "Move". Zmienia możliwość poruszania figurami na aktywną.
     * @param event
     */
    public void MoveClicked(ActionEvent event){ //obsługa klikniecią przycisku "Move"
      if(myMoveBox.isSelected()){               //zmiana możłiwości poruszania figurą
        move = true;
        myPaintingPane.setOnMouseClicked(null);
      } else move = false;
    }

    /**
     * RotateClicked obsłguje zaznaczenie opcji "Rotate". Zmienia możliwość obracania figurami na aktywną.
     * @param event
     */

    public void RotateClicked(ActionEvent event){ //obsługa klikniecią przycisku "Rotate"
      if(myRotateBox.isSelected()){               //zmiana możliwości obracania figury
        rotate = true;
        myPaintingPane.setOnMouseClicked(null);
      } else rotate = false;
    }

        /**
     * ResizeClicked obsłguje zaznaczenie opcji "Resize". Zmienia możliwość skalowania figur na aktywną.
     * @param event
     */

    public void ResizeClicked(ActionEvent event){ //obsługa klikniecią przycisku "Resize"
      if(myResizeBox.isSelected()){               //zmiana możliwości skalowania figury
        resize = true;
        myPaintingPane.setOnMouseClicked(null);
      } else resize = false;
    }

    /**
     * OnMousePressedEventHandler obsługuje event klikania myszą. EventHandler zawiera przypadek użycia 
     * lewego klawisza jak i prawego klawisza myszy. Lewy klawisz przesuwa figurę przed resztę oraz jeśli move == true
     * przygotowuje ją do przesunięcia, a jeśli rotate == true umożliwia on rotowanie figurą. Prawy klawisz myszy tworzy 
     * paletę kolorów oraz przycisk "Delete", opakowuje je w jednego HBox'a, następnie wyświetla użytkownikowi.
     */

    //obsługa zdarzenia klikniecia klawisza myszy
    EventHandler<MouseEvent> OnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
          if(t.getButton() == MouseButton.PRIMARY){  //dla lewego klawisza
            MyLogger.logger.log(Level.FINER, "LeftMousePressed");
            ((Shape)(t.getSource())).toFront();
            if(move==true){
                orgSceneX = t.getSceneX();           //przygotowanie pod przesunięcie
                orgSceneY = t.getSceneY();
                orgTranslateX = ((Shape)(t.getSource())).getTranslateX();
                orgTranslateY = ((Shape)(t.getSource())).getTranslateY();
            } 
            if(rotate==true){           //rotacja figury za pomocą RotateTransition
              RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.1), (Shape)(t.getSource()));
              rotateTransition.setByAngle(5);
              rotateTransition.play();
            }
          
          } else if(t.getButton() == MouseButton.SECONDARY){  //dla prawego klawisza
                ColorPicker colorPicker = new ColorPicker();  //tworzmy colorPicker
                colorPicker.setOnAction(colorEvent -> {
                    Color selectedColor = colorPicker.getValue();  //ustawiamy dla niego obsługe zdarzenia wyboru koloru
                    ((Shape)(t.getSource())).setFill(selectedColor);
                });

                StackPane colorPickerPane = new StackPane(colorPicker);  //tworzmy palete kolorów dla naszego colorPickera
                colorPickerPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);"); // Tło dla palety kolorów
                colorPickerPane.setMaxSize(200, 200);

                Button deleteButton = new Button("Delete");  //tworzymy przycisk Delete

                HBox hbox = new HBox(colorPickerPane, deleteButton);  //przycisk Delete i palete kolorów pakujemy do HBoxa
                hbox.setTranslateX(t.getSceneX());
                hbox.setTranslateY(t.getSceneY());

                
                deleteButton.setOnMouseClicked(event -> {  //obsługa zdarzenia wybrania przycisku Delete 
                  myPaintingPane.getChildren().remove(((Shape)(t.getSource())));
                  myPaintingPane.getChildren().remove(hbox);
                });


                Scene scene = ((Shape)(t.getSource())).getScene();
                
                myPaintingPane.getChildren().add(hbox);
                colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {  //jeśli kolor wybrany to usuwamy HBox
                  myPaintingPane.getChildren().remove(hbox);
              });
          }
        }
    };

    /**
     * OnMouseDraggedEventHandler obsługuje event przytrzymania myszy. Jeśli move == true pozwala za pomocą poruszania
     * kursorem przesuwć figury. Jeśli rotate == true umożliwia to zmianę rozmiaru figury za pomocą scrolla, obsługiwany w warunku dla
     * rotate == true.
     */

    //obsługa zdarzenia przytrzymania klawisza myszy
    EventHandler<MouseEvent> OnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
          MyLogger.logger.log(Level.FINER, "ReMoDr");
          if(move==true){
               double offsetX = t.getSceneX() - orgSceneX;  //obsłuha przesuwania figury
               double offsetY = t.getSceneY() - orgSceneY;
               double newTranslateX = orgTranslateX + offsetX;
               double newTranslateY = orgTranslateY + offsetY;
            
               ((Shape)(t.getSource())).setTranslateX(newTranslateX);  //przesuwamy za pomocą metody setTranslate
               ((Shape)(t.getSource())).setTranslateY(newTranslateY);
               
          }
          else if(resize == true) {
              // Obsługa zdarzenia scrollowania
                ((Shape)(t.getSource())).setOnScroll(evt -> {
                    double deltaY = evt.getDeltaY(); // Odczytanie wartości przesunięcia myszy
                
                    // Zmiana skali na podstawie przesunięcia myszy
                    double scale = 1.0;
                    scale += deltaY / 100.0; // Można dostosować czynnik skalowania według własnych preferencji
              
                    ((Shape)(evt.getSource())).setScaleX(((Shape)(t.getSource())).getScaleX() * scale); //skalowanie
                    ((Shape)(evt.getSource())).setScaleY(((Shape)(t.getSource())).getScaleY() * scale);
                    
              });
              
            }
        }
    };   
  }