package com.example.fructs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.effects.*;;

public class Pepper extends Fruct{

    public Pepper(int x, int y) throws FileNotFoundException {
        super(Resoueces.pathToImgPepper,x,y);
    }

    @Override
    public ArrayList<Effect> getEffect() {
        return new ArrayList<>(Arrays.asList(new NegativeEffect(), new SpeedEffect(), new RegenerateEffect()));
    }

    @Override
    public boolean isApple() {
        return false;
    }
    
}
