package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.stream.Collectors;

public class TerminalCollectorSumAvg {
    public static void main(String[] args) {
        System.out.println("Summation of all the notebooks "+
                StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNotebooks))
        );
        System.out.println("Average of the Notebooks "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.averagingInt(Student::getNotebooks))
        );
        System.out.println("Average of the GPAs "+
                StudentDataBase.getAllStudents()
                        .stream()
                        .collect(Collectors.averagingDouble(Student::getGpa))
        );
    }
}
