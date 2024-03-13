package ru.gudkova.generics;
public class Storage<T>{
    private final T ob;
    
    private Storage(T ob){
        this.ob = ob;
    }
    
    public static<T> Storage<T> createStorage(T ob){
        return new Storage(ob);
    }
    
    public T getOb(T deflt){
        if(ob == null){
            return deflt;
        }
        else return ob;
    }
}
