package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**Print all the activities in a List.*/
public class FlatMapEx {

    public static List<String> printStudentActivities(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(toList());

    }


    public static void main(String[] args) {

        System.out.println("All the Activities in the School "+printStudentActivities());
        System.out.println("Total number of Activities in the School "+StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count());

    }
}
