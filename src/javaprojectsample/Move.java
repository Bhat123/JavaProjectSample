/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author hiyandao101
 */
public class Move extends Thread{

    public String key;
    public Move(String key){
        this.key = key;
    }
    @Override
    public void run(){
        if (key == "D") {
//                tank.setViewport(TANK_RIGHT);
//                    tank.setImage(imgFileR);
                    if (JavaProjectSample.side != 1) {
                        int ang;
                        if (JavaProjectSample.side == 2) {
                            ang = 90;
                        } else if (JavaProjectSample.side == 4) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(JavaProjectSample.isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), JavaProjectSample.tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            JavaProjectSample.isRotating = true;
                            rt.setOnFinished(e -> JavaProjectSample.isRotating = false);
                            rt.play();
                            JavaProjectSample.side = 1;
                        }
                    } else {
                        if(JavaProjectSample.isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(300));
                            trTank.setNode(JavaProjectSample.tank);
                            trTank.setFromX(JavaProjectSample.tank.getTranslateX());
                            trTank.setToX(JavaProjectSample.tank.getTranslateX() + 40);
                            JavaProjectSample.isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    JavaProjectSample.isMoving = false;
                                }
                            });
                            trTank.play();
                            JavaProjectSample.checkCollision(JavaProjectSample.ancPane, JavaProjectSample.wall, JavaProjectSample.tank);
                        }
                        else{
                            System.out.println("it's moving");
                        }
                        
                    }

                }

                if (key == "W") {

//                tank.setViewport(TANK_UP);
//                    tank.setImage(imgFileU);
                    if (JavaProjectSample.side != 2) {
                        int ang;
                        if (JavaProjectSample.side == 3) {
                            ang = 90;
                        } else if (JavaProjectSample.side == 1) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(JavaProjectSample.isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), JavaProjectSample.tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            JavaProjectSample.isRotating = true;
                            rt.setOnFinished(e -> JavaProjectSample.isRotating = false);
                            rt.play();
                            JavaProjectSample.side = 2;
                        }
                    } else {
                        
                        if(JavaProjectSample.isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(JavaProjectSample.tank);
                            trTank.setFromY(JavaProjectSample.tank.getTranslateY());
                            trTank.setToY(JavaProjectSample.tank.getTranslateY() - 5);
                            trTank.setAutoReverse(true);
                            JavaProjectSample.isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    JavaProjectSample.isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
                if (key == "S") {
//                tank.setViewport(TANK_DOWN);
//                    tank.setImage(imgFile);
                    if (JavaProjectSample.side != 4) {
                        int ang;
                        if (JavaProjectSample.side == 1) {
                            ang = 90;
                        } else if (JavaProjectSample.side == 3) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(JavaProjectSample.isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), JavaProjectSample.tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            JavaProjectSample.isRotating = true;
                            rt.setOnFinished(e -> JavaProjectSample.isRotating = false);
                            rt.play();
                            JavaProjectSample.side = 4;
                        }
                        else{
                            System.out.println("is Rotating");
                        }
                    } else {
                        
                        if(JavaProjectSample.isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(JavaProjectSample.tank);
                            trTank.setFromY(JavaProjectSample.tank.getTranslateY());
                            trTank.setToY(JavaProjectSample.tank.getTranslateY() + 5);
                            trTank.setAutoReverse(true);
                            JavaProjectSample.isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    JavaProjectSample.isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
                if (key == "A") {
//                tank.setViewport(TANK_LEFT);
//                    tank.setImage(imgFileL);
                    if (JavaProjectSample.side != 3) {
                        int ang;
                        if (JavaProjectSample.side == 4) {
                            ang = 90;
                        } else if (JavaProjectSample.side == 2) {
                            ang = -90;
                        } else {
                            ang = 180;
                        }
                        if(JavaProjectSample.isRotating == false){
                            RotateTransition rt = new RotateTransition(Duration.millis(500), JavaProjectSample.tank);
                            rt.setByAngle(ang);
                            rt.setAutoReverse(true);
                            JavaProjectSample.isRotating = true;
                            rt.setOnFinished(e -> JavaProjectSample.isRotating = false);
                            rt.play();
                            JavaProjectSample.side = 3;
                        }
                        else{
                            System.out.println("is Rotating");
                        }
                    } else {
                        if(JavaProjectSample.isMoving == false){
                            TranslateTransition trTank = new TranslateTransition();
                            trTank.setDuration(Duration.millis(1));
                            trTank.setNode(JavaProjectSample.tank);
                            trTank.setFromX(JavaProjectSample.tank.getTranslateX());
                            trTank.setToX(JavaProjectSample.tank.getTranslateX() - 5);
                            trTank.setAutoReverse(true);
                            JavaProjectSample.isMoving = true;
                            System.out.println("1111 about to move");
                            trTank.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    JavaProjectSample.isMoving = false;
                                }
                            });
                            trTank.play();
                        }
                    }
                }
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Move.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
