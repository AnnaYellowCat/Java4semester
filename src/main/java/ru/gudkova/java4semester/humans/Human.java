package ru.gudkova.humans;
public class Human {
    private Name name;
    private int height;
    private final Human dad;
    
    public Human(String name, int height){
        this(new Name(name), height, null);
    }
    public Human(String name, int height, Human dad){
        this(new Name(name), height, dad);
    }
    public Human(Name name, int height){
        this(name, height, null);
    }
    public Human(Name name, int height, Human dad){
        this.name = name;
        if(height<0 || height>500){
            throw new IllegalArgumentException("Height must be positive and <500");
        }
        this.height = height;
        this.dad = dad;
    }
    
    public Human getDad(){
        return dad;
    }
    public Name getName(){
        return new Name(name.getName(), name.getSurname(), name.getSurname1());
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public String toString(){
        Human k = new Human("", 0);
        k = this;
        while(k.name.getSurname() == null && k.dad != null){
            if(k.dad.name.getSurname() != null){
                name.setSurname(k.dad.name.getSurname());
                break;
            }
            else{
                k = k.dad;
            }
        }
        if(name.getSurname1() == null && dad != null && dad.name.getName() != null){
            name.setSurname1(dad.name.getName() + "ovich");
        }
        return (name + ", rost: " + height);
    }
}
