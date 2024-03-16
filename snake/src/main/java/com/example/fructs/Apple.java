package com.example.fructs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.effects.*;

public class Apple extends Fruct{

    public Apple(int x, int y) throws FileNotFoundException {
        super(Resoueces.pathToImgApple,x,y);
    }

    @Override
    public ArrayList<Effect> getEffect() {
        return new ArrayList<>(Arrays.asList(new PositiveEffect(), new EnhancingEffect(), new RegenerateEffect()));
    }
    
    @Override
    public boolean isApple() {
        return true;
    }
}