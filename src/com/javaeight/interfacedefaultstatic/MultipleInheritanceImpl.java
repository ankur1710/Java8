package com.javaeight.interfacedefaultstatic;

public class MultipleInheritanceImpl implements MultipleInheritanceInterface1,MultipleInheritanceInterface2,MultipleInheritanceInterface3{

    public void methodA(){
        System.out.println("inside methodA MultipleInheritanceImpl");
    }

    public static void main(String[] args) {
        MultipleInheritanceImpl clientImpl = new MultipleInheritanceImpl();
        //the Child class has access to all the default methods of the parent interfaces. this was never possible before Java8
        clientImpl.methodA(); // client method takes precedence
        clientImpl.methodB();
        clientImpl.methodC();

    }
}
