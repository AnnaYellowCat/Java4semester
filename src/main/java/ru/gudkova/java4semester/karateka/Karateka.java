package ru.gudkova.karateka;

import ru.gudkova.karateka.Belt;

public class Karateka {
    final String name;
    private Belt belt;
    
    
    public Karateka(String name, Belt belt){
        this.name = name;
        this.belt = belt;
    }
    
    public void kick(){
        System.out.println("Bam");
    }
    public void punch(){
        System.out.println("Kiya");
    }
    public void jumpKick(){
        System.out.println("Whoosh");
    }
}