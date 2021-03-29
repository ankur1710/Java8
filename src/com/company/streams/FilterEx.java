package com.company.streams;

import com.company.data.StudentDataBase;

import static java.util.stream.Collectors.toList;

//get All the Female Students
public class FilterEx {

    public static void main(String[] args) {
        System.out.println(
                StudentDataBase.getAllStudents()
                .stream()
                .filter(s -> s.getGender().equalsIgnoreCase("female"))
                .collect(toList())
        );
    }
}
