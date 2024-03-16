package com.example.effects;

import com.example.Game;

public class EnhancingEffect extends Effect{

    @Override
    public void comeTrue() {
        Game.getInstance().getSnake().increaseSize();
    }
    
}

