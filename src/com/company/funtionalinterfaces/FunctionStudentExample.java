package com.company.funtionalinterfaces;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.HashMap;
import java.util.function.Function;
import java.util.List;
import java.util.Map;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> studentMapFunction =
            (list) -> {
                Map<String, Double> studentMap = new HashMap<>();
                list.forEach(student -> {
                    if (PredicateStudentEx.p1.test(student)) {
                        studentMap.put(student.getName(), student.getGpa());
                    }
                });
                return studentMap;
            };

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        Map<String, Double> studentMap = studentMapFunction.apply(studentList);
        studentMap.forEach((k, v) -> System.out.println("key {}, value {} " + k + ", " + v));

    }
}
