package ru.gudkova.animals;
public class CollarCount implements Meowable{
    Cat cat;
    int count = 0;
    public CollarCount(Cat cat){
        this.cat = cat;
    }
    public void meow(){
        cat.meow();
        count++;
    }
    public String toString(){
        return "" + count;
    }
}
