package com.example.FructFactory;

import java.io.FileNotFoundException;

import com.example.fructs.Fruct;

public abstract class FructFactory {
    public abstract Fruct getFruct(int x, int y) throws FileNotFoundException;
}
