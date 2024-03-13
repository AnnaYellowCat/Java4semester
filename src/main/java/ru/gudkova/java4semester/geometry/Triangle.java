package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class Triangle extends Figure{
    public Point p2;
    public Point p3;
    public Triangle(Point p1, Point p2, Point p3){
        setP(p1);
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public Broken getBroken(){
        Broken b1 = new Broken(getP(), p2, p3);
        return(b1);
    }
    public int square(){
        return (int)(0.5*((getP().x - p3.x)*(p2.y - p3.y) - (p2.x - p3.x)*(getP().y - p3.y)));
    }
    
}
