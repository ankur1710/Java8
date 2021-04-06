package com.javaeight.lambdas;

public class RunnableLambdaEs {

    public static void main(String[] args) {

        /**
         * prior java8
         */
        Runnable runnable1= new Runnable() {
            @Override
            public void run() {
                System.out.println("inside Runnable1");
            }
        };
        new Thread(runnable1).start();

        /**
         * using lambdas
         */
        Runnable runnable2 = () -> {System.out.println("inside Runnable2");};
        new Thread(runnable2).start();
        new Thread(() -> System.out.println("inside runnable3")).start();
    }
}
