package ru.gudkova.karateka;

import java.util.ArrayList;
import java.util.List;

public class Belt implements Comparable<Belt>{
    public static final Belt WHITE = new Belt("White", 0);
    public static final Belt YELLOW = new Belt("Yellow", 1);
    public static final Belt RED = new Belt("Red", 2);
    public static final Belt BLACK = new Belt("Black", 3);
    
    private String color;
    private int rate;
    private static List<Belt> belts = new ArrayList<>();
    
    private Belt(String color, int rate){
        this.color = color;
        this.rate = rate;
        belts.add(this);
    }
    
    public static Belt of(String color){
        for(Belt b : belts){
            if(b.color.equals(color)) return b;
        }
        throw new RuntimeException();
    }
    
    public int compareTo(Belt belt){
        return this.rate-belt.rate;
    }
}