package ru.gudkova.reflection;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

public class Annotations {
    
    @Retention(RUNTIME)  //7.2.1
    @Target(METHOD)
    public @interface Invoke{
    }
    
    @Retention(RUNTIME)  //7.2.2
    @Target({TYPE, FIELD})
    public @interface Default{
        Class value();
        String str() default "hello";
        int in() default 42;
    }
    
    public enum YesNo{YES, NO};  //7.2.3
    @Retention(RUNTIME)
    @Target({TYPE, FIELD})
    public @interface ToString{
        YesNo value() default YesNo.YES;
    }
    
    @Retention(RUNTIME)  //7.2.4
    @Target({TYPE, ANNOTATION_TYPE})
    public @interface Validate{
        Class[] value();
    }
    @Retention(RUNTIME)  //7.3.5
    @Target({TYPE, ANNOTATION_TYPE})
    @Validate(Atests.class)
    public @interface AValidate{
    }
    
    @Retention(RUNTIME)  //7.2.5
    @Target(TYPE)
    public @interface Two{
        String first();
        int second();
    }
    
    @Retention(RUNTIME)  //7.2.6
    @Target(METHOD)
    public @interface Cache{
        String[] value() default {};
    }
}