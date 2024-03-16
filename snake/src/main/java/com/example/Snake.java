package com.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.example.App.Direction;
import com.example.effects.ExitTheField;
import com.example.fructs.Fruct;
import javafx.scene.layout.Pane;

public class Snake{
    Pane[][] field;
    int lenX, lenY;
    SnakeCell deadCell;
    boolean haveShield = false;

    Direction direction = Direction.UP;
    String styleProtected = "-fx-background-color: #ffd700;";
    String styleNoProteted = "-fx-background-color: green;";
    boolean isProtectedSnake = false;

    public boolean isProtected(){
        return isProtectedSnake;
    }

    public SnakeCell getHead(){
        return snake.get(0);
    }

    public void isProtected(boolean b){
        if(b){
            for(SnakeCell i:snake){
                i.snakePane.setStyle(styleProtected);
            }
        }
        else{
            for(SnakeCell i:snake){
                i.snakePane.setStyle(styleNoProteted);
            }
        }
        isProtectedSnake = b;
    }

    public class SnakeCell{
        public int x;
        public int y;
        public Pane snakePane;

        SnakeCell(int x, int y){
            this.x = x;
            this.y = y;
            snakePane = new Pane();
            snakePane.setStyle((isProtectedSnake)?styleProtected:styleNoProteted);
            snakePane.setMinWidth(40);
            snakePane.setMinHeight(40);
        }
    }

    ArrayList<SnakeCell> snake = new ArrayList<>(); 

    public ArrayList<SnakeCell> getSnakeArray(){
        return snake;
    }

    Snake(Pane[][] field, int lenX, int lenY) throws FileNotFoundException{
        this.field = field;
        this.lenX = lenX;
        this.lenY = lenY;

        SnakeCell head = new SnakeCell(lenX/2, lenY/2);
        snake.add(head);
        field[head.x][head.y].getChildren().add(head.snakePane);
    }

    public void increaseSize(){
        snake.add(deadCell);
        field[deadCell.x][deadCell.y].getChildren().add(deadCell.snakePane);
    }

    public void setDirection(Direction newDir){
        if(
            (direction == Direction.UP && newDir == Direction.DOWN) ||
            (direction == Direction.DOWN && newDir == Direction.UP) ||
            (direction == Direction.LEFT && newDir == Direction.RIGHT) ||
            (direction == Direction.RIGHT && newDir == Direction.LEFT)
        ) return;

        direction = newDir;
    }

    public void updateSnake(){
        SnakeCell newCell;
        switch (direction) {
            case UP:
                newCell = new SnakeCell(snake.get(0).x, snake.get(0).y - 1);
                break;
            case DOWN:
                newCell = new SnakeCell(snake.get(0).x, snake.get(0).y + 1);
                break;
            case RIGHT:
                newCell = new SnakeCell(snake.get(0).x + 1, snake.get(0).y);
                break;
            default:
            newCell = new SnakeCell(snake.get(0).x - 1, snake.get(0).y);
                break;
        }

        //var head = snake.get(0);
        //if(!head.snakePane.getChildren().isEmpty()) head.snakePane.getChildren().remove(0);
        snake.add(0,newCell);
        System.out.print(newCell.x);
        try{
            field[newCell.x][newCell.y].getChildren().add(newCell.snakePane);
            //newCell.snakePane.getChildren().add(viewShield);
            //newCell.snakePane.setStyle("-fx-background-color: red;");

        } catch(Exception e){
            Game.getInstance().getEffects().add(new ExitTheField());
        }
        

        for(Fruct i: Game.getInstance().getFructsOnField()){
            if(newCell.x == i.x && newCell.y == i.y){
                Game.getInstance().getEffects().addAll(i.getEffect());
            }
        }
        
        SnakeCell tail = snake.get(snake.size()-1);
        System.out.print(" ");
        System.out.println(tail.x);
        deadCell = tail;
        field[tail.x][tail.y].getChildren().remove(tail.snakePane);
        snake.remove(tail);
    }
}

