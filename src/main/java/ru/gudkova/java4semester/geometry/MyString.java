package ru.gudkova.geometry;
public class MyString implements Lenable{
    String str;
    public MyString(String str){
        this.str = str;
    }
    @Override
    public float len(){
        return str.length();
    }
}
