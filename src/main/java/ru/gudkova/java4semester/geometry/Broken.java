package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class Broken implements Lenable{
    public Point[] points = new Point[0];
    
    public Broken(){
    }
    public Broken(Point...points){
        this.points = points;
    }
    
    public String toString(){
        String str = "Liniya [";
        for(int i = 0; i<points.length; i++){
            str = str + points[i];
            if (i+1 != points.length) str = str + ", ";
        }
        return(str + "]");
    }
    
    public void add(Point...points2){
        Point[] sum = new Point[points.length + points2.length];
        int i = 0;
        for(; i<points.length; i++){
            sum[i] = points[i];
        }
        for(i = 0; i<points2.length; i++){
            sum[i + points.length] = points2[i];
        }
        this.points = sum;
    }
    
    public float len(){
        float sum = 0;
        for(int i = 0; i<points.length-1; i++){
            sum += Math.sqrt( (points[i+1].x - points[i].x)*(points[i+1].x - points[i].x) + (points[i+1].y - points[i].y)*(points[i+1].y - points[i].y) );
        }
        return sum;
    }
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Broken br = (Broken)obj;
        if (br.points.length == points.length){
            for(int i = 0; i<points.length; i++){
                if(!(points[i].equals(br.points[i]))) return false;
            }
            return true;
        }
        else return false;
    }
}