package ru.gudkova.geometry;

import ru.gudkova.point.Point;

public class BrokenClosed extends Broken{
    public BrokenClosed(Point...points){
        super(points);
    }
    public float len(){
        float sum = 0;
        for(int i = 0; i<points.length-1; i++){
            sum += Math.sqrt( (points[i+1].x - points[i].x)*(points[i+1].x - points[i].x) + (points[i+1].y - points[i].y)*(points[i+1].y - points[i].y) );
        }
        sum += Math.sqrt( (points[0].x - points[points.length-1].x)*(points[0].x - points[points.length-1].x) + (points[0].y - points[points.length-1].y)*(points[0].y - points[points.length-1].y) );
        return sum;
    }
}
