package com.company.streams;

import com.company.data.StudentDataBase;

public class MatchEx {

    static boolean allMatch(){
       return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.0);
    }

    static Boolean anyMatch(){
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=4.0);
    }

    static Boolean noneMatch(){
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=4.5);
    }
    public static void main(String[] args) {
        System.out.println(allMatch());
        System.out.println(anyMatch());
        System.out.println(noneMatch());
    }
}
