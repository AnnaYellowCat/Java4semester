package ru.gudkova.karateka;

import ru.gudkova.karateka.Strike;

public class Punch implements Strike{
    public static final Punch p = new Punch();
    private Punch(){}
    public static Punch createPunch(){
        return p;
    }
    public void perform(Karateka kar){
        kar.punch();
    }
}