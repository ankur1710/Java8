package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Comparator;
import java.util.stream.Collectors;

public class TerminalCollectorMaxMinBy {
    public static void main(String[] args) {

        System.out.println("Student with Least GPA "+
                StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa))).get());
        System.out.println("Student with Highest GPA "+
                StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa))).get());
    }
}
