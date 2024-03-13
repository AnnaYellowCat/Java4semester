package ru.gudkova.karateka;
public enum EBelt {
    WHITE(10), YELLOW(30), RED(100), BLACK(500);
    private final int power;
    
    EBelt(int power){ 
        this.power = power;
    }
    
    public int getPower(){
        return power;
    }
}
