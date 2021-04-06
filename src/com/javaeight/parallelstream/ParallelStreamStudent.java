package com.javaeight.parallelstream;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParallelStreamStudent {

    public static List<String> sequentialStudentActivities(){
        Long startTime = System.currentTimeMillis();
        List<String> studentActivities =  StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(toList());
        Long endTime = System.currentTimeMillis();
        System.out.println("time to execute Sequential Stream  "+(endTime-startTime));
        return studentActivities;

    }

    public static List<String> parallelStudentActivities(){
        Long startTime = System.currentTimeMillis();
        List<String> studentActivities =  StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(toList());
        Long endTime = System.currentTimeMillis();
        System.out.println("time to execute Parallel Stream  "+(endTime-startTime));
        return studentActivities;
    }

    public static void main(String[] args) {
        sequentialStudentActivities();
        parallelStudentActivities();
    }

}
