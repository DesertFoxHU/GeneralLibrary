package me.desertfox.gl;

import java.util.Random;

public class Commons {

    public static boolean roll(double chance){
        return (new Random().nextDouble() * 100) <= chance;
    }

}
