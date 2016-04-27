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
    KeyEvent keyEvent;

    public FireBullet(KeyEvent keyEvent) {
        this.keyEvent = keyEvent;
    }

    @Override
    public void run() {
        if (keyEvent.getCode().toString() == "SPACE") {
            if (JavaProjectSample.side == 1) {
                bullet = new ImageView(imgBullet);
                JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        JavaProjectSample.ancPane.getChildren().add(bullet);
                    }
                });
            } else if (JavaProjectSample.side == 2) {
                bullet = new ImageView(imgBullet);
                JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        JavaProjectSample.ancPane.getChildren().add(bullet);
                    }
                });
            } else if (JavaProjectSample.side == 3) {
                bullet = new ImageView(imgBullet);
                JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        JavaProjectSample.ancPane.getChildren().add(bullet);
                    }
                });
            } else if (JavaProjectSample.side == 4) {
                bullet = new ImageView(imgBullet);
                JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    JavaProjectSample.ancPane.getChildren().add(bullet);
                }
            });
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(FireBullet.class
                        .getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
    }
}
