package ru.gudkova.point;
import java.util.HashMap;
import java.util.Map;
public class PointMap {
    Map<String, String> params = new HashMap();
    
    public PointMap(){
    
    }
    public PointMap(Map params){
        this.params.putAll(params);
    }
    public String getParam(String key){
        if(params.containsKey(key)){
            return params.get(key);
        }
        return null;
    }
    public void putParam(String key, String value){
        params.put(key, value);
    }
    
    @Override
    public String toString(){
        return params.toString();
    }
}
