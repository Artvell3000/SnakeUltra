package com.example.effects;

import java.io.FileNotFoundException;

import com.example.Game;

public class DeleteEatenObjEffect extends Effect {

    
    @Override
    public void comeTrue() throws FileNotFoundException {
        Game.getInstance().deleteEatenObject();
    }
    
}
