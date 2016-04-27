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
                            JavaProjectSample.move(1, 5, "right");
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
                            JavaProjectSample.move(1, 5, "up");
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
                            JavaProjectSample.move(1, 5, "down");
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
                            JavaProjectSample.move(1, 5, "left");
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
