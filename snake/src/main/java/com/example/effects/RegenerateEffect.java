package com.example.effects;

import java.io.FileNotFoundException;

import com.example.Game;

public class RegenerateEffect extends Effect{

    @Override
    public void comeTrue() throws FileNotFoundException {
        Game.getInstance().regenerateFructs();
    }
    
}
