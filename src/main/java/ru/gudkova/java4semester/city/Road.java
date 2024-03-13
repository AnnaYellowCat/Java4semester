package ru.gudkova.city;
public class Road {
    public int cost;
    public Town dest;
    
    public Road(){}
    public Road(int cost, Town dest){
        this.cost = cost;
        this.dest = dest;
    }
    
    public String toString(){
        return (dest.name + ": " + cost);
    }
}
