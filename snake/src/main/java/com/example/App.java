package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import com.example.effects.Effect;
import com.example.fructs.*;

public class App extends Application {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
    }

    Timeline timeline = new Timeline();
    final double delay = 160;
    Game game;

    private Pane[][] field = new Pane[23][23];

    private static Scene scene;

    ArrayList<Fruct> fructsOnFiedl = new ArrayList<>(); 

    final int lenX = 23, lenY = 23;

    private boolean isFreeCell(int x, int y, ArrayList<Fruct> objectOnFiedl){
        if(objectOnFiedl.isEmpty()) return true;
        for(int i=0;i<objectOnFiedl.size();i++){
            if(objectOnFiedl.get(i).getX() == x && objectOnFiedl.get(i).getY() == y){
                return false;
            }
        }
        return true;
    }

    private GridPane initField(){
        GridPane root = new GridPane();

        for(int i=0;i<lenX;i++){
            root.getRowConstraints().add(new RowConstraints());
            for(int j=0;j<lenY;j++){
                Pane cell = new Pane();
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)) cell.setStyle("-fx-background-color: #808080;");
                else cell.setStyle("-fx-background-color: #C0C0C0;");
                cell.setMinWidth(40);
                cell.setMinHeight(40);
                root.add(cell, i, j);
                field[i][j] = cell;
            }
        }

        return root;
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        
        GridPane grid = initField();
        Snake snake = new Snake(field, lenX, lenY);
        Label scoreLabel = new Label("0");
        scoreLabel.setStyle("-fx-font-size:20");
        

        VBox vbox = new VBox();
        vbox.getChildren().add(scoreLabel);
        vbox.getChildren().add(grid);

        StackPane root = new StackPane();
        
        Label l = new Label("GAME OVER");
        l.setStyle("-fx-font-size:50");
        l.setVisible(false);
        root.getChildren().add(vbox);
        root.getChildren().add(l);
        
        
        //grid.setGridLinesVisible(true);
        scene = new Scene(root);
        game = Game.getInstance(snake, fructsOnFiedl, scoreLabel, field, timeline, l);

        timeline.getKeyFrames().add(
            new KeyFrame(Duration.millis(delay), e -> {
                snake.updateSnake();
                ArrayList<Effect> effects = Game.getInstance().getEffects();
                while(effects.size()!=0){
                    try {
                        effects.get(0).comeTrue();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    effects.remove(0);
                }
                System.out.println("update");
            })
        );
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();

            switch (keyCode.getChar()) {
                case "W":
                    snake.setDirection(Direction.UP);
                    break;
                case "S":
                    snake.setDirection(Direction.DOWN);
                    break;
                case "D":
                    snake.setDirection(Direction.RIGHT);
                    break;
                case "A":
                    snake.setDirection(Direction.LEFT);
                    break;
                case "O":
                    timeline.stop();
                    break;
            }
            System.out.println("Key Pressed: " + keyCode.getChar());
        });

        Random rnd = new Random();
        for(int i=0; i<5; i++){
            int r,c;
            do{
                r = rnd.nextInt(20);
                c = rnd.nextInt(20);
            } while(!isFreeCell(r, c, fructsOnFiedl));
            Apple bomb = new Apple(r,c);
            fructsOnFiedl.add(bomb);
            System.out.print("Apple ");
            System.out.print(r);
            System.out.print(" ");
            System.out.println(c);
            ImageView imageView = new ImageView(bomb.image);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);

            field[c][r].getChildren().add(imageView);
        }

        stage.setTitle("SNAKE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}