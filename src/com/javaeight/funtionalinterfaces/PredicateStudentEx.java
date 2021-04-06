package com.javaeight.funtionalinterfaces;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentEx {

    static Predicate<Student> p1 = student -> student.getGradeLevel()>=3;
    static Predicate<Student> p2 = student -> student.getGpa()>=3.9;

    public static void filterStudentsByGradeLevel(){
        System.out.println("filterStudentsByGradeLevel");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        });
    }
    public static void filterStudentsByGradeLevelAndGPA(){
        System.out.println("filterStudentsByGradeLevelAndGPA");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.and(p2).test(student)){
                System.out.println(student);
            }
        });
    }
    public static void filterStudentsByGradeLevelORGPA(){
        System.out.println("filterStudentsByGradeLevelOrGPA");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.or(p2).test(student)){
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGradeLevelORGPANegate(){
        System.out.println("filterStudentsByGradeLevelORGPANegate");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.or(p2).negate().test(student)){
                System.out.println(student);
            }
            else {
                System.out.println(student);
            }
        });
    }
    public static void main(String[] args) {
        filterStudentsByGradeLevel();
        filterStudentsByGradeLevelAndGPA();
        filterStudentsByGradeLevelORGPA();
        filterStudentsByGradeLevelORGPANegate();
    }
}
