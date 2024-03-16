package com.example.effects;

import java.io.FileNotFoundException;

import com.example.Game;

public class ShieldEffect extends Effect{

    @Override
    public void comeTrue() throws FileNotFoundException {
        Game.getInstance().getSnake().isProtected(true);
    }
    
}
