package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class Rectangle extends Figure{
    public int side1;
    public int side2;
    private boolean isSquare;
    public Rectangle(Point point, int side1, int side2){
        setP(point);
        if(side1 <=0 || side2 <= 0){
            throw new IllegalArgumentException("The radius can't be negative or zero");
        } 
        this.side1 = side1;
        this.side2 = side2;
        if(side1 == side2){
            isSquare = true;
        }
        else{
            isSquare = false;
        }
    }
    public Rectangle(Point point, int side1){
        setP(point);
        this.side1 = side1;
        this.side2 = side1;
        isSquare = true;
    }
    
    public Broken getBroken(){
        Point p1 = new Point(getP().x+side1, getP().y);
        Point p2 = new Point(getP().x+side1, getP().y-side2);
        Point p3 = new Point(getP().x, getP().y-side2);
        Broken b1 = new BrokenClosed(getP(), p1, p2, p3);
        return(b1);
    }
    public int square(){
        return side1*side2;
    }
}
