package com.company.methodreference;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMR {

    static Predicate<Student> p1 = RefactorMR::testGrade;

    static Boolean testGrade(Student student){
        return student.getGradeLevel()>=2;
    }

    public static void main(String[] args) {
        System.out.println(p1.test(StudentDataBase.supplyStudent.get()));
    }
}
