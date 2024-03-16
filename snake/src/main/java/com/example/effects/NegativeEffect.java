package com.example.effects;

import com.example.Game;

public class NegativeEffect extends Effect{

    @Override
    public void comeTrue() {
        Game.getInstance().decreaseScore();
    }

}