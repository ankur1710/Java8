package com.company.streams;
import com.company.data.Student;
import com.company.data.StudentDataBase;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

//collect all the Student Names in the List and then print the List
public class MapEx {

    public static void main(String[] args) {
        List<String> names = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

       Set<String> namesSet = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(names);
        System.out.println(namesSet);
    }
}
