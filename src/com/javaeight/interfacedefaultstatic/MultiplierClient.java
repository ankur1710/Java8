package com.javaeight.interfacedefaultstatic;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {
        MultiplierInt multiplierInt = new MultiplierImpl();
        List<Integer> integerList = Arrays.asList(1,3,5);
        System.out.println("Multiplier "+multiplierInt.multiply(integerList));
        System.out.println("Size "+multiplierInt.getSize(integerList));
        System.out.println("isEmpty "+MultiplierInt.checkEmpty(integerList));
    }
}
