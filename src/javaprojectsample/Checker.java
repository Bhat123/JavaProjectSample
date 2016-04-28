/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import static javaprojectsample.JavaProjectSample.ancPane;
import static javaprojectsample.JavaProjectSample.bullet;
import static javaprojectsample.JavaProjectSample.imageTreeMap;
import static javaprojectsample.JavaProjectSample.imgBullet;
import static javaprojectsample.JavaProjectSample.imgReGround;
import static javaprojectsample.JavaProjectSample.interpolate;
import static javaprojectsample.JavaProjectSample.length;

/**
 *
 * @author user
 */
public class Checker extends Thread {
    
    @Override
    public void run() {
        while (true){
            try {
                for (int i = 0; i < imageTreeMap.size() ; i++) {
                    if (imageTreeMap.get(i).getBoundsInParent().intersects(bullet.getBoundsInParent())) {
                        System.out.println("Boom");
//                        interpolate();
//                          imageTreeMap.get(i).setImage(imgReGround);
                          
                      imageTreeMap.get(i).setImage(imgBullet);
                        imageTreeMap.get(i).setImage(imgReGround);
                        
                        imageTreeMap.remove(imageTreeMap.get(i));
                        JavaProjectSample.trBullet.stop();
                        bullet.setVisible(false);
//                        length--;
                        
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                JavaProjectSample.ancPane.getChildren().remove(bullet);
                                
                                
                                
                            }
                        });
                        
                    }
                }
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Checker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
