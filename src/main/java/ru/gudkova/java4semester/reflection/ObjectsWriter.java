package ru.gudkova.reflection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class ObjectsWriter {   //7.1.5
    String s;
    public ObjectsWriter(String s){
        this.s = s;
    }
    public void write(Object...objects) throws IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        File f = new File(s);
        FileWriter fw = new FileWriter(f);
        for(Object o:objects){
            Class c = o.getClass();
            fw.write(c.getName() + "{");
            Constructor[] cons = c.getConstructors();
            Parameter[] ps = cons[0].getParameters();
            for(Parameter p: ps){
                String pname = p.getName();
                fw.write(pname + "=");
                Field fd = c.getField(pname);
                fw.write(fd.get(o).toString());
                if(p != ps[ps.length-1]) fw.write(",");
            }
            fw.write("};");
        }
        fw.close();
    }
}
