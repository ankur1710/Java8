package com.javaeight.funtionalinterfaces;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.List;

import java.util.function.Consumer;

/** accepts a string and converts into upper case*/
public class ConsumerEx {

    static Consumer<Student> studentConsumer = (s) -> System.out.println(s);
    static Consumer<Student> nameConsumer = (s) -> System.out.print(s.getName() );
    static Consumer<Student> activitiesConsumer = (s) -> System.out.println(s.getActivities());


    public static void printNames(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(studentConsumer);
    }

    public static void printNameAndActivities(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(nameConsumer.andThen(activitiesConsumer));
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition");
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(s -> {
            if(s.getGradeLevel()>=3){
                nameConsumer.andThen(activitiesConsumer).accept(s);
            }
        });
    }


    public static void main(String[] args) {
        printNames();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();

        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.accept("java8");
    }
}
