package ru.gudkova.numbers;

import java.util.ArrayList;
import java.util.List;
import ru.gudkova.reflection.Annotations.Cache;
import ru.gudkova.reflection.Mutator;

final public class Fraction extends Number implements Fractionable{
    private int ch;
    private int zn;
    private static List<Fraction> fractions = new ArrayList<>();
        
    public Fraction(int ch, int zn){
        this.ch = ch;
        if(zn<=0){
            throw new IllegalArgumentException("The denominator can't be negative or zero");
        }
        this.zn = zn;
    }
    public static Fraction createFraction(int ch, int zn){
        for(int i = 0; i<fractions.size(); i++){
            if (fractions.get(i).ch == ch && fractions.get(i).zn == zn){
                return fractions.get(i);
            }
        }
        fractions.add(new Fraction(ch, zn));
        return fractions.get(fractions.size()-1);
    }
        
    public int getZn(){
        return zn;
    }
    public int getCh(){
        return ch;
    }
    @Mutator
    public void setZn(int zn){
        this.zn = zn;
    }
    @Mutator
    public void setCh(int ch){
        this.ch = ch;
    }

    public String toString(){
        return ch + "/" + zn;
    }

    public Fraction sum(int n){
        int chis = ch + n*zn;
        return(new Fraction(chis, zn));
    }
    public Fraction sum(Fraction f){
        if(f == null){
            throw new IllegalArgumentException("Fraction is null(((");
        }
        int chis = ch * f.zn + f.ch * zn;
        int znam = zn*f.zn;
        return(new Fraction(chis, znam));
    }
    public Fraction minus(int n){
        int chis = ch - n*zn;
        return(new Fraction(chis, zn));
    }
    public Fraction minus(Fraction f){
        if(f == null){
            throw new IllegalArgumentException("Fraction is null(((");
        }
        int chis = ch * f.zn - f.ch * zn;
        int znam = zn*f.zn;
        return(new Fraction(chis, znam));
    }
    public Fraction mult(int n){
        int chis = ch*n;
        return(new Fraction(chis, zn));
    }
    public Fraction mult(Fraction f){
        if(f == null){
            throw new IllegalArgumentException("Fraction is null(((");
        }
        int chis = ch*f.ch;
        int znam = zn*f.zn;
        return(new Fraction(chis, znam));
    }
    public Fraction div(int n){
        int znam = zn*n;
        return(new Fraction(ch, znam));
    }
    public Fraction div(Fraction f){
        if(f == null){
            throw new IllegalArgumentException("Fraction is null(((");
        }
        int chis = ch*f.zn;
        int znam = zn*f.ch;
        return(new Fraction(chis, znam));
    }
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Fraction f = (Fraction)obj;
        if(ch == f.ch && zn == f.zn) return true;
        else return false;
    }
    public Fraction clone(){
        return(new Fraction(ch, zn));
    }


    @Override
    public int intValue() {
        return (int)ch/zn;
    }

    @Override
    public long longValue() {
        return (long)ch/zn;
    }

    @Override
    public float floatValue() {
        return (float)ch/zn;
    }

    @Override
    @Cache
    public double doubleValue() {
        return (double)ch/zn;
    }
}
