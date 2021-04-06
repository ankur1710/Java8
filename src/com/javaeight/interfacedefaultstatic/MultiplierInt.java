package com.javaeight.interfacedefaultstatic;
import java.util.List;

@FunctionalInterface
public interface MultiplierInt {
    int multiply(List<Integer> integerList);

    /** size of the input List*/
    default int getSize(List<Integer> integerList){
        return integerList.size();
    }

    /** check the List is empty*/
    static Boolean checkEmpty(List<Integer> integerList){
        return integerList.size()==0?true:false;
    }
}
