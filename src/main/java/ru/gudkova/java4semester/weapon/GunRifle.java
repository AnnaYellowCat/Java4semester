package ru.gudkova.weapon;
public class GunRifle extends Gun{
    public final int rapidity;
    public GunRifle(){
        rapidity = 30;
    }
    public GunRifle(int maxBul){
        this(maxBul, maxBul/2);
    }
    public GunRifle(int maxBul, int rapidity){
        super(maxBul);
        if(rapidity<1){
            throw new IllegalArgumentException("Rapidity can`t negative");
        }
        this.rapidity = rapidity;
    }
    public void shoot(){
        for(int i = 0; i<rapidity; i++){
            if (ammo()>0){
                System.out.println("Bang!");
                getAmmo();
            }
            else{
                System.out.println("Clack!");
            }
        }
    }
    public void shoot(int n){
        for(int i = 0; i<rapidity*n; i++){
            if (ammo()>0){
                System.out.println("Bang!");
                getAmmo();
            }
            else{
                System.out.println("Clack!");
            }
        }
    }
}
