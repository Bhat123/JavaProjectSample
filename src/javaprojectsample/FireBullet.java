/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author hiyandao101
 */
class FireBullet extends Thread {

    Image imgBullet = new Image("file:bullet.png");
    ImageView bullet = new ImageView(imgBullet);
    ImageView tank;
    AnchorPane ancPane;

    public FireBullet(AnchorPane ancPane, ImageView tank) {
        this.tank = tank;
        this.ancPane = ancPane;
    }

    @Override
    public void run() {
        System.out.println("Works");
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                ancPane.getChildren().add(bullet);
//            }
//        });

        if (JavaProjectSample.side == 1) {
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
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ancPane.getChildren().add(bullet);
                }
            });
            System.out.println("askdjbagsd");
        } else if (JavaProjectSample.side == 2) {
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
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ancPane.getChildren().add(bullet);
                }
            });
            System.out.println("askdjbagsd");
        } else if (JavaProjectSample.side == 3) {
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
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ancPane.getChildren().add(bullet);
                }
            });
            System.out.println("askdjbagsd");
        } else if (JavaProjectSample.side == 4) {
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
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    ancPane.getChildren().add(bullet);
                }
            });
            System.out.println("askdjbagsd");
        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {
            Logger.getLogger(FireBullet.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
