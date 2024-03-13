package ru.gudkova.city;
public class TownBothWays extends Town{
    public TownBothWays(String name){
        super(name);
    }
    public void addRoads(Road...r){
        super.addRoads(r);
        Road[] sum = new Road[r.length+getRoads().length];
        int i = 0;
        int lengthRoads = getRoads().length;
        int flag;
        int k;
        for(i=0; i<r.length; i++){
            sum[i+lengthRoads] = r[i];
            flag = 0;
            for(k=0; k<r[i].dest.getRoads().length; k++){
                if(r[i].dest.getRoads()[k].dest.equals(this)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                r[i].dest.addRoads(new Road(r[i].cost, this));
            }
        }
    }
    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
