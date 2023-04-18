package org.brightk;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class Main {
    public static void main(String[] args) {

        Class<Test> testClass = Test.class;

        for (Method declaredMethod : testClass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
            for (TypeVariable<Method> typeParameter : declaredMethod.getTypeParameters()) {

                System.out.println(typeParameter.getName());
            }
        }
        System.out.println("xxxxxxxx");
    }
}