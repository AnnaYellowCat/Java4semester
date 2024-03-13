package ru.gudkova.geometry;

import ru.gudkova.point.*;

public class Line<T extends Point2d> implements Lenable{
    private T start;
    private T end;
    
    public Line(){}
    public Line(T start, T end){
        this.start = (T)start.clone();
        this.end = (T)end.clone();
    }
    public static Line<Point2d> createLine2d(int x1, int y1, int x2, int y2){
        return new Line(new Point2d(x1, y1), new Point2d(x2, y2));
    }
    public static Line<Point3d> createLine3d(int x1, int y1, int z1, int x2, int y2, int z2){
        return new Line(new Point3d(x1, y1, z1), new Point3d(x2, y2, z2));
    }
    
    public T getStart(){
        return (T)start.clone();
    }
    public T getEnd(){
        return (T)end.clone();
    }
    public void setStart(T start){
        this.start = (T)start.clone();
    }
    public void setEnd(T end){
        this.end = (T)end.clone();
    }
    public String toString(){
        return ("Line from " + start + " to " + end);
    }
    
    public float len(){
        return (float)start.len(end);
    }
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Line l = (Line)obj;
        if(start.equals(l.start) && end.equals(l.end)) return true;
        else return false;
    }
    public Line<T> clone(){
        try{
            return (Line) super.clone();
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
