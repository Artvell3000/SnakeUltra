package com.example.FructFactory;

import java.io.FileNotFoundException;

import com.example.fructs.Bomb;
import com.example.fructs.Fruct;

public class BombFactory extends FructFactory{

    @Override
    public Fruct getFruct(int x, int y) throws FileNotFoundException {
        return new Bomb(x,y);
    }
    
}
