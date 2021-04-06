package com.javaeight.funtionalinterfaces;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * here we will pass StudentList and the predicate and get the same map of Studentname and StudentGpA
 */
public class BiFunctionStudentEx {

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionPredicate =
            (list, predicate) -> {
                Map<String, Double> studentMap = new HashMap<>();
                list.forEach(
                        student -> {
                            if (predicate.test(student)) {
                                studentMap.put(student.getName(), student.getGpa());
                            }
                        });
                return studentMap;
            };

    public static void main(String[] args) {
        System.out.println(biFunctionPredicate.apply(
                StudentDataBase.getAllStudents(),
                PredicateStudentEx.p1
        ));
        System.out.println(biFunctionPredicate.apply(
                StudentDataBase.getAllStudents(),
                PredicateStudentEx.p2
        ));

    }
}
