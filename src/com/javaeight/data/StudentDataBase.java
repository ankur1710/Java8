package com.javaeight.data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentDataBase {

    static public Supplier<Student> supplyStudent =
         () -> new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"));

    /**
     * 2nd grade students
     */
    static Student student1 = new Student("Adam",2,3.6, "male", Arrays.asList("swimming", "basketball","volleyball"),11);
    static Student student2 = new Student("Jenny",2,3.8,"female", Arrays.asList("swimming", "gymnastics","soccer"),12);
    /**
     * 3rd grade students
     */
    static Student student3 = new Student("Emily",3,4.0,"female", Arrays.asList("swimming", "gymnastics","aerobics"),10);
    static Student student4 = new Student("Dave",3,3.9,"male", Arrays.asList("swimming", "gymnastics","soccer"),9);
    /**
     * 4th grade students
     */
    static Student student5 = new Student("Sophia",4,3.5,"female", Arrays.asList("swimming", "dancing","football"),15);
    static Student student6 = new Student("James",4,3.9,"male", Arrays.asList("swimming", "basketball","baseball","football"),14);

    /**
     * Total of 6 students in the database.
     * @return
     */
    public static List<Student> getAllStudents(){
        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6);
        return students;
    }

    public static List<Student> getAllStudentsWithNUll(){
        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6,null);
        return students;
    }
}
