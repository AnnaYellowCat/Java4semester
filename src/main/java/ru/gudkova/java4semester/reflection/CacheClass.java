package ru.gudkova.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import ru.gudkova.reflection.Annotations.Cache;

public class CacheClass implements InvocationHandler{
    private Object object;
    private int hashcode;
    private Map<Method, Object> cache = new HashMap<>();
    
    public CacheClass(Object object){
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        method = object.getClass().getMethod(method.getName(), method.getParameterTypes());
        
        if(method.isAnnotationPresent(Mutator.class)){
            cache.clear();
        }
        if(cache.containsKey(method)){
            System.out.println("Cache:");
            return cache.get(method);
        }
        if(method.isAnnotationPresent(Cache.class)){
            cache.put(method, method.invoke(object, args));
            return cache.get(method);
        }
        return method.invoke(object, args);
    }
}
