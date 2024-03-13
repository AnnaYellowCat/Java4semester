package ru.gudkova.numbers;
public class Time {
    private int n;
    
    public Time(){}
    public Time(int n){
        setN(n);
    }
    public Time(int h, int m, int s){
        this(h*3600 + m*60 + s);
    }
    
    public int getN(){
        return n;
    }
    public void setN(int n){
        if(n<0){
            throw new IllegalArgumentException("The number of seconds can't be negative");
        }  
        n %= 86400;
        this.n = n;
    }
    public String toString(){
        String str = "";
        int hour = whatHour();
        int min = whatMinute();
        int sec = whatSecond();
        if(hour == 0){
            str = str + "00:";
        }
        if(hour <= 9 && hour != 0){
            str = str + "0" + hour + ":";
        }
        if(hour > 9){
            str = str + hour + ":";
        }
        if(min == 0){
            str = str + "00:";
        }
        if(min <= 9 && min != 0){
            str = str + "0" + min + ":";
        }
        if(min > 9){
            str = str + min + ":";
        }
        if(sec == 0){
            str = str + "00";
        }
        if(sec <= 9 && sec != 0){
            str = str + "0" + sec;
        }
        if(sec > 9){
            str = str + sec;
        }
        return (str);
    }
    
    public int whatHour(){
        return( n/3600 );
    }
    public int whatMinute(){
        return( (n/60) %60);
    }
    public int whatSecond(){
        return( n%60 );
    }
    
}
