package com.example.effects;

import com.example.Game;

public class GameOverEffect extends Effect{

    @Override
    public void comeTrue() {
        if(!Game.getInstance().getSnake().isProtected()) Game.getInstance().stopGame();
        else{
            Game.getInstance().getSnake().isProtected(false);
        }
    }

}
