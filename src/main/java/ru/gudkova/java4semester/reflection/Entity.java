package ru.gudkova.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.gudkova.reflection.Annotations.ToString;
import static ru.gudkova.reflection.Annotations.YesNo.NO;

public abstract class Entity {   //7.1.3+7.3.3
    @Override
    public String toString(){
        Class cl = this.getClass();
        
        Field[] fs = cl.getFields();
        Field[] fsp = cl.getDeclaredFields();
        List<Field> fse = new ArrayList<>();
        for(Field f: fs){
            fse.add(f);
        }
        for(Field f: fsp){
            f.setAccessible(true);
            fse.add(f);
        }
        Set<Field> st = new HashSet<>(fse);
        fse.clear();
        fse.addAll(st);
        
        Class scl = cl;
        
        while(!scl.getSuperclass().getName().equals(Entity.class.getName())){
            scl = scl.getSuperclass();
        }
        
        String str = scl.getName()+"{";
        for(Field f:fse){
            boolean flag = true;
            if(f.isAnnotationPresent(ToString.class)){
                ToString anot = f.getAnnotation(ToString.class);
                if(anot.value()==NO) flag = false;
            }
            if(flag == true){
                try {
                    str+=f.getName()+"=" + f.get(this);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(f!=fs[fs.length-1]) str+=", ";
            }
        }
        return str+"}";
    }
}
