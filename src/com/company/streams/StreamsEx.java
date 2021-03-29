package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.Map;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsEx {
    public static void main(String[] args) {
        //Students and their Activities in Map
        Map<String,List<String>> studentActivitiesMap =
                StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
//        System.out.println(studentActivitiesMap);

        //Students filter Students gradeLevel>=3
        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGpa()>=3.9;

        Map<String,List<String>> studentActivitiesMapFilter =
                StudentDataBase.getAllStudents()
                        .stream()
                        .peek(s -> System.out.println("1 "+s.getName()))
                        .filter(gradePredicate)
                        .peek(s -> System.out.println("2 "+s.getName()))
                        .filter(gpaPredicate)
                        .peek(s -> System.out.println("3 "+s.getName()))
                        .collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studentActivitiesMapFilter);
    }
}
