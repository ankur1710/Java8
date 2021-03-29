package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.stream.Collectors;

public class TerminalCollectorMapping {

    public static void main(String[] args) {
        System.out.println("Name List "+
        StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toList()))
        );

        System.out.println("Name Set "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.mapping(Student::getName,Collectors.toSet()))
        );
    }
}
