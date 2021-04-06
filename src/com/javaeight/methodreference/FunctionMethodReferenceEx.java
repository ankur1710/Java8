package com.javaeight.methodreference;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionMethodReferenceEx {

    static Function<String,String> function = (s) -> s.toUpperCase();
    static Function<String,String> toUpperCaseMp = String::toUpperCase;

    static Consumer<Student> studentConsumer = (s) -> System.out.println(s);
    static Consumer<Student> studentConsumerMp = System.out::println;
    static Consumer<Student> printActivities = Student::printListOfActivities;

    public static void main(String[] args) {
         StudentDataBase.getAllStudents().forEach(s -> printActivities.accept(s));
    }
}
