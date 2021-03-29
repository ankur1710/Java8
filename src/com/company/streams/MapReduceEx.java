package com.company.streams;

import com.company.data.Student;
import com.company.data.StudentDataBase;

//total number of notebooks in whole class.
public class MapReduceEx {

    static long getTotalNotebookCount(){
         return StudentDataBase.getAllStudents()
                .stream()
                .filter(s ->s.getGradeLevel()>=3)
                .map(Student::getNotebooks)
                .reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(getTotalNotebookCount());
    }
}
