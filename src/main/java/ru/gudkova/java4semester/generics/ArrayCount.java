package ru.gudkova.generics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class ArrayCount implements BinaryOperator<int[]> {
    public int[] apply(int[] arr1, int[] arr2){
        int[] res = new int[1];
        res[0] = arr1.length+arr2.length;
        return res;
    }
}