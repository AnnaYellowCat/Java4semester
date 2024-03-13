package ru.gudkova.karateka;

import ru.gudkova.karateka.Strike;

public class Kick implements Strike{
    private static final Kick k = new Kick();
    
    private Kick(){}
    
    public static Kick createKick(){
        return k;
    }
    public void perform(Karateka kar){
        kar.kick();
    }
}
