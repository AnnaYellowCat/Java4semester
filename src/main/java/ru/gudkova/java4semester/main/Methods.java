package ru.gudkova.main;

import ru.gudkova.reflection.Atests;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

import ru.gudkova.animals.*;
import ru.gudkova.city.*;
import ru.gudkova.geometry.*;
import ru.gudkova.humans.*;
import ru.gudkova.numbers.*;
import ru.gudkova.point.*;
import ru.gudkova.weapon.*;
import ru.gudkova.karateka.*;
import ru.gudkova.generics.*;
import ru.gudkova.reflection.Annotations.Default;
import ru.gudkova.reflection.Annotations.Invoke;
import ru.gudkova.reflection.Annotations.Validate;
import ru.gudkova.reflection.CacheClass;

public class Methods{
    public double sum(Number... numbers){
        double res = 0;
        for(Number number : numbers){
            res += number.doubleValue();
        }
        return res;
    }
    public void sing(Bird...birds){
       for (Bird bird : birds) {
           bird.sing();
       }
    }
    public int square(Figure...figures){
       int sum = 0;
       for(Figure figure : figures){
           sum += figure.square();
       }
       return sum;
    }
    public void meow(Meowable...meowings){
       for(Meowable meowing : meowings){
           meowing.meow();
       }
    }
    public void sirena(Meowable...meowings){
        System.out.println("Attention!");
        
    }
    public float len(Lenable...lens){
       float sum = 0;
       for(Lenable len : lens){
           sum += len.len();
       }
       return sum;
    }
    public Broken broken(Figure...figures){
       Broken b = new Broken();
       for(Figure figure : figures){
           b.add(figure.getBroken().points);
       }
       return b;
    }
    public double extent(String x, String y){
        double res = pow(parseInt(x), parseInt(y));
        return res;
    }
    public Student best(Student...students){
        double highest = 0;
        Student bestStud = null;
        for(int i = 0; i<students.length; i++){
            if(students[i].average() != null){
                if(students[i].average() == Optional.of((double)5)){
                    return students[i];
                }
                if(students[i].average().get() > Optional.of((double)highest).get()){
                    highest = students[i].average().get();
                    bestStud = students[i];
                }
            }
        }
        return bestStud;
    }
    
    public Line shift (Line<? super Point2d> line){
        Point2d point = line.getStart();
        if(point.x >= 0) point.x += 10;
        else point.x -= 10;
        line.setStart(point);
        return line;
    }
    public double mx(Storage<? extends Number>...storages){
        double mx = storages[0].getOb(null).doubleValue();
        for(int i = 1; i<storages.length; i++){
            if(storages[i].getOb(null).doubleValue() > mx) mx = storages[i].getOb(null).doubleValue();
        }
        return mx;
    }
    public void pointInBox(Box<? super Point3d> box){
        int n1 = (int)(Math.random() * (2000 + 1))-1000;
        int n2 = (int)(Math.random() * (2000 + 1))-1000;
        int n3 = (int)(Math.random() * (2000 + 1))-1000;
        Point3d point = new Point3d(n1, n2, n3);
        box.setOb(point);
    }
    public void fillArr(ArrayMutable<? super Integer> arr){
        int n;
        for(int i = 0; i<arr.getLength(); i++){
            n = (int)(Math.random() * (99+1))+1;
            arr.replace(i, n);
        }
    }
    
    public static<T, P> List<P> map(List<T> list, Function<T, P> fun){
        List<P> listRes = new ArrayList<P>();
        for(T val: list){
            listRes.add( fun.apply(val) );
        }
        return listRes;
    }
    public static<T> List<T> filter(List<T> list, Predicate<T> rule){
        List<T> listRes = new ArrayList<T>();
        for(T val: list){
            if(rule.test(val)) listRes.add(val);
        }
        return listRes;
    }
    public static<T> Optional<T> reduce(List<T> list, BinaryOperator<T> oper){
        if(list.size()!=0){
            T res = list.get(0);
            for(int i = 1; i<list.size(); i++){
                res = oper.apply(res, list.get(i));
            }
            return Optional.of(res);
        }
        else return null;
    }
    public static<T, P> P collect(List<T> list, Supplier<P> supplier, BiConsumer<T, P> consumer){
        P res = supplier.get();
        for(T x: list){
            consumer.accept(x, res);
        }
        return res;
    }
    public List<String> fieldCollection(Object ob){  //7.1.1
        Class cl = ob.getClass();
        Field[] fs = cl.getFields();
        Field[] fsp = cl.getDeclaredFields();
        List<String> names = new ArrayList<>();
        for(Field f: fs){
            names.add(f.getName());
        }
        for(Field f: fsp){
            names.add(f.getName());
        }
        Set<String> st = new HashSet<>(names);
        names.clear();
        names.addAll(st);
        return names;
    }
    //7.1.2:
    public void lineConnector(Line l1, Line l2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Class c1 = l1.getClass();
        Class c2 = l2.getClass();
        Field f1 = c1.getDeclaredField("end");
        f1.setAccessible(true);
        Field f2 = c1.getDeclaredField("start");
        f2.setAccessible(true);
        Point2d p = (Point2d)f1.get(l1);
        f2.set(l2, p);
    }
    //7.1.4+7.3.4:
    public void validate(Object...obs) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException{
        boolean flag = false;
        Validate anot = null;
        for(Object o: obs){
            Class cl = o.getClass();
            Annotation[] anots = cl.getAnnotations();
            for(Annotation an: anots){
                if(an.getClass().isAnnotationPresent(Validate.class)){
                    anot = an.getClass().getAnnotation(Validate.class);
                    flag = true;
                }
            }
            if(cl.isAnnotationPresent(Validate.class)){
                anot = (Validate)cl.getAnnotation(Validate.class);
                flag = true;
                
            }
            if(flag == true){
                Class[] classes = anot.value();
                for(Class c: classes){
                    Method[] ms = c.getDeclaredMethods();
                    for(Method m:ms){
                        m.invoke(c.newInstance(), o);
                    }
                }
            }
        }
    }
    //7.3.1:
    public Map collect(Class...cls) throws IllegalAccessException, InvocationTargetException, InstantiationException{
        Map methods = new HashMap();
        for(Class cl: cls){
            Method[] ms = cl.getDeclaredMethods();
            for(Method m: ms){
                m.setAccessible(true);
                if(m.getParameterCount()==0 && !m.getReturnType().equals(Void.TYPE) && m.isAnnotationPresent(Invoke.class)){
                    methods.put(m.getName(), m.invoke(cl.newInstance()));
                }   
            }
        }
        return methods;
    }
    public void reset(Object...obs){  //7.3.2(?)
        for(Object ob: obs){
            Class cl = ob.getClass();
            Field[] fs = cl.getFields();
            Field[] fsp = cl.getDeclaredFields();
            List<Field> fls = new ArrayList<>();
            for(Field f: fs){
                fls.add(f);
            }
            for(Field f: fsp){
                f.setAccessible(true);
                fls.add(f);
            }
            Set<Field> st = new HashSet<>(fls);
            fls.clear();
            fls.addAll(st);
            for(Field fl: fls){
                /*if(fl.isAnnotationPresent(Default.class)){
                    if(fl.getType()== String.class) fl.set(ob, ); //Непонятно, откуда брать дефолтные значения
                отдельные дефолтные классы для классов,
                там лежат мапы с дефолтными значениями
                }*/
            }
        }
    }
    public static <T> T cache(T t){  //7.1.6+7.3.6
        return (T)Proxy.newProxyInstance(
                t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                new CacheClass(t)
                );
    }
}