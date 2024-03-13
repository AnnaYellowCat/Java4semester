package ru.gudkova.animals;
public class Cuckoo extends Bird{
    public Cuckoo(){};
    public void sing(){
        int n = (int)(( Math.random() * 10 ) + 1);
        for(int i = 0; i<n; i++) System.out.println("cuckoo!");
    }
}
