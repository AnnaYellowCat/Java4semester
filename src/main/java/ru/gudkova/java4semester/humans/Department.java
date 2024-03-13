package ru.gudkova.humans;
public class Department {
    public String name;
    Employee boss;
    Employee[] employees = new Employee[0];
    
    public Department(String name){
        this.name = name;
    }
    
    public void AddEmp(Employee emp){
        if(emp != null){
            int flag = 0;
            int i = 0;
            for(; i<employees.length; i++){
                if(emp == employees[i]){
                    flag = 1; 
                    break;
                }
            }
            if (flag == 0){
                Employee[] sum = new Employee[employees.length+1]; 
                for(i = 0; i<employees.length; i++){
                    sum[i] = employees[i];
                }
                sum[sum.length-1] = emp;
                employees = sum;
            }
            if(emp.dep != this){
                emp.setDep(this);
            }
            
        }
    }
    public void delEmp(Employee emp){
        if(emp != null){
            int flag = 0;
            int n = 0;
            int i = 0;
            for(; i<employees.length; i++){
                if(emp == employees[i]){
                    flag = 1;
                    n = i;
                    break;
                }
            }
            if (flag == 1){
                Employee[] sum = new Employee[employees.length-1]; 
                for(i = 0; i<n; i++){
                    sum[i] = employees[i];
                }
                for(i = n+1; i<employees.length; i++){
                    sum[i-1] = employees[i];
                }
                employees = sum;
            }
        }
    }
    
    public Employee[] getEmps(){
        return employees;
    }
    public Employee getBoss(){
        if(boss == null){
            return null;
        }
        else{
            return boss;
        }
    }
    public void setBoss(Employee boss){
        if(boss!=null){
            if(boss.dep != this){
            throw new IllegalArgumentException("The department boss must work in the same department");
            }
        }
        this.boss = boss;
    }
    
    public String toString(){
        String str = "";
        for(int i = 0; i<employees.length; i++){
            str = str + employees[i].name + " ";
        }
        if(boss !=null){
            return("otdel " + name + " nachalnik " + boss.name + ", spisok sotrudnikov: " + str);
        }
        else{
            return("otdel " + name + ", spisok sotrudnikov: " + str);
        }
    }
}
