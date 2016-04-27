/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiyandao101
 */
public class Enemy extends Thread {

    @Override
    public void run() {
        Tank enemy = new Tank(700, 500);
//        while (true) {
            if (enemy.y > JavaProjectSample.tank.getY()) {
                enemy.rotate(2);
                while (enemy.y + enemy.eTank.getTranslateY() - JavaProjectSample.tank.getY() - JavaProjectSample.tank.getTranslateY() > 20) {
                    enemy.move(1, 3);
                    System.out.println("enemy " + enemy.eTank.getTranslateY());
                    System.out.println("mine " + JavaProjectSample.tank.getY());
                }
                System.out.println("worked");
                enemy.rotate(3);
                enemy.fire();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }
    }
}
