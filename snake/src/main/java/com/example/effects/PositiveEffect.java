package com.example.effects;

import com.example.Game;

public class PositiveEffect extends Effect{

    @Override
    public void comeTrue() {
        Game.getInstance().increaseScore();
    }

}
