package com.javaeight.funtionalinterfaces;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerEx {

    Predicate<Student> p1 = student -> student.getGradeLevel()>=3;
    Predicate<Student> p2 = student -> student.getGpa()>=3.9;

    BiConsumer<String,List<String>> nameAndActivities =
            (name,activities) -> System.out.println("name "+name+", Activities "+activities);

    Consumer<Student> studentConsumer = student -> {
        if(p1.and(p2).test(student)){
            nameAndActivities.accept(student.getName(),student.getActivities());
        }
    };

    public void printNamesAndActivities(List<Student> studentList){
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateConsumerEx().printNamesAndActivities(studentList);

    }
}
