package com.example;

import com.example.effects.Effect;
import com.example.effects.NegativeEffect;
import com.example.effects.PositiveEffect;
import com.example.effects.ShieldEffect;
import com.example.effects.SpeedEffect;

public class NoPattern {
    int score = 10;

    class NoPatternFactory{
        public Effect getEffect(String effect){
            switch (effect) {
                case "bomb":
                    return new NegativeEffect();
                case "apple":
                    return new PositiveEffect();
                case "pepper":
                    return new SpeedEffect();
                case "shield":
                    return new ShieldEffect();
                default:
                    return new NegativeEffect();
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
