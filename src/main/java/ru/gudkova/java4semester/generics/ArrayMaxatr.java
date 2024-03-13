package ru.gudkova.generics;

import java.util.function.Function;

public class ArrayMaxatr implements Function<int[], Integer>{
    public Integer apply(int[] arr){
        int mx = arr[0];
        for(int x: arr){
            if(x > mx) mx = x;
        }
        return (Integer)mx;
    }
}
