package com.company.funtionalinterfaces;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerEx {


    public static void printNameAndActivities(){
        BiConsumer<String,List<String>> nameAndActivities =
                (name,activities) -> System.out.println("name "+name+", Activities "+activities);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> nameAndActivities.accept(student.getName(),student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer= (a,b) -> System.out.println("a: "+a+", b:"+b);
        biConsumer.accept("java7","java8");

        BiConsumer<Integer,Integer> multiply= (a,b) -> System.out.println(a*b);

        BiConsumer<Integer,Integer> division= (a,b) -> System.out.println(a/b);
        multiply.andThen(division).accept(10,5);

        printNameAndActivities();
    }
}
