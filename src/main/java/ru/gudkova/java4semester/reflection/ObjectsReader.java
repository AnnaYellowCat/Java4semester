package ru.gudkova.reflection;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ObjectsReader<T> {   //7.1.5
    String s;
    public ObjectsReader(String s){
        this.s = s;
    }
    public List<T> read() throws FileNotFoundException{
        File f = new File(s);
        Scanner sc = new Scanner(f);
        String name = "";
        while(sc.hasNext()){
            String ch = sc.next();
            while(!ch.equals("{")){
                name += ch;
                ch = sc.next();
            }
        }
    }
}
*/