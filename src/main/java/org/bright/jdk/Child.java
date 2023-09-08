package org.bright.jdk;

public class Child  extends Parent{
    public static final int a = 0;
    public static int b = 1;
    static {
        System.out.println("child init");
    }
}
