package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class Square extends Figure{
    public Point p;
    private int len;
    
    public Square(Point point, int len){
        this.p = point;
        if(len<=0){
            throw new IllegalArgumentException("The side length can't be negative or zero");
        } 
        this.len = len;
    }
    public Square(int x, int y, int len){
        this(new Point(x, y), len);
    }
    
    public int getLen(){
        return len;
    }
    public void setLen(int len){
        if(len<=0){
            throw new IllegalArgumentException("The side length can't be negative or zero");
        } 
        this.len = len;
    }
    public String toString(){
        return("Square at point " + p + " with side " + len);
    }
    
    public Broken getBroken(){
        Point p1 = new Point(p.x+len, p.y);
        Point p2 = new Point(p.x+len, p.y-len);
        Point p3 = new Point(p.x, p.y-len);
        Broken b1 = new BrokenClosed(p, p1, p2, p3);
        return(b1);
    }
    public int square(){
        return len*len;
    }
}
