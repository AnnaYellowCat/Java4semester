package ru.gudkova.weapon;
public class Shooter {
    public String name;
    public Weapon weapon;
    
    public Shooter(String name){
        this.name = name;
    }
    public void shoot(){
        if (weapon != null){
            weapon.shoot();
        }
        else{
            System.out.println("I can't participate in a shootout");
        }
    }
}
