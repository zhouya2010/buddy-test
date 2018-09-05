package com.test;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        MainTest test = new MainTest();
        while (true) {
            System.out.println(test.sayHello("hello", "word"));
            Thread.sleep(1000);
        }
    }

    public String sayHello(String var1, String var2) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return var1 + " <===> " + var2;
    }
}
