package ru.gudkova.animals;
public class Parrot extends Bird{
    public String lyrics;
    public Parrot(String lyrics){
        this.lyrics = lyrics;
    }
    public void sing(){
        char[] str = lyrics.toCharArray();
        char s;
        int l1;
        int l2;
        for (int i = 0; i<(int)lyrics.length()/9; i++){
            l1 = (int)(( Math.random() * lyrics.length()));
            l2 = (int)(( Math.random() * lyrics.length()));
            if(str[l1] == ' ' || str[l2] == ' '){
                i--;
            }
            else{
                s = str[l1];
                str[l1] = str[l2];
                str[l2] = s;
            }
        }
        String finalStr = new String(str);
        System.out.println(finalStr);
    }
}