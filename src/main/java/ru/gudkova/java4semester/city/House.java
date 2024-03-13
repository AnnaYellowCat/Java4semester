package ru.gudkova.city;
public class House {
    private final int n;
    
    public House(int n){
        if(n<=0){
            throw new IllegalArgumentException("The number of floors can't be negative or zero");
        }
        this.n = n;
    }
    
    public int getN(){
        return(n);
    }
    public String toString(){
        int n1 = n;
        while(n1>99){
            n1 %= 100;
        }
        if(n1 == 11 || (n1%10) != 1){
            return("Dom s " + n + " etazhami");
        }
        else{
            return("Dom s " + n + " etazhom");
        }
    }
}
