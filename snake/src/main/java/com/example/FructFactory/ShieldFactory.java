package com.example.FructFactory;

import java.io.FileNotFoundException;

import com.example.fructs.Fruct;
import com.example.fructs.Shield;

public class ShieldFactory extends FructFactory{

    @Override
    public Fruct getFruct(int x, int y) throws FileNotFoundException {
        return new Shield(x, y);
    }
    
}
