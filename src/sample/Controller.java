package sample;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import sun.font.TrueTypeFont;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Controller {

    @FXML
    private Button deleteButton;

    @FXML
    private Button cloneButton;


    @FXML
    private RadioButton selectMoveButton;

    @FXML
    private RadioButton ellipseButton;

    @FXML
    private RadioButton rectangleButton;

    @FXML
    private RadioButton lineButton;

    @FXML
    private ColorPicker colorSelector;

    @FXML
    private Canvas canvas;

    @FXML
    private GraphicsContext gc;

    //La forme que l'on veux creer : ellipse, rectangle, line
    private String forme = "ellipse";

    //Le mode : clone or delete
    private String mode = "clone";

    private Color couleur = Color.WHITE;;

    private EventHandler cloneListener;
    private EventHandler deleteListener;
    private EventHandler colorListener;
    private EventHandler<MouseEvent> canvaListener;

    private EventHandler selectListener;
    private EventHandler ellipseListener;
    private EventHandler rectListener;
    private EventHandler lineListener;

    private ArrayList<Shape> tabShape = new ArrayList();

    @FXML
    public void initialize() {

        deleteButton.setDisable(true);
        cloneButton.setDisable(true);
        gc = canvas.getGraphicsContext2D();

        cloneListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                mode="clone";
            }
        };
        cloneButton.setOnMouseClicked(cloneListener);




        deleteListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                mode="delete";
            }
        };
        deleteButton.setOnMouseClicked(deleteListener);




        canvaListener = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();

                if(forme=="ellipse"){
                    gc.setFill(couleur);
                    gc.fillOval(x-25,y-25,50,50);

                    Shape c = new Ellipse(x-25,y-25,50,50);
                    c.setFill(couleur);
                    tabShape.add(c);

                }
                else if(forme=="rectangle"){
                    gc.setFill(couleur);
                    gc.fillRect(x-50,y-25,100,50);

                    Shape c = new Rectangle(x-50,y-25,100,50);
                    c.setFill(couleur);
                    tabShape.add(c);
                }
                else if(forme=="line"){
                    gc.setFill(couleur);
                    gc.fillRect(x,y,100,2);

                    Shape c = new Rectangle(x,y,100,2);
                    c.setFill(couleur);
                    tabShape.add(c);
                }
                else{
                    //mode "clone"
                    if(mode=="clone"){
                        for (Shape sh : tabShape) { //On regarde si on se trouve sur l'emplacement d'une forme precedement dessinée
                            //je dois recuperer les infos de chaque forme et les comparer avec la position de la souris pour savoir si la souris se trouve sur une forme
                            //Je n'ai plus le temps mais il faut cast la Shape pour utiliser les methode des rectangles et des ellipses

                            //Si on se trouve bien sur cette shape, on reproduit sa forme et sa couleur à l'endroit souhaité

                        }
                    }
                    else{ //mode = "delete"
                        for (Shape sh : tabShape) { //On regarde si on se trouve sur l'emplacement d'une forme precedement dessinée
                            //je dois recuperer les infos de chaque forme et les comparer avec la position de la souris pour savoir si la souris se trouve sur une forme
                            //Je n'ai plus le temps mais il faut cast la Shape pour utiliser les methode des rectangles et des ellipses

                            //Si on se trouve bien sur cette shape, on reproduit sur le canvas la meme forme avec la couleur de fond pour donner l'impression d'effacer
                            //Enfin on supprime la shape de l'arrayList
                        }
                    }
                }
            }
        } ;
        canvas.setOnMouseClicked(canvaListener);













        //Choix de la couleur
        colorListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                couleur = colorSelector.getValue();
            }
        };
        colorSelector.setOnAction(colorListener);










        //Choix de la forme
        selectListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteButton.setDisable(false);
                cloneButton.setDisable(false);
                forme ="none";
            }
        };
        selectMoveButton.setOnMouseClicked(selectListener);

        ellipseListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteButton.setDisable(true);
                cloneButton.setDisable(true);
                forme ="ellipse";
            }
        };
        ellipseButton.setOnMouseClicked(ellipseListener);

        rectListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteButton.setDisable(true);
                cloneButton.setDisable(true);
                forme ="rectangle";
            }
        };
        rectangleButton.setOnMouseClicked(rectListener);

        lineListener = new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteButton.setDisable(true);
                cloneButton.setDisable(true);
                forme ="line";
            }
        };
        lineButton.setOnMouseClicked(lineListener);


    }
}
