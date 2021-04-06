package com.javaeight.optional;

import com.javaeight.data.Student;

import java.util.Optional;

public class StudentOptionalEx {

    public static String getStudentName(){
//        Student student= StudentDataBase.supplyStudent.get();
        Student student= null;
        return student!=null?student.getName():null;
    }

    public static Optional<String> getStudentNameOp(){
//        Optional<Student> optionalStudent = Optional.ofNullable(StudentDataBase.supplyStudent.get());
        Optional<Student> optionalStudent = Optional.ofNullable(null);
        return optionalStudent.isPresent()
                ? optionalStudent.map(Student::getName)
                : Optional.empty();
    }
    public static void main(String[] args) {
//        System.out.println(getStudentName().length());
        if(getStudentNameOp().isPresent()) System.out.println(getStudentNameOp().get().length());
        else System.out.println("no value found");
    }
}
