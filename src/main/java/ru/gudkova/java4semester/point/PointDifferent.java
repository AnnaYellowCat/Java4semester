package ru.gudkova.point;
public class PointDifferent{
    public Point1d p;
    private String color;
    private String time;
    
    public PointDifferent(int x){
        this.p = new Point1d(x);
    }
    public PointDifferent(int x, int y){
        this.p = new Point2d(x, y);
    }
    public PointDifferent(int x, int y, int z){
        this.p = new Point3d(x, y, z);
    }
    
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    
    public String toString(){
        String str = "";
        str = str + p;
        if (color != null){
            str = str + " color: " + color;
        }
        if(time != null){
            str = str + " time: " + time;
        }
        return str;
    }
}
