package com.javaeight.optional;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Optional;

public class OptionalMap {

    //filter
    public static void filter(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.supplyStudent.get());
        studentOptional.filter(student -> student.getGpa()>=3.5)
                .ifPresent(student -> System.out.println(student));
    }

    //Map
    public static void map(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.supplyStudent.get());
        studentOptional.filter(student -> student.getGpa()>=3.5)
                .map(Student::getName)
                .ifPresent(student -> System.out.println(student));
    }

    public static void main(String[] args) {
        filter();
        map();
    }
}
