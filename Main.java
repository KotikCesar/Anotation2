package com.company;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        TextContainer cont = new TextContainer();
        Class<?> cl = cont.getClass();
        if (cl.isAnnotationPresent(SaverTo.class)) {
            SaverTo saverTo = cl.getAnnotation(SaverTo.class);
            String path = saverTo.path();
            Method[] method = cl.getDeclaredMethods();

            for (Method met: method) {
                if (met.isAnnotationPresent(Saver.class)) {
                    met.invoke(cont, path);
                    System.out.println("file saved");
                }
            }
        }

    }
}
