/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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
    Image imgWall;
    Image imgGround;
    Image imgStar;
    ImageView star;
    ImageView tank;
    ImageView head;
    ImageView bullet;
    ImageView wall;
    ImageView ground;
    
    
    
    double posX = 2;
    double posY = 2;
    int side = 1;
    int map[][]={{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    boolean isMoving = false;
    boolean isRotating = false;
    
    private final Rectangle2D TANK_DOWN = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_UP = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_RIGHT = new Rectangle2D(0, 0, 71, 49);
    private final Rectangle2D TANK_LEFT = new Rectangle2D(0, 0, 71, 49);

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ancPane = new AnchorPane();
        primaryStage.setFullScreen(true);
        
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
        imgWall = new Image("file:wall.jpg");
        imgGround = new Image("file:ground.jpg");
        imgStar = new Image("file:star2.png");
        
        star = new ImageView(imgStar);
        star.setFitHeight(70);
        star.setFitWidth(70);
        star.setX(47);
        star.setY(327);
        head = new ImageView(imgHead);
        ground = new ImageView(imgGround);
        imgBullet = new Image("file:bullet.png");
        bullet = new ImageView(imgBullet);
//    head.setFitHeight(30);
        head.setFitWidth(34);
        head.setLayoutX(6);
        head.setLayoutY(1);
//    head.getTransforms().add(new Rotate(45, 17, 24));
        tank = new ImageView(imgFileR);
        tank.setX(60);
        tank.setY(230);
//    tank.setViewport(TANK_DOWN);
//    tank.setFitHeight(50);
//    tank.setFitWidth(50);
        for(int i = 0;i<19;i++){
            for(int j = 0; j<34;j++){
                if(map[i][j] == 1){
                wall = new ImageView(imgWall);
                wall.setFitHeight(40);
                wall.setFitWidth(40);
                wall.setX(posX);
                wall.setY(posY);
                ancPane.getChildren().add(wall);
                }
                if(map[i][j] == 0){
                ground = new ImageView(imgGround);
                ground.setFitHeight(40);
                ground.setFitWidth(40);
                ground.setX(posX);
                ground.setY(posY);
                ancPane.getChildren().add(ground);
                }
                
                posX+=40;
                }
            posX = 2;
            posY+=40;
        }
        ancPane.getChildren().addAll(tank,star);
        Scene scene = new Scene(ancPane, 500, 200, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(tank.getTranslateX() + ": X");
                System.out.println(tank.getTranslateY() + ": Y");
                if (keyEvent.getCode().toString() == "D") {
//                tank.setViewport(TANK_RIGHT);
//                    tank.setImage(imgFileR);
                    if (side != 1) {
                        int ang;
                        if (side == 2) {
                            ang = 90;
                        } else if (side == 4) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            isRotating = true;
                            rt.setOnFinished(e -> isRotating = false);
                            rt.play();
                            side = 1;
                        }
                    } else {
                        if(isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(tank);
                            trTank.setFromX(tank.getTranslateX());
                            trTank.setToX(tank.getTranslateX() + 5);
                            trTank.setAutoReverse(true);
                            isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                        else{
                            System.out.println("it's moving");
                        }
                        
                    }

                }

                if (keyEvent.getCode().toString() == "W") {

//                tank.setViewport(TANK_UP);
//                    tank.setImage(imgFileU);
                    if (side != 2) {
                        int ang;
                        if (side == 3) {
                            ang = 90;
                        } else if (side == 1) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            isRotating = true;
                            rt.setOnFinished(e -> isRotating = false);
                            rt.play();
                            side = 2;
                        }
                    } else {
                        
                        if(isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(tank);
                            trTank.setFromY(tank.getTranslateY());
                            trTank.setToY(tank.getTranslateY() - 5);
                            trTank.setAutoReverse(true);
                            isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
                if (keyEvent.getCode().toString() == "S") {
//                tank.setViewport(TANK_DOWN);
//                    tank.setImage(imgFile);
                    if (side != 4) {
                        int ang;
                        if (side == 1) {
                            ang = 90;
                        } else if (side == 3) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            isRotating = true;
                            rt.setOnFinished(e -> isRotating = false);
                            rt.play();
                            side = 4;
                        }
                        else{
                            System.out.println("is Rotating");
                        }
                    } else {
                        
                        if(isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(tank);
                            trTank.setFromY(tank.getTranslateY());
                            trTank.setToY(tank.getTranslateY() + 5);
                            trTank.setAutoReverse(true);
                            isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
                if (keyEvent.getCode().toString() == "A") {
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
                        if(isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            isRotating = true;
                            rt.setOnFinished(e -> isRotating = false);
                            rt.play();
                            side = 3;
                        }
                        else{
                            System.out.println("is Rotating");
                        }
                    } else {
                        if(isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(tank);
                            trTank.setFromX(tank.getTranslateX());
                            trTank.setToX(tank.getTranslateX() - 5);
                            trTank.setAutoReverse(true);
                            isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
                if (keyEvent.getCode().toString() == "SPACE") {

                    if (keyEvent.getCode().toString() == "SPACE") {

                        
                        if (side == 1) {
                            bullet = new ImageView(imgBullet);
                            bullet.setFitHeight(20);
                            bullet.setFitWidth(20);
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 142);
                            trBullet.setFromY(tank.getTranslateY() + 245);
                            trBullet.setToX(tank.getTranslateX() + 2000);
                            trBullet.setToY(tank.getTranslateY() + 245);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 2) {
                            bullet = new ImageView(imgBullet);
                            bullet.setFitHeight(20);
                            bullet.setFitWidth(20);
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 96);
                            trBullet.setFromY(tank.getTranslateY() + 197);
                            trBullet.setToX(tank.getTranslateX() + 96);
                            trBullet.setToY(tank.getTranslateY() - 2000);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 3) {
                            bullet = new ImageView(imgBullet);
                            bullet.setFitHeight(20);
                            bullet.setFitWidth(20);
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 47);
                            trBullet.setFromY(tank.getTranslateY() + 244);
                            trBullet.setToY(tank.getTranslateY() + 245);
                            trBullet.setToX(tank.getTranslateX() - 2000);
                            trBullet.play();
                            ancPane.getChildren().add(bullet);
                            System.out.println("askdjbagsd");
                        } else if (side == 4) {
                            bullet = new ImageView(imgBullet);
                            bullet.setFitHeight(20);
                            bullet.setFitWidth(20);
                            TranslateTransition trBullet = new TranslateTransition();
                            trBullet.setDuration(Duration.millis(1000));
                            trBullet.setNode(bullet);
                            trBullet.setFromX(tank.getTranslateX() + 94);
                            trBullet.setFromY(tank.getTranslateY() + 293);
                            trBullet.setToX(tank.getTranslateX() + 94);
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
