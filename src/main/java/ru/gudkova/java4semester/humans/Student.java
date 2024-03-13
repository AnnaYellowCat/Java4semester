package ru.gudkova.humans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ru.gudkova.numbers.Comparable;

public class Student implements Comparable<Student>{
    public String name;
    private final List<Integer> grades = new ArrayList<>();

    public Student(String name, int... grades) {
        this.name = name;
        addGrades(grades);
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public String toString() {
        String str = name + ": [";
        for (int i = 0; i < grades.size(); i++) {
            str = str + grades.get(i);
            if (i + 1 != grades.size()) {
                str = str + ", ";
            }
        }
        return str + "]";
    }

    public Optional<Double> average() {
        if(grades.isEmpty() == true){
            return Optional.ofNullable(null);
        }
        else{
            int sum = 0;
            for (int i = 0; i < grades.size(); i++) {
               sum += grades.get(i);
            }
            return Optional.of((double)sum / grades.size());
        }
    }

    public boolean isExcellent() {
        boolean flag = false;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) != 5) {
                flag = true;
            }
        }
        return !grades.isEmpty() && !flag;
    }

    public void addGrades(int... a) {
        for (int mark : a) {
            if (mark < 2 || mark > 5) {
                throw new IllegalArgumentException("Grades must be in range between 2 and 5");
            }
            this.grades.add(mark);
        }
    }
    
    public int compare(Student st){
        if( this.average().get() > st.average().get() ) return 1;
        if(this.average().get() < st.average().get()) return -1;
        return 0;
    }
}
