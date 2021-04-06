package com.javaeight.optional;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElse {

    //orELse get the name of the student
    public static String optionalOrElse(){
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.supplyStudent.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElse("Default");
    }

    //orELse get the name of the student Supplier
    public static String optionalOrElseGet(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.supplyStudent.get());
//        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElseGet(() -> "Default");
    }

    //orELse get the name of the student
    public static String optionalOrElseThrow(){
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.supplyStudent.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
        return studentOptional.map(Student::getName).orElseThrow(() -> new RuntimeException("no Data found"));
    }

    public static void main(String[] args) {
        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());
    }
}
