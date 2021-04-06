package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Optional;

public class FindAnyFirstEx {

    static Optional<Student> findAnyStudent(){
       return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.7)
                .findAny();
    }

    static Optional<Student> findFirstStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println("FindAny "+findAnyStudent().get());
        System.out.println("FindAny "+findFirstStudent().get());

    }
}
