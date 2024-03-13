package ru.gudkova.city;
public class Town {
    public String name;
    private Road[] roads = new Road[0];
    
    public Town(){}
    public Town(String name){
        this(name, new Road[0]);
    }
    public Town(String name, Road...roads){
        this.name = name;
        addRoads(roads);
    }
    
    public Road[] getRoads(){
        Road[] roadsCopy = new Road[roads.length];
        for(int i = 0; i<roadsCopy.length; i++){
            roadsCopy[i] = roads[i];
        }
        return roadsCopy;
    }
    public void setRoads(Road...roads){
        this.roads = roads.clone();
    }
    public String toString(){
        String str = "";
        for(int i = 0; i<roads.length; i++){
            str = str + roads[i] + " ";
        }
        return name + " - " + str;
    }
    public void addRoads(Road...r){
        Road[] sum = new Road[r.length+roads.length];
        int i = 0;
        for(; i<roads.length; i++){
            sum[i] = roads[i];
        }
        for(i=0; i<r.length; i++){
            sum[i+roads.length] = r[i];
        }
        for(i = 0; i<sum.length-1; i++){
            for(int j = i+1; j<sum.length; j++){
                if(sum[i].dest == sum[j].dest){
                    throw new IllegalArgumentException("There can only be one direct road between two cities");
                }
            }
        }
        this.roads = sum;
    }
    public void deleteRoad(Road r){
        int i = 0;
        int n = -1;
        Road[] sum = new Road[roads.length-1];
        for(; i<roads.length; i++){
            if(roads[i].equals(r)){
                n = i;
                break;
            }
        }
        if(n!=-1){
            for(i=0; i<n; i++){
            sum[i] = roads[i];
            }
            for(i=n+1; i<roads.length; i++){
                sum[i-1] = roads[i];
            }
            this.roads = sum;
        }
    }
    
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Town t = (Town)obj;
        boolean flag = false;
        if(roads.length == t.roads.length){
            for(int i = 0; i<roads.length; i++){
                for(int j = 0; j<roads.length; j++){
                    if(roads[i] == t.roads[j]) flag = true;
                }
                if(flag == true){
                    flag = false;
                }
                else return false;
            }
            return true;
        }
        return false;
    }
}
