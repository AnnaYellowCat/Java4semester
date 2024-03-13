package ru.gudkova.humans;
public class Employee {
    public String name;
    Department dep;
    
    public Employee(String name){
        this.name = name;
    }
    
    public Department getDep(){
        return dep;
    }
    public void setDep(Department dep){
        if(this.dep != null){
            this.dep.delEmp(this);
            if(this.dep.boss == this){
                this.dep.boss = null;
            }
        }
        this.dep = dep;
        dep.AddEmp(this);
    }
    
    public String toString(){
        if(this != dep.boss){
            return(name + " rabotaet v " + dep);
        }
        else{
            return(dep.boss.name + " nachalnik otdela " + dep.name);
        }
    }
}
