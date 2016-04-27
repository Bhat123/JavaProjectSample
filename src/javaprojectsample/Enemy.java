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
    int x;
    int y;
    public Enemy (int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void run() {
        Tank enemy = new Tank(x, y);
        while (true) {
            try {
            if (enemy.y + enemy.eTank.getTranslateY() - JavaProjectSample.tank.getY() - JavaProjectSample.tank.getY() > 20 ) {
                enemy.rotate(2);
                System.out.println("1st case");
                while (enemy.y + enemy.eTank.getTranslateY() - JavaProjectSample.tank.getY() - JavaProjectSample.tank.getTranslateY() > 3) {
                    enemy.move(1, 5);
                    Thread.sleep(100);
                }
                enemy.rotate(3);
                Thread.sleep(1000);
            }
             
            else if (JavaProjectSample.tank.getY() + JavaProjectSample.tank.getY() - enemy.y - enemy.eTank.getTranslateY() > 20){
                enemy.rotate(4);
                System.out.println("2st case");
                while (JavaProjectSample.tank.getY() + JavaProjectSample.tank.getTranslateY() - enemy.y - enemy.eTank.getTranslateY() > 3) {
                    enemy.move(1, 5);
                    Thread.sleep(100);
                }
                enemy.rotate(3);
                Thread.sleep(1000);
            }
            else{
                System.out.println("3rd case");
                enemy.fire();
                Thread.sleep(1000);
            }
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
