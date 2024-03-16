package com.example.fructs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.effects.*;

public class Bomb extends Fruct{

    public Bomb(int x, int y) throws FileNotFoundException {
        super(Resoueces.pathToImgBomb,x,y);
    }

    @Override
    public ArrayList<Effect> getEffect() {
        return new ArrayList<>(Arrays.asList(new GameOverEffect(), new DeleteEatenObjEffect()));
    }
    
    @Override
    public boolean isApple() {
        return false;
    }
}
