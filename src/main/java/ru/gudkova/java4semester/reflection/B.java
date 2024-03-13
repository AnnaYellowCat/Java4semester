package ru.gudkova.reflection;

import ru.gudkova.reflection.Annotations.Default;

@Default(B.class)
public class B extends A{
    String s;
    int x;
    A a;
    Object ob;
    
    public String text = "B";
}
