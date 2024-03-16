package com.example.FructFactory;

import java.io.FileNotFoundException;

import com.example.fructs.Apple;
import com.example.fructs.Fruct;

public class AppleFactory extends FructFactory {

    @Override
    public Fruct getFruct(int x, int y) throws FileNotFoundException {
        return new Apple(x, y);
    }
    
}
