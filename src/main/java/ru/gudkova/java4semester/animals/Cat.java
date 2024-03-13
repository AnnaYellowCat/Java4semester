package ru.gudkova.animals;
public class Cat implements Meowable{
    public String name;
    
    public Cat(String name){
        this.name = name;
    }
    
    public String toString(){
        return("Cat: " + name);
    }
    
    public void meow(){
        System.out.println(name + ": meow!");
    }
    public void meow(int n){
        String str = name + ": ";
        for(int i = 0; i<n; i++){
            if(i != n-1){
                str = str + "meow-";
            }
            else{
                str = str + "meow!";
            }
        }
        System.out.println(str);
    }
}
