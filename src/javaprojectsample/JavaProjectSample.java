/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectsample;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.INDEFINITE;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
//import static javaprojectsample.FireBullet.bullet;

/**
 *
 * @author hiyandao101
 */
public class JavaProjectSample extends Application {
    static int length = 55;
    Image imgFile;
    Image imgHead;
    Image imgFileU;
    Image imgFileR;
    Image imgFileL;
    Image imgBullet;
    Image imgWall;
    Image imgGround;
    Image imgStar;
    Image imgHouse;
    public static boolean isFiring = false;
    public static Image imgReGround;
    ImageView star;
    ImageView ReGround;
    ImageView house;
    Image imgTree;
    ImageView tree;
    static ImageView tank;
    ImageView head;
    static ImageView bullet;
    static ImageView wall;
    ImageView ground;
    static AnchorPane ancPane;
    boolean collide = false;
    ;
    double posX = 2;
    double posY = 2;
    public static int side = 1;
    int map[][] = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    public static ArrayList<ImageView> imageTreeMap = new ArrayList<ImageView>();
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
        imgReGround = new Image("file:reground.jpg");
        imgHouse = new Image("file:house.png");
        imgHead = new Image("file:green_head.png");
        imgFile = new Image("file:final_body.png");
        imgFileU = new Image("file:final_up.png");
        imgFileR = new Image("file:final_right.png");
        imgFileL = new Image("file:final_left.png");
        imgWall = new Image("file:wall.jpg");
        imgGround = new Image("file:ground.jpg");
        imgStar = new Image("file:star2.png");
        imgTree = new Image("file:tree.png");

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
                if (map[i][j] == 0 || map[i][j] == 3) {
                    ground = new ImageView(imgGround);
                    ground.setFitHeight(40);
                    ground.setFitWidth(40);
                    ground.setX(posX);
                    ground.setY(posY);
                    ancPane.getChildren().add(ground);
                }
                if (map[i][j] == 3) {
                    tree = new ImageView(imgTree);
                    tree.setFitHeight(40);
                    tree.setFitWidth(40);
                    tree.setX(posX);
                    tree.setY(posY);
                    ancPane.getChildren().add(tree);
                    imageTreeMap.add(tree);
                }

                posX += 40;
            }
            posX = 2;
            posY += 40;
        }
        ancPane.getChildren().addAll(tank);

//        bullet.setX(-100);
//        bullet.setY(-100);
        Scene scene = new Scene(ancPane, 500, 200, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        Enemy thread1 = new Enemy(500, 600);
        thread1.start();
//        Enemy thread2 = new Enemy(500, 300);
//        thread2.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(tank.getTranslateX() + ": X");
                System.out.println(tank.getTranslateY() + ": Y");
                if (keyEvent.getCode().toString() == "D") {
                    Move mv = new Move("D");
                    if (tank.getTranslateX() + 60 > 1225) {
                    } else {
                        mv.start();
                    }
                    for (int i = 0; i < 55; i++) {
                        if (imageTreeMap.get(i).getBoundsInParent().intersects(tank.getBoundsInParent())) {
                            imageTreeMap.get(i).setImage(imgReGround);
                        };
                    }

                }
//
                if (keyEvent.getCode().toString() == "W") {

                    Move mv = new Move("W");
                    if (tank.getTranslateY() + 230 < 67) {
                        collide = true;
                    } else {
                        mv.start();
                    }
                    for (int i = 0; i < 55; i++) {
                        if (imageTreeMap.get(i).getBoundsInParent().intersects(tank.getBoundsInParent())) {
                            imageTreeMap.get(i).setImage(imgReGround);
                        };
                    }
                }
                if (keyEvent.getCode().toString() == "S") {
                    Move mv = new Move("S");
                    if (tank.getTranslateY() + 230 > 645) {
                        collide = true;
                    } else {
                        mv.start();
                    }
                    for (int i = 0; i < 55; i++) {
                        if (imageTreeMap.get(i).getBoundsInParent().intersects(tank.getBoundsInParent())) {
                            imageTreeMap.get(i).setImage(imgReGround);
                        };
                    }
                }
                if (keyEvent.getCode().toString() == "A") {
                    Move mv = new Move("A");
                    if (tank.getTranslateX() + 60 < 50) {
                        collide = true;
                    } else {
                        mv.start();
                    }
                    for (int i = 0; i < 55; i++) {
                        if (imageTreeMap.get(i).getBoundsInParent().intersects(tank.getBoundsInParent())) {
                            imageTreeMap.get(i).setImage(imgReGround);
                        };
                    }
                }
                if (keyEvent.getCode().toString() == "SPACE") {
//                    ancPane.getChildren().add(bullet);
                    if (JavaProjectSample.side == 1) {
//                bullet = new ImageView(imgBullet);
                        JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);

                    } else if (JavaProjectSample.side == 2) {
//                bullet = new ImageView(imgBullet);
                        JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
//                        JavaProjectSample.ancPane.getChildren().add(bullet);
                    } else if (JavaProjectSample.side == 3) {
//                bullet = new ImageView(imgBullet);
                        JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
//                        JavaProjectSample.ancPane.getChildren().add(bullet);
                    } else if (JavaProjectSample.side == 4) {
//                bullet = new ImageView(imgBullet);
                        JavaProjectSample.fireOwn(bullet, imgBullet, JavaProjectSample.side);
//                        JavaProjectSample.ancPane.getChildren().add(bullet);
//            try {
//                Thread.sleep(10);
//            } catch (Exception ex) {
//                Logger.getLogger(FireBullet.class
//                        .getName()).log(Level.SEVERE, null, ex);
//                System.out.println(ex);
//            }
                    }
                }
            }
        });
        Checker check = new Checker();
        check.start();

