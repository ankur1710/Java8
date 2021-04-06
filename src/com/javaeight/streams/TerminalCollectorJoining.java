package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;


import static java.util.stream.Collectors.joining;

/**concatenate all the names as part of the student Database*/
public class TerminalCollectorJoining {

    static String joining1(){
       return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining());
    }
    static String joining2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining("-"));
    }

    static String joining3(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(joining("-","(",")"));
    }

    public static void main(String[] args) {
        System.out.println(joining1());
        System.out.println(joining2());
        System.out.println(joining3());

    }
}
