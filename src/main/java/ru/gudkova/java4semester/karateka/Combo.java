package ru.gudkova.karateka;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    public List<Strike> strikes = new ArrayList<>();
    
    public Combo(Strike...strikes){
        for(Strike strike : strikes){
            this.strikes.add(strike);
        }
    }
    
    public void perform(Karateka kar){
        for(Strike strike : strikes){
            strike.perform(kar);
        }
    }
}
