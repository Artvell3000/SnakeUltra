package com.example.fructs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.effects.*;

public class Shield extends Fruct{

    public Shield(int x, int y) throws FileNotFoundException {
        super(Resoueces.pathToImgShield,x,y);
    }

    @Override
    public ArrayList<Effect> getEffect() {
        return new ArrayList<>(Arrays.asList(new ShieldEffect(), new DeleteEatenObjEffect()));
    }
    
    @Override
    public boolean isApple() {
        return false;
    }
}