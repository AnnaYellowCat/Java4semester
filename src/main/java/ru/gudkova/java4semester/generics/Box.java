package ru.gudkova.generics;
public class Box<T> {
    public T ob;
    
    public Box(){};
    public Box(T ob){
        this.ob = ob;
    }
    
    public T getOb(){
        T ob1 = ob;
        ob = null;
        return ob1;
    }
    
    public void setOb(T ob){
        if(this.ob == null){
            Box b = new Box<T>(ob);
            this.ob = (T)b.ob;
        }
        else{
            throw new IllegalArgumentException("The box is full already");
        }
    }
    
    public boolean isFull(){
        if(ob == null){
            return true;
        }
        return false;
    }
}
