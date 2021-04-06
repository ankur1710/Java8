package com.javaeight.interfacedefaultstatic;
import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultSort {

    static Consumer<Student> studentConsumer = System.out::println;
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
    static Comparator<Student> gradeComparator = Comparator.comparingDouble(Student::getGradeLevel);

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);

        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);

        //We can Chain two Comparators and Merge the result
        //first we will sort it with the grade and then sort the names within the grade
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);

    }
}
