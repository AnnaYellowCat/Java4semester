package ru.gudkova.main;

import ru.gudkova.reflection.B;
import ru.gudkova.reflection.Atests;
import ru.gudkova.reflection.D;
import ru.gudkova.reflection.A;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.management.OperationsException;

import ru.gudkova.animals.*;
import ru.gudkova.city.*;
import ru.gudkova.geometry.*;
import ru.gudkova.humans.*;
import ru.gudkova.numbers.*;
import ru.gudkova.point.*;
import ru.gudkova.weapon.*;
import ru.gudkova.karateka.*;
import ru.gudkova.generics.*;


public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException{
        Methods m = new Methods();
        
        TownBothWays a = new TownBothWays("A");   //3.3.9
        Town b = new Town("B");
        Town c = new Town("C");
        TownBothWays d = new TownBothWays("D");
        Town e = new Town("E");
        
        Road ab = new Road(0, b);
        a.addRoads(ab);
        Road ac = new Road(0, c);
        a.addRoads(ac);
        Road bc = new Road(0, c);
        b.addRoads(bc);
        Road ec = new Road(0, c);
        e.addRoads(ec);
        Road db = new Road(0, b);
        d.addRoads(db);
        Road de = new Road(0, e);
        d.addRoads(de);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println();
        
        
        /*Fraction fr = new Fraction(3, 5);   //3.3.1
        System.out.println(m.sum(2, fr, 2.3));
        Fraction fr2 = new Fraction(49, 12);
        Fraction fr3 = new Fraction(3, 2);
        System.out.println(m.sum(3.6, fr2, 3, fr3));
        Fraction fr4 = new Fraction(1, 3);
        System.out.println(m.sum(fr4, 1));
        System.out.println();*/
        
        
        
        /*NameBuilder nb = new NameBuilder();
        nb.setSurname("Сидоров");
        nb.setPersname("Иван");
        Name sidIvan = nb.create();*/
        
        Name name2 = new NameBuilder()
                .setPersname("Иван")
                .setSurname("Сидоров")
                .create();
        
        
        /*Fraction fr5 = new Fraction(11, 3);   //4.1.3
        BigInteger bg = new BigInteger("12345678912345678912");
        System.out.println(m.sum(7, fr5, 3.21, bg));
        System.out.println();*/
        
        
        
        System.out.println(m.extent(args[0], args[1]));      //4.1.4
        System.out.println();
        
        
        
        Point p = new Point(2, 3);   //4.1.5
        System.out.println(p);
        java.awt.Point p1 = new java.awt.Point(8, 9);
        System.out.println(p1);
        System.out.println();
        
        
        
        Fraction frac1 = Fraction.createFraction(2, 3);
        Fraction frac2 = Fraction.createFraction(2, 3);
        System.out.println(frac1 == frac2);
        System.out.println();
        
        
        
        /*Karateka kar = new Karateka("Daniel", Belt.BLACK);    //karateka
        Combo comb = new Combo(Kick.createKick(), Punch.createPunch(), Kick.createKick(), JumpKick.createJumpKick());
        comb.perform(kar);
        System.out.println();*/
        
        
        
        Town a1 = new Town("B");    //3.4.5
        a1.addRoads(ab);
        a1.addRoads(ac);
        System.out.println(a.equals(a1));
        
        System.out.println(Operations.PLUS.getClass().getSuperclass());
        System.out.println();
        
        
        
        
        Box<Integer> box = new Box<>(3);   //5.1.1
        System.out.println(box.getOb());
        //System.out.println(m.sum(box, 4));
        
        
        
        Student st1 = new Student("Mark", 5, 4, 5);   //5.1.4
        Student st2 = new Student("Kate", 3, 4, 5);
        System.out.println(st1.compare(st2));
        System.out.println();
        
        
        
        /*Line<Point2d> line = new Line<>(-1, 1, 1, 0, 0, 0);   //5.1.5
        System.out.println(line);
        System.out.println(m.shift(line));  //5.2.1*/
        
        /*class M{}
        class A extends M{}
        class B extends A{}
        class Holder<T>{
            T ob;
            void setObject(T ob){
                this.ob = ob;
            }
        }
        Holder<? super A> h = new Holder<M>();
        h.setObject(new B());*/
        System.out.println();
        
        
        
        Storage stor1 = Storage.createStorage(2);   //5.2.2
        Storage stor2 = Storage.createStorage(0);
        Storage stor3 = Storage.createStorage(2.3);
        System.out.println(m.mx(stor1, stor2, stor3));
        System.out.println();
        
        
        
        Box boxic = new Box<Point2d>();  //5.2.3
        m.pointInBox(boxic);
        System.out.println(boxic.getOb());
        System.out.println();
        
        
        
        ArrayMutable arr = new ArrayMutable<Object>(0.0, 0.0, 0.0);  //5.2.4
        m.fillArr(arr);
        System.out.println(arr);
        System.out.println();
        
        
        
        /*List<String> list1 = List.of("qwerty", "asdfg", "zx");   //5.3.1
        List<Integer> list2 = List.of(1, -3, 7);
        int[] arr1 = {3, 8, 5};
        int[] arr2 = {-9, 1, 2};
        int[] arr3 = {-5, -5, -5};
        List<int[]> list3 = List.of(arr1, arr2, arr3);
        System.out.println(Methods.map(list1, value -> value.length()));
        System.out.println(Methods.map(list2, value -> Math.abs(value)));
        System.out.println(Methods.map(list3, new ArrayMaxatr()));
        System.out.println();
        
        
        System.out.println(Methods.filter(list1, value -> value.length()>=3));   //5.3.2
        System.out.println(Methods.filter(list2, value -> value<0));
        List<int[]> listRes = new ArrayList<>();
        listRes = Methods.filter(list3, new ArrayAbsFilter());
        for(int i  = 0; i<listRes.size(); i++){
            for(int j = 0; j<listRes.get(i).length; j++){
                System.out.println(listRes.get(i)[j]);
            }
        }
        System.out.println();
        
        
        
        System.out.println(Methods.reduce(list1, (value1, value2) -> value1+value2));  //5.3.3
        System.out.println(Methods.reduce(list2, (value1, value2) -> value1+value2));
        int[] res = Methods.reduce(list3, new ArrayCount()).get();
        for(int x: res){
            System.out.println(x);
        }
        System.out.println();
        
        
        
        List<String> list4 = new ArrayList<String>();  //5.3.4
        list4.add("qwerty");
        list4.add("asdfg");
        list4.add("zx");
        list4.add("qw");
        List<String> list5 = new ArrayList<String>();
        list5.add("qwerty");
        list5.add("asdfg");
        list5.add("qwerty");
        list5.add("qw");
        /*System.out.println(Methods.collect(list2, () -> {Map<Boolean, List<Integer>> map = new HashMap();
                                                                map.put(true, new ArrayList<>());
                                                                map.put(false, new ArrayList<>());
                                                                return map;},
                                             (map,  val) -> map.get(val<0).add(val)));
        
        Supplier<Map<Integer, List<String>>> sup = () -> {return new HashMap();};
        BiConsumer<Map<Integer, List<String>> map, String s> biCons = (map, s) -> {
            int len = s.length();
            if(!map.containsKey(len)) map.put(len, new ArrayList<>());
            map.get(len).add(s);
        };
        System.out.println(Methods.collecting(list4, sup, biCons));
        //System.out.println(Methods.collecting(list5, obj3, obj6));*/
        
        
        
        /*int result = MyStream.of("abc", "'", "efgcd")
                             .filter(x -> !x.startsWith("a"))
                             .map(x -> x.length())
                             .reduce((x, y) -> x+y, 0);
        System.out.println(result);
        System.out.println();*/
        
        
        
        Cat cat = new Cat("Barsik");
        CollarCount collar = new CollarCount(cat);
        m.meow(collar);
        System.out.println(collar);
        System.out.println();
        
        
        
        CollarAtt collar2 = new CollarAtt(cat);
        m.meow(collar2);
        System.out.println();
        
        
        
        CollarAtt collar3 = new CollarAtt(collar);
        m.meow(collar3);
        System.out.println(collar3);
        System.out.println();
        
        
        
        Point2d point1 = new Point2d(0, 0);
        Point2d point2 = new Point2d(0, 1);
        Line line = new Line(point1, point2);
        MyString str = new MyString("rgei");
        
        System.out.println(m.len(line, str));
        
        System.out.println();
        
        String res = Stream.of("asd", "qWE", "Pop", "ap", "rr")
                .filter(x -> !x.contains("a"))
                .filter(x -> !x.contains("A"))
                .map(x -> x.toLowerCase())
                .reduce((x, y) -> x+" "+y)
                .orElse("");
        System.out.println(res);
        /*List<String> res2 = Stream.of("Asd", "fkd", "Ahfu", "fdj")
                .filter(x -> x.startsWith("A"))
                .map(x -> x+"!")
                .sorted()
                .toList;*/
                //.collect(ArrayList::new,(x, y)-> x.add(y), (x, y) ->);
        //res2.sort(Comparator.naturalOrder());
        //System.out.println(res2);
        System.out.println();
        
        
        /*Scanner scan = new Scanner(System.in);
        int res3 = IntStream.generate(()->scan.nextInt())
                .limit(10)
                .sum();
        System.out.println(res3);*/
        
        Stream.iterate(1, x->x*2)
                .limit(15)
                .forEach(x->System.out.println(x));
        System.out.println();
        
        //flatMap(x -> Arrays.asList(x.toCharArray()).stream())
        
        long res5 = Stream.of("abc", "aed", "Qec")
                .flatMapToInt(x -> x.chars())
                .distinct()
                .count();
        System.out.println(res5);
        System.out.println(); 
        
//--------------------------------------------------------------------------------------------        
//--------------------------------------------------------------------------------------------
        
        GunRifle gf = new GunRifle();    //7.1.1
        System.out.println(m.fieldCollection(gf));
        System.out.println(); 
        
        
        Line l1 = Line.createLine2d(1, 1, 5, 5);   //7.1.2
        Line l2 = Line.createLine2d(6, 6, 0, 0);
        m.lineConnector(l1, l2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(); 
        
        
        B bb = new B();  //7.1.3
        D dd = new D();
        A aa = new A();
        System.out.println(dd);
        System.out.println();
        
        
        m.validate(aa); //7.1.4+7.3.4+7.3.5(?) как узнать, чем проаннотирована аннотация именно при объявлении, а не при использовании
        System.out.println("Happy!");
        System.out.println();
        
        //7.1.5
        
        Fractionable fraction = new Fraction(1, 2); //7.1.6+7.3.6
        fraction = m.cache(fraction);
        System.out.println(fraction.doubleValue());
        System.out.println(fraction.doubleValue());
        fraction.setCh(12);
        System.out.println(fraction.doubleValue());
        System.out.println(fraction.doubleValue());
        System.out.println(fraction.doubleValue());
        System.out.println();
        
        System.out.println(m.collect(A.class));  //7.3.1
        System.out.println();
        
        //7.3.2
        
        System.out.println(aa);  //7.3.3
    }
}























