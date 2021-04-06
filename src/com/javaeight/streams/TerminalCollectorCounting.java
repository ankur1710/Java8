package com.javaeight.streams;

import com.javaeight.data.StudentDataBase;

import java.util.stream.Collectors;

public class TerminalCollectorCounting {

    static Long counting(){
       return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println(counting());
    }
}
