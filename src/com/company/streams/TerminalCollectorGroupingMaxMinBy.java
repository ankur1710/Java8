package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//we need top GPA in each grade and then Least GPA in each grade
public class TerminalCollectorGroupingMaxMinBy {
    public static void main(String[] args) {
        System.out.println( "top GPA in each grade "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getGradeLevel,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(Comparator.comparing(Student::getGpa)),
                                                Optional::get
                                        )
                                )));

        System.out.println("\nLeast GPA in each grade "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getGradeLevel,
                                        Collectors.minBy(Comparator.comparing(Student::getGpa))
                                )));
    }

}


