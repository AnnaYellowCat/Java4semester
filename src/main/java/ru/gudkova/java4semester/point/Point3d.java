package ru.gudkova.point;
public class Point3d extends Point2d implements Cloneable{
    public int z;
    
    public Point3d(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
    public String toString(){
        return ("{" + x + ";" + y + ";" + z + "}");
    }
    
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Point3d p = (Point3d)obj;
        if(x == p.x && y == p.y && z == p.z) return true;
        else return false;
    }
    public Point3d clone(){
        try{
            return(Point3d) super.clone();
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public double len(Point3d point){
        return super.len(point);
    }
}