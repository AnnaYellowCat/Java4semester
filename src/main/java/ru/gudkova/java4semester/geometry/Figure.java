package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public abstract class Figure {
    private Point p;
    public Point getP(){
        return new Point(p.x, p.y);
    }
    public void setP(Point p){
        this.p = new Point(p.x, p.y);
    }
    public abstract int square();
    public abstract Broken getBroken();
}
