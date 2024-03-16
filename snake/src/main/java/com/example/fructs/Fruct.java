package com.example.fructs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.example.effects.Effect;

import javafx.scene.image.Image;

public abstract class Fruct{
    public final int x;
    public final int y;
    public final Image image;
    
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    protected Fruct(String path, int y, int x) throws FileNotFoundException{
        this.x = x;
        this.y = y;
        image = new Image(new FileInputStream(path));
    }

    public abstract ArrayList<Effect> getEffect();
    public abstract boolean isApple();
}
