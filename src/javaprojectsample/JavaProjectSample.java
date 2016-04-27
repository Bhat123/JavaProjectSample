/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
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
    static ImageView tank;
    ImageView head;
    ImageView bullet;
    static ImageView wall;
    ImageView ground;
    static AnchorPane ancPane;

    double posX = 2;
    double posY = 2;
    public static int side = 1;
    int map[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    public static boolean isMoving = false;
    public static boolean isRotating = false;

    private final Rectangle2D TANK_DOWN = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_UP = new Rectangle2D(0, 0, 49, 71);
    private final Rectangle2D TANK_RIGHT = new Rectangle2D(0, 0, 71, 49);
    private final Rectangle2D TANK_LEFT = new Rectangle2D(0, 0, 71, 49);

    @Override
    public void start(Stage primaryStage) throws Exception {
        ancPane = new AnchorPane();
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
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 34; j++) {
                if (map[i][j] == 1) {
                    wall = new ImageView(imgWall);
                    wall.setFitHeight(40);
                    wall.setFitWidth(40);
                    wall.setX(posX);
                    wall.setY(posY);
                    ancPane.getChildren().add(wall);
                }
                if (map[i][j] == 0) {
                    ground = new ImageView(imgGround);
                    ground.setFitHeight(40);
                    ground.setFitWidth(40);
                    ground.setX(posX);
                    ground.setY(posY);
                    ancPane.getChildren().add(ground);
                }

                posX += 40;
            }
            posX = 2;
            posY += 40;
        }
        ancPane.getChildren().addAll(tank, star);
        Scene scene = new Scene(ancPane, 500, 200, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(tank.getTranslateX() + ": X");
                System.out.println(tank.getTranslateY() + ": Y");
                if (keyEvent.getCode().toString() == "D") {
                    Move mv = new Move("D");
                    mv.start();
//                    try {
//                        mv.join();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(JavaProjectSample.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
//
                if (keyEvent.getCode().toString() == "W") {
                    Move mv = new Move("W");
                    mv.start();
//                    try {
//                        mv.join();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(JavaProjectSample.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                if (keyEvent.getCode().toString() == "S") {
                    Move mv = new Move("S");
                    mv.start();
//                    try {
//                        mv.join();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(JavaProjectSample.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                if (keyEvent.getCode().toString() == "A") {
                    Move mv = new Move("A");
                    mv.start();
//                    try {
//                        mv.join();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(JavaProjectSample.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }

                FireBullet fb = new FireBullet(keyEvent);
                fb.start();
            }
        });

    }

    /**
     * @param args the command line argument
     *
     */
    static void checkCollision(AnchorPane pane, ImageView rect1, ImageView rect2) {

        rect2.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> arg0, Bounds oldValue, Bounds newValue) {
                if (rect1.intersects(newValue)) {
                    System.out.println("Collide");
                } else {
                    System.out.println("---not a collision---");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
