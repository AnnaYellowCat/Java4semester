package ru.gudkova.generics;

import java.util.function.Predicate;

public class ArrayAbsFilter implements Predicate<int[]>{
    public boolean test(int[] arr){
        for(int val: arr){
            if(val > 0) return false;
        }
        return true;
    }
}