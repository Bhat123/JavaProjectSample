/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import javafx.animation.RotateTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;

/**
 *
 * @author hiyandao101
 */
public class JavaProjectSample extends Application {
    
    Image imgFile;
    Image imgHead;
    Image imgFileU;
    Image imgFileR;
    Image imgFileL;
    Image imgBullet;
    ImageView tank;
    ImageView head;
    ImageView bullet;
    int side = 4;
    
    private final Rectangle2D TANK_DOWN = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_UP = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_RIGHT = new Rectangle2D(0, 0, 71, 49);
    private final Rectangle2D TANK_LEFT = new Rectangle2D(0, 0, 71, 49);
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ancPane = new AnchorPane();
        
        System.out.println("Modified by HFM");
//     Rectangle rect = new Rectangle (100, 40, 100, 100);
//     rect.setArcHeight(50);
//     rect.setArcWidth(50);
//     rect.setFill(Color.VIOLET);
//     
//     rect.setX(100);
//        
//     RotateTransition rt = new RotateTransition(Duration.millis(300), head);
//     rt.setByAngle(180);
//     rt.setCycleCount(4);
//     rt.setAutoReverse(true);

//     rt.play();
        imgHead = new Image("file:green_head.png");
        imgFile = new Image("file:final_body.png");
        imgFileU = new Image("file:final_up.png");
        imgFileR = new Image("file:final_right.png");
        imgFileL = new Image("file:final_left.png");
        head = new ImageView(imgHead);
        imgBullet = new Image("file:bullet.png");
        bullet = new ImageView(imgBullet);
//    head.setFitHeight(30);
        head.setFitWidth(34);
        head.setLayoutX(6);
        head.setLayoutY(1);
//    head.getTransforms().add(new Rotate(45, 17, 24));
        tank = new ImageView(imgFile);
//    tank.setViewport(TANK_DOWN);
//    tank.setFitHeight(50);
//    tank.setFitWidth(50);
        ancPane.getChildren().addAll(tank);
        Scene scene = new Scene(ancPane, 500, 200, Color.GREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(tank.getTranslateX() + ": X");
                System.out.println(tank.getTranslateY() + ": Y");
                if (keyEvent.getCode().toString() == "RIGHT") {
//                tank.setViewport(TANK_RIGHT);
//                    tank.setImage(imgFileR);
                    if (side != 1) {
                        int ang;
                        if (side == 2){ang = 90;}
                        else if (side == 4) {ang = -90;}
                        else{ang = 180;}
                        RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                        rt.setByAngle(ang);
                        rt.setAutoReverse(true);
                        rt.play();
                        side = 1;
                    } else {
                            TranslateTransition trTank = new TranslateTransition();
                        trTank.setDuration(Duration.millis(500));
                            trTank.setNode(tank);
                            trTank.setFromX(tank.getTranslateX());
                            trTank.setToX(tank.getTranslateX() + 50);
                            trTank.play();
                                }
                    
                }
                
                if (keyEvent.getCode().toString() == "UP") {

//                tank.setViewport(TANK_UP);
//                    tank.setImage(imgFileU);
                    if (side != 2) {
                        int ang;
                        if (side == 3){ang = 90;}
                        else if (side == 1) {ang = -90;}
                        else{ang = 180;}
                        RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                        rt.setByAngle(ang);
                        rt.setAutoReverse(true);
                        rt.play();
                        side = 2;
                    }else {
                        TranslateTransition trTank = new TranslateTransition();
                        trTank.setDuration(Duration.millis(500));
                        trTank.setNode(tank);
                        trTank.setFromY(tank.getTranslateY());
                        trTank.setToY(tank.getTranslateY() - 50);
                        trTank.play();
                    }
                }
                if (keyEvent.getCode().toString() == "DOWN") {
//                tank.setViewport(TANK_DOWN);
//                    tank.setImage(imgFile);
                    if (side != 4) {
                        int ang;
                        if (side == 1){ang = 90;}
                        else if (side == 3) {ang = -90;}
                        else{ang = 180;}
                        RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                        rt.setByAngle(ang);
                        rt.setAutoReverse(true);
                        rt.play();
                        side = 4;
                    } else {
                        TranslateTransition trTank = new TranslateTransition();
                        trTank.setDuration(Duration.millis(500));
                        trTank.setNode(tank);
                        trTank.setFromY(tank.getTranslateY());
                        trTank.setToY(tank.getTranslateY() + 50);
                        trTank.play();
                    }
                }
                if (keyEvent.getCode().toString() == "LEFT") {
//                tank.setViewport(TANK_LEFT);
//                    tank.setImage(imgFileL);
                    if (side != 3) {
                        int ang;
                        if (side == 4) {
                            ang = 90;
                        } else if (side == 2) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                        rt.setByAngle(ang);
                        rt.setAutoReverse(true);
                        rt.play();
                        side = 3;
                    } else {
                        TranslateTransition trTank = new TranslateTransition();
                        trTank.setDuration(Duration.millis(500));
                        trTank.setNode(tank);
                        trTank.setFromX(tank.getTranslateX());
                        trTank.setToX(tank.getTranslateX() - 50);
                        trTank.play();
                    }
                }
                if (keyEvent.getCode().toString() == "SPACE") {
                    
                    if (keyEvent.getCode().toString() == "SPACE") {
                        
                        bullet.setFitHeight(20);
                        bullet.setFitWidth(20);
                        if (side == 1) {
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 64);
                            trBullet.setFromY(tank.getTranslateY() + 34);
                            trBullet.setToX(tank.getTranslateX() + 2000);
                            trBullet.setToY(tank.getTranslateY() + 34);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 2) {
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 14);
                            trBullet.setFromY(tank.getTranslateY() - 18);
                            trBullet.setToX(tank.getTranslateX() + 14);
                            trBullet.setToY(tank.getTranslateY() - 2000);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 3) {
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() - 36);
                            trBullet.setFromY(tank.getTranslateY() + 33);
                            trBullet.setToY(tank.getTranslateY() + 33);
                            trBullet.setToX(tank.getTranslateX() - 2000);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 4) {
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 13);
                            trBullet.setFromY(tank.getTranslateY() + 85);
                            trBullet.setToX(tank.getTranslateX());
                            trBullet.setToY(tank.getTranslateY() + 2000);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        }
                    }
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
