package com.javaeight.interfacedefaultstatic;

public interface MultipleInheritanceInterface3 extends MultipleInheritanceInterface2{
    default void methodC(){
        System.out.println("inside method C");
    }
}
