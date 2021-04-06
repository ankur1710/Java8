package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TerminalCollectorPartitioning {
    public static void main(String[] args) {
        Predicate<Student> gpaPredicate = s -> s.getGpa()>=3.8;
        System.out.println( "Partitioning by GPA >=3.8 "+
                StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(
                        gpaPredicate
                ))
        );

        System.out.println( "Partitioning by GPA >=3.8 to SET "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.partitioningBy(
                                gpaPredicate,Collectors.toSet()
                        ))
        );
    }
}
