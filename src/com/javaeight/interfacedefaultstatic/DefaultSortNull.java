package com.javaeight.interfacedefaultstatic;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultSortNull {
    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
    static Comparator<Student> gradeComparator = Comparator.comparingDouble(Student::getGradeLevel);

    public static void main(String[] args) {
            List<Student> studentList = StudentDataBase.getAllStudentsWithNUll();
            studentList.sort(Comparator.nullsLast(nameComparator));
            studentList.forEach(studentConsumer);
    }
}