//        final Task task = new Task() {
//
//            @Override
//            protected Object call() throws Exception {
//                System.out.println("Music version ");
//                String musicFile = "back_music.mp3";
//                Media sound = new Media(new File(musicFile).toURI().toString());
//                MediaPlayer mediaPlayer = new MediaPlayer(sound);
//                mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
//                mediaPlayer.play();
//                return null;
//            }
//        };
//        Thread thread1 = new Thread(task);
//        thread1.start();
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

    static void move(int time, int speed, String direction) {
        int ySpeed = 0;
        int xSpeed = 0;
        if (direction.equals("up")) {
            ySpeed = speed;
        } else if (direction.equals("down")) {
            ySpeed = -1 * speed;
        } else if (direction.equals("right")) {
            xSpeed = -1 * speed;
        } else {
            xSpeed = speed;
        }

        TranslateTransition trTank = new TranslateTransition();
        trTank.setDuration(Duration.millis(time));
        trTank.setNode(JavaProjectSample.tank);
        trTank.setFromY(JavaProjectSample.tank.getTranslateY());
        trTank.setToY(JavaProjectSample.tank.getTranslateY() - ySpeed);
        trTank.setFromX(JavaProjectSample.tank.getTranslateX());
        trTank.setToX(JavaProjectSample.tank.getTranslateX() - xSpeed);
//        trTank.setAutoReverse(true);
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

    static void fireOwn(ImageView iv, Image img, int side) {
//        ancPane.getChildren().add(bullet);

        int frX = 0;
        int frY = 0;
        int toX = 0;
        int toY = 0;

        if (side == 1) {
            frX = 142;
            frY = 245;
            toX = 2000;
            toY = 245;
        } else if (side == 2) {
            frX = 96;
            frY = 197;
            toX = 96;
            toY = -2000;
        } else if (side == 3) {
            frX = 47;
            frY = 244;
            toX = -2000;
            toY = 245;
        } else if (side == 4) {
            frX = 94;
            frY = 293;
            toX = 94;
            toY = +2000;
        }
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        if (isFiring == false) {
            isFiring = true;
            TranslateTransition trBullet = new TranslateTransition();
            trBullet.setDuration(Duration.millis(3000));
            trBullet.setNode(iv);
            trBullet.setFromX(JavaProjectSample.tank.getTranslateX() + frX);
            trBullet.setFromY(JavaProjectSample.tank.getTranslateY() + frY);
            trBullet.setToX(JavaProjectSample.tank.getTranslateX() + toX);
            trBullet.setToY(JavaProjectSample.tank.getTranslateY() + toY);
            trBullet.setOnFinished(e -> isFiring = false);
            trBullet.play();
            ancPane.getChildren().add(bullet);
        }
//        while(true){
//        for (int i = 0; i < 55; i++) {
//            if (imageTreeMap.get(i).getBoundsInParent().intersects(iv.getBoundsInParent())) {
//                System.out.println("Boom");
//                imageTreeMap.get(i).setImage(imgReGround);
//                imageTreeMap.remove(imageTreeMap.get(i));
//                ancPane.getChildren().remove(bullet);
//            }
//        }
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
