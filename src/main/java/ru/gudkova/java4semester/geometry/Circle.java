package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class Circle extends Figure{
    public int radius;
    public Circle(Point point, int radius){
        setP(point);
        if(radius<=0){
            throw new IllegalArgumentException("The radius can't be negative or zero");
        } 
        this.radius = radius;
    }
    
    public Broken getBroken(){
        throw new IllegalArgumentException("Circle can't be polygonal chain");
    }
    public int square(){
        return (int)Math.PI*radius*radius;
    }
}
