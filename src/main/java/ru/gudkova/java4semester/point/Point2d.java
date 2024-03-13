package ru.gudkova.point;
public class Point2d extends Point1d implements Cloneable{
    public int y;
    
    public Point2d(int x, int y){
        super(x);
        this.y = y;
    }
    
    public String toString(){
        return ("{" + x + ";" + y + "}");
    }
    
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Point2d p = (Point2d)obj;
        if(x == p.x && y == p.y) return true;
        else return false;
    }
    public Point2d clone(){
        try{
            return(Point2d) super.clone();
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public double len(Point2d point){
        return(Math.sqrt( (point.x - this.x)*(point.x - this.x) + (point.y - this.y)*(point.y - this.y) ) );
    }
}