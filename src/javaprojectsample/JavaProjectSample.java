/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hiyandao101
 */
public class JavaProjectSample extends Application {
    Image imgFile;
    Image imgHead;
    ImageView tank;
    ImageView head;
    
    
    private final Rectangle2D TANK_DOWN = new Rectangle2D(26, 1, 60, 85);
    private final Rectangle2D TANK_UP = new Rectangle2D(796, 96, 60, 85);
    private final Rectangle2D TANK_RIGHT = new Rectangle2D(664, 200, 98, 56);
    private final Rectangle2D TANK_LEFT = new Rectangle2D(890, 18, 94, 56);
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    AnchorPane ancPane = new AnchorPane();  
    
    imgHead = new Image("file:head.png");
    imgFile = new Image("file:3.png");
    head = new ImageView(imgHead);
    head.setFitHeight(30);
    head.setFitWidth(30);
    head.setX(10);
    head.setY(10);
//    head.getTransforms().add(new Rotate(45));
    tank = new ImageView(imgFile);
    tank.setViewport(TANK_DOWN);
    tank.setFitHeight(50);
    tank.setFitWidth(50);
    ancPane.getChildren().addAll(tank, head);
    Scene scene = new Scene(ancPane, 500, 200, Color.GREEN); 
    primaryStage.setScene(scene);
    primaryStage.show();
    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    
        @Override
        public void handle(KeyEvent keyEvent) {
            System.out.println(tank.getTranslateX() + ": X");
            System.out.println(tank.getTranslateY() + ": Y");
            if(keyEvent.getCode().toString() == "RIGHT"){
                tank.setViewport(TANK_RIGHT);
                TranslateTransition trTank = new TranslateTransition();
                trTank.setDuration(Duration.millis(200));
                trTank.setNode(tank);
                trTank.setFromX(tank.getTranslateX());
                trTank.setToX(tank.getTranslateX()+50);
                trTank.play();
            }
            
            if(keyEvent.getCode().toString() == "UP"){

                tank.setViewport(TANK_UP);
                TranslateTransition trTank = new TranslateTransition();
                trTank.setDuration(Duration.millis(200));
                trTank.setNode(tank);
                trTank.setFromY(tank.getTranslateY());
                trTank.setToY(tank.getTranslateY()-50);
                trTank.play();
            }
            if(keyEvent.getCode().toString() == "DOWN"){
                tank.setViewport(TANK_DOWN);
                TranslateTransition trTank = new TranslateTransition();
                trTank.setDuration(Duration.millis(200));
                trTank.setNode(tank);
                trTank.setFromY(tank.getTranslateY());
                trTank.setToY(tank.getTranslateY()+50);
                trTank.play();
            }
            if(keyEvent.getCode().toString() == "LEFT"){
                tank.setViewport(TANK_LEFT);
                TranslateTransition trTank = new TranslateTransition();
                trTank.setDuration(Duration.millis(200));
                trTank.setNode(tank);
                trTank.setFromX(tank.getTranslateX());
                trTank.setToX(tank.getTranslateX()-50);
                trTank.play();
            }               
        }
    });

}

    /**
     * @param args the command line argument
     * 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
