package ru.gudkova.reflection;

import ru.gudkova.reflection.Annotations.AValidate;
import ru.gudkova.reflection.Annotations.Invoke;
import ru.gudkova.reflection.Annotations.ToString;
import ru.gudkova.reflection.Annotations.Validate;
import static ru.gudkova.reflection.Annotations.YesNo.NO;
import static ru.gudkova.reflection.Annotations.YesNo.YES;

//@Validate(Atests.class)
@AValidate
public class A extends Entity{
    @ToString(NO)
    public String s = "Hel";
    @ToString(YES)
    public int x = 42;
    
    @Invoke
    String m1(){
        return "text";
    }
    
    String m2(){
        return "place";
    }
    
    @Invoke
    Integer m3(){
        return 42;
    }
}
