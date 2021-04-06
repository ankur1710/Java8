package com.javaeight.streams;

import com.javaeight.data.Student;
import com.javaeight.data.StudentDataBase;

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
