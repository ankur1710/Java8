package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceEx {

    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1, 2, 3, 5, 7);
        System.out.println(listInt.stream().reduce(10, Math::multiplyExact).intValue());
        System.out.println(listInt.stream().reduce((a, b) -> a + b).get());

        System.out.println(highestGpa().get());
    }

    /**
     * student with highest Gpa
     */
    static Optional<Student> highestGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .reduce((s1, s2) -> s1.getGpa()> s2.getGpa()?s1:s2);
    }
}
