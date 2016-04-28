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
            if (enemy.y + enemy.eTank.getTranslateY() - JavaProjectSample.tank.getY() - JavaProjectSample.tank.getTranslateY() > 20 ) {
                enemy.rotate(2);
                System.out.println("1st case");
                while (enemy.y + enemy.eTank.getTranslateY() - JavaProjectSample.tank.getY() - JavaProjectSample.tank.getTranslateY() > 3) {
                    enemy.move(1, 5);
                    Thread.sleep(100);
                }
                if( enemy.x + enemy.eTank.getTranslateX() > JavaProjectSample.tank.getX() + JavaProjectSample.tank.getTranslateX()){
                    enemy.rotate(3);
                }
                else{
                    enemy.rotate(1);
                }
                Thread.sleep(1000);
            }
             
            else if (JavaProjectSample.tank.getY() + JavaProjectSample.tank.getTranslateY() - enemy.y - enemy.eTank.getTranslateY() > 20){
                enemy.rotate(4);
                System.out.println("2st case");
                while (JavaProjectSample.tank.getY() + JavaProjectSample.tank.getTranslateY() - enemy.y - enemy.eTank.getTranslateY() > 3) {
                    enemy.move(1, 5);
                    Thread.sleep(100);
                }
                if( enemy.x + enemy.eTank.getTranslateX() > JavaProjectSample.tank.getX() + JavaProjectSample.tank.getTranslateX()){
                    enemy.rotate(3);
                }
                else{
                    enemy.rotate(1);
                }
                Thread.sleep(1000);
            }
            else{
                System.out.println("3rd case");
                for(int i = 0; i < 10; i++){
                    enemy.fire();
                }
                Thread.sleep(1000);
            }
            while(Math.abs(JavaProjectSample.tank.getX() + JavaProjectSample.tank.getTranslateX() - enemy.x - enemy.eTank.getTranslateX()) > 100){
                if(Math.abs(JavaProjectSample.tank.getY() + JavaProjectSample.tank.getTranslateY() - enemy.y - enemy.eTank.getTranslateY()) > 70){
                    System.out.println("worked");
                    break;
                }
                enemy.move(1, 5);
                enemy.fire();
                Thread.sleep(100);
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
