package com.example.effects;

import com.example.Game;

public class SpeedEffect extends Effect{

    @Override
    public void comeTrue() {
        Game.getInstance().speedIncrease();
    }
    
}
