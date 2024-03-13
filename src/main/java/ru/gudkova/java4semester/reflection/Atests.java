package ru.gudkova.reflection;

import java.lang.reflect.Field;

public class Atests {
    public void test1(Object o) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Class cl = o.getClass();
        Field fx = cl.getField("x");
        int x = (int)fx.get(o);
        if(x<=0) throw new IllegalArgumentException("Error in test1: x must be more than 0");
    }
    public void test2(Object o) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Class cl = o.getClass();
        Field fs = cl.getField("s");
        String s = (String)fs.get(o);
        if(s.length()<=3) throw new IllegalArgumentException("Error in test2: s must be longer than 3");
    }
}
