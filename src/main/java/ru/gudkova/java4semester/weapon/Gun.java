package ru.gudkova.weapon;
public class Gun extends Weapon{
    public final int maxBul;
    
    public Gun(){
        this(30, 0);
    }
    public Gun(int maxBul){
        this(maxBul, 0);
    }
    public Gun(int maxBul, int ammo){
        super(ammo);
        if(maxBul<0){
            throw new IllegalArgumentException("The numbers of bullets can't be negative");
        }
        this.maxBul = maxBul;
    }
    
    public int getMaxBul(){
        return maxBul;
    }
    public void shoot(){
        if (getAmmo() == true){
            System.out.println("Bang!");
        }
        else{
            System.out.println("Clack!");
        }
    }
    /*int reload(int ammo){
        if(ammo<0){
            throw new IllegalArgumentException("The numbers of bullets can't be negative");
        }
        if(ammo>=maxBul-ammo()){
            int restBul = maxBul-ammo();
            load(restBul);
            return(ammo - restBul);
        }
        load(ammo);
        return 0;
    }*/
    public void load(int ammo){
        if(ammo() + ammo <= maxBul){
            super.load(ammo);
        }
        else{
            if(ammo<0){
                throw new IllegalArgumentException("The numbers of bullets can't be negative");
            }
            super.load(maxBul - ammo());
        }
    }
    public int unload(){
        int n = ammo;
        ammo = 0;
        return(n);
    }
    public boolean isLoaded(){
        if(ammo() != 0){
            return true;
        }
        return false;
    }
}
