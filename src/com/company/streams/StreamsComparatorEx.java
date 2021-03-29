package com.company.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.company.data.Student;
import com.company.data.StudentDataBase;

/**all the students should be printed in sorted order by thier name*/
public class StreamsComparatorEx {

    static List<Student> studentList(){
        Comparator<Student> studentComparator = (student1,student2) -> student1.getName().compareTo(student2.getName());
       return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(studentList());
    }
}
