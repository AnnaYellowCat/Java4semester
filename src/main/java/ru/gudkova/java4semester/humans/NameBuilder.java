package ru.gudkova.humans;
public class NameBuilder {
    private String surname = "";
    private String persname = "";
    private String surname1 = "";
    public NameBuilder setPersname(String persname){
        this.persname = persname;
        return this;
    }
    public NameBuilder setSurname(String surname){
        this.surname = surname;
        return this;
    }
    public Name create(){
        Name name = new Name(persname, surname, surname1);
        return name;
    }
}
