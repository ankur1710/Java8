package com.company.funtionalinterfaces;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BiPredicateEx {
    BiPredicate<Integer,Double> biP = (gl,gpa) -> gl>=3&&gpa>=3.9;

    BiConsumer<String, List<String>> nameAndActivities =
            (name,activities) -> System.out.println("name "+name+", Activities "+activities);

    Consumer<Student> studentConsumer = student -> {
        if(biP.test(student.getGradeLevel(),student.getGpa())){
            nameAndActivities.accept(student.getName(),student.getActivities());
        }
    };

    public void printNamesAndActivities(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new BiPredicateEx().printNamesAndActivities(studentList);

    }
}
