package ru.gudkova.humans;
public class Name {
    private String surname;
    private final String name;
    private String surname1;
    
    public Name(String name){
        this(name, null, null);
    }
    public Name(String name, String surname){
        this(name, surname, null);
    }
    public Name(String name, String surname, String surname1){
        if((name == null || name.equals("")) && (surname == null || surname.equals("")) && (surname1 == null || surname1.equals(""))){
            throw new IllegalArgumentException("At least one argumet must be specified");
        }
        this.name = name;
        this.surname = surname;
        this.surname1 = surname1;
    }
    
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getSurname1(){
        return surname1;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setSurname1(String surname1){
        this.surname1 = surname1;
    }
    public String toString(){
        String str = "";
        if(surname != null) str = str + surname;
        if(name != null) str = str + " " + name;
        if(surname1 != null) str = str + " " + surname1;
        return str;
    }
}
