package ru.gudkova.animals;
public class CollarAtt implements Meowable{
    Meowable cat;
    public CollarAtt(Meowable cat){
        this.cat = cat;
    }
    public void meow(){
        System.out.println("Attention!!!");
        cat.meow();
    }
    public String toString(){
        return ""+cat;
    }
}
