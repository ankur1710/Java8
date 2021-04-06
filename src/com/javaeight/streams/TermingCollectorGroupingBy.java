package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class TermingCollectorGroupingBy {
    public static void main(String[] args) {
//        //groupBy gender
//        System.out.println(
//                StudentDataBase.getAllStudents()
//                .stream()
//                .collect(Collectors.groupingBy(Student::getGender))
//        );
//
//        //groupBy gpa outstanding gpa>3.8 , average < 3.8
//        System.out.println(
//                StudentDataBase.getAllStudents()
//                        .stream()
//                        .collect(Collectors.groupingBy(student -> student.getGpa()>3.8?"Outstanding":"Average")));

        //Create a 2level Grouping , based on their grades Map<Integer,Map<String,List<Student>>>
//        System.out.println(
//                StudentDataBase.getAllStudents()
//                .stream()
//                .collect(Collectors.groupingBy(Student::getGradeLevel,
//                                                Collectors.groupingBy(student -> student.getGpa()>3.8?"Outstanding":"Average"))));

        //number of notebooks per grade
        System.out.println(
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.groupingBy(Student::getGpa,
                                Collectors.summingInt(Student::getNotebooks))));
        //3level Grouping
        System.out.println(
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Student::getName,
                                LinkedHashMap::new,
                                Collectors.toSet()
                        )).entrySet());

    }
}
