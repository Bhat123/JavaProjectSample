/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author hiyandao101
 */
public class Tank {

    public Image bImg = new Image("file:bullet.png");
    public ImageView eBullet = new ImageView(bImg);
    public Image eImg = new Image("file:enemy_full.png");
    public ImageView eTank = new ImageView(eImg);
    public int x;
    public int y;
    public int side = 3;
    public boolean isMoving = false;
    public boolean isRotating = false;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        eTank.setX(x);
        eTank.setY(y);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                JavaProjectSample.ancPane.getChildren().add(eTank);
            }
        });
    }

    public void fire() {
        int frX = 0;
        int frY = 0;
        int toX = 0;
        int toY = 0;

        if (side == 1) {
            frX = (int)eTank.getTranslateX()+110;
            frY = (int)eTank.getTranslateY()+15;
            toX = 2000;
            toY = (int)eTank.getTranslateY();
        } else if (side == 2) {
            frX = (int)eTank.getTranslateX();
            frY = (int)eTank.getTranslateY();
            toX = (int)eTank.getTranslateX();
            toY = -2000;
        } else if (side == 3) {
            frX = (int)eTank.getTranslateX()-20;
            frY = (int)eTank.getTranslateY()+17;
            toX = -2000;
            toY = (int)eTank.getTranslateY();
        } else if (side == 4) {
            frX = 94;
            frY = 293;
            toX = 94;
            toY = +2000;
        }
        eBullet = new ImageView(new Image("file:bullet.png"));
        this.eBullet.setFitHeight(20);
        this.eBullet.setFitWidth(20);
        TranslateTransition enBullet = new TranslateTransition();
        enBullet.setDuration(Duration.millis(1000));
        enBullet.setNode(this.eBullet);
        enBullet.setFromX(this.eTank.getX() + frX);
        enBullet.setFromY(this.eTank.getY() + frY);
        enBullet.setToX(this.eTank.getX() + toX);
        enBullet.setToY(this.eTank.getY() + toY);
        enBullet.play();
        Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        JavaProjectSample.ancPane.getChildren().add(eBullet);
                    }
    });
                }
    public void move(int time, int speed) {
        System.out.println("Moving");
        int ySpeed = 0;
        int xSpeed = 0;
        if (side == 2) {
            ySpeed = speed;
        } else if (side == 4) {
            ySpeed = -1 * speed;
        } else if (side == 1) {
            xSpeed = -1 * speed;
        } else if (side == 3) {
            xSpeed = speed;
        }

        TranslateTransition trTank = new TranslateTransition();
        trTank.setDuration(Duration.millis(time));
        trTank.setNode(eTank);
        trTank.setFromY(eTank.getTranslateY());
        System.out.println(eTank.getTranslateY() + "y");
        trTank.setToY(eTank.getTranslateY() - ySpeed);
        trTank.setFromX(eTank.getTranslateX());
        trTank.setToX(eTank.getTranslateX() - xSpeed);
//        trTank.setAutoReverse(true);
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

    public void rotate(int nSide) {
        int ang = 0;
        if (nSide - side == 1 || nSide == 1 && side == 4) {
            ang = -90;
        } else if (side - nSide == 1 || nSide == 4 && side == 1) {
            ang = 90;
        } else if (nSide - side == 2 || side - nSide == 2) {
            ang = 180;
        }
        if (this.isRotating == false) {
            RotateTransition rt = new RotateTransition(Duration.millis(500), this.eTank);
            rt.setByAngle(ang);
//            rt.setAutoReverse(true);
            this.isRotating = true;
            rt.setOnFinished(e -> this.isRotating = false);
            rt.play();
            this.side = nSide;
        }
    }
}
