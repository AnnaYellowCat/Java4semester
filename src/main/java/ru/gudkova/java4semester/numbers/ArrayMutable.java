package ru.gudkova.numbers;
import java.util.Arrays;
public class ArrayMutable<T> {    //доделать...
    private T[] numbers = (T[])new Object[0];
    private int len = 0;
    
    public ArrayMutable(){} 
    public ArrayMutable(T...numbers){
        this.numbers = numbers;
        len = numbers.length;
    }
    public ArrayMutable(ArrayMutable array){
        this((T)array.numbers);
    }
    
    public void addInEnd(int...numbers){
        T[] sum = Arrays.copyOf(this.numbers, this.numbers.length + numbers.length);
        System.arraycopy(numbers, 0, sum, this.numbers.length, numbers.length);
        len = sum.length;
        this.numbers = sum;
    }
    public void addInEnd(ArrayMutable array){
        T[] sum = Arrays.copyOf(this.numbers, this.numbers.length + array.numbers.length);
        System.arraycopy(array.numbers, 0, sum, this.numbers.length, array.numbers.length);
        len = sum.length;
        this.numbers = sum;
    }
    public void add(int n, int...numbers){
        if(n<0 || n>=len){
            throw new IllegalArgumentException("The position of the element must be >=0 and <length of list");
        }
        T[] sum = (T[])new Object[this.numbers.length+numbers.length];
        System.arraycopy(this.numbers, 0, sum, 0, n);
        System.arraycopy(numbers, 0, sum, n, numbers.length);
        System.arraycopy(this.numbers, n, sum, n+numbers.length, this.numbers.length-n);
        len = sum.length;
        this.numbers = sum;
    }
    public void add(int n, ArrayMutable array){
        if(n<0 || n>=len){
            throw new IllegalArgumentException("The position of the element must be >=0 and <length of list");
        }
        T[] sum = (T[])new Object[this.numbers.length+array.numbers.length];
        System.arraycopy(this.numbers, 0, sum, 0, n);
        System.arraycopy(array.numbers, 0, sum, n, array.numbers.length);
        System.arraycopy(this.numbers, n, sum, n+array.numbers.length, this.numbers.length-n);
        len = sum.length;
        this.numbers = sum;
    }
    public void del(int n){
        if(n<0 || n>=len){
            throw new IllegalArgumentException("The position of the element must be >=0 and <length of list");
        }
        T[] sum = (T[])new Object[this.numbers.length-1];
        System.arraycopy(this.numbers, 0, sum, 0, n);
        System.arraycopy(this.numbers, n+1, sum, n, this.numbers.length-n-1);
        len = sum.length;
        this.numbers = sum;
    }
    public T get(int n){
        if(n<0 || n>=len){
            throw new IllegalArgumentException("The position of the element must be >=0 and <length of list");
        }
        return(numbers[n]);
    }
    public void replace(int n, T number){
        if(n<0 || n>=len){
            throw new IllegalArgumentException("The position of the element must be >=0 and <length of list");
        }
        numbers[n] = number;
    }
    public String toString(){
        String str = "[";
        for(int i = 0; i<numbers.length; i++){
            if(i!=numbers.length-1){
                str = str + numbers[i] + ",";
            }
            else{
                str = str + numbers[i];
            }
        }
        str = str+"]";
        return str;
    }
    public boolean isEmpty(){
        if(len == 0){
            return true;
        }
        else return false;
    }
    public int getLength(){
        return len;
    }
    public T[] getArray(){
        return Arrays.copyOf(this.numbers, this.numbers.length);
    }
}