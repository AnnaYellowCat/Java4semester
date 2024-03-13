package ru.gudkova.point;
public class Point1d implements Cloneable{
    public int x;
    
    public Point1d(int x){
        this.x = x;
    }
    
    public String toString(){
        return ("{" + x + "}");
    }
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Point1d p = (Point1d)obj;
        if(x == p.x) return true;
        else return false;
    }
    public Point1d clone(){
        try{
            return(Point1d) super.clone();
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public double len(Point1d point){
        return(Math.sqrt( (point.x - this.x)*(point.x - this.x) ) );
    }
}