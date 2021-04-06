package com.javaeight.interfacedefaultstatic;

import java.util.List;

public class MultiplierImpl implements MultiplierInt{
    @Override
    public int multiply(List<Integer> integerList) {
        return integerList.stream().reduce(1, Math::multiplyExact);
    }

    @Override
    public int getSize(List<Integer> integerList) {
        System.out.println("Inside Overridden MultiplierImpl class");
        return integerList.stream().reduce(1, Math::multiplyExact);
    }

}
