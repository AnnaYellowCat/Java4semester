package ru.gudkova.point;
public class Point {
    public int x;
    public int y;
    
    public Point(){}
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return ("{" + x + ";" + y + "}");
    }
    
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Point p = (Point)obj;
        if(x == p.x && y == p.y) return true;
        else return false;
    }
    public Point clone(){
        return(new Point(x, y));
    }
}
