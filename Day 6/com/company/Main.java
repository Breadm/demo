package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arList = new ArrayList<>();
        arList.add(1); arList.add(2); arList.add(3);
        ArrayList<Integer> arList2 = new ArrayList<>();
        arList2.add(3); arList2.add(2); arList2.add(1);
        ArrayList<ArrayList> list = new ArrayList<>();
        list.add(arList); list.add(arList2);
        char[] chars = "hello".toCharArray();
        MyClass1 m = new MyClass1("one",1,list,chars);
        MyClass2 m2 = new MyClass2();

        showMethods(m);

        invokeMethod(m, "fly");

        copy(m,m2);
        System.out.println(m2.name + " " + m2.number);
        System.out.println(m2.list.toString());
        for (char c :m2.chars)
        {
            System.out.print(c);
        }
        System.out.println();


    }

    public static void showMethods(Object obj){
        Class clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            method.setAccessible(true);
            System.out.println(method.getName());
        }
    }

    public static void invokeMethod(Object obj, String methodName) throws Exception {
        Class clazz = obj.getClass();
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
    }

    public static void nonContainerCopy(Object source, Object dist) throws Exception {
        Class sourceClass = source.getClass();
        Class distClass = dist.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        for(Field sourceField:sourceFields){
                Field distField = distClass.getDeclaredField(sourceField.getName());
                if(distField!=null){
                    sourceField.setAccessible(true);
                    distField.setAccessible(true);
                    distField.set(dist, sourceField.get(source));
                }
        }
    }

    public static void copy(Object source, Object dist) throws Exception {
        Class sourceClass = source.getClass();
        Class distClass = dist.getClass();

        if (sourceClass.getName().contains("List")) {
            ArrayList<Object> arr = (ArrayList<Object>) source;
            ArrayList<Object> clList = new ArrayList<>();
            for (Object ob : arr) {
                Class obClass = ob.getClass();
                if (obClass.isPrimitive() || obClass.getName().contains("String")
                        || obClass.getSuperclass().getName().contains("Number")
                        || obClass.getSuperclass().getName().contains("Boolean")) {
                    clList.add(ob);
                } else {
                   Object addObj = new Object();
                    copy(ob,addObj);
                    clList.add(addObj);
                }
            }
            dist = clList;
            return;
        }

        Field[] sourceFields = sourceClass.getDeclaredFields();

        for(Field sourceField:sourceFields){
            Field distField = distClass.getDeclaredField(sourceField.getName());
            sourceField.setAccessible(true);
            distField.setAccessible(true);
            if (sourceField.get(source) == null || Modifier.isFinal(sourceField.getModifiers())) {
                continue;
            }
            if (sourceField.getType().isPrimitive() || sourceField.getType().equals(String.class)
                    || sourceField.getType().getSuperclass().equals(Number.class)
                    || sourceField.getType().equals(Boolean.class)) {
                distField.set(dist, sourceField.get(source));
            } else {
                if (sourceField.getType().isArray()) {
                    Method cloneMethod =  Object.class.getDeclaredMethod("clone");
                    cloneMethod.setAccessible(true);
                    Object copyField = cloneMethod.invoke(sourceField.get(source));
                    distField.set(dist, copyField);
                } else {
                    copy (sourceField.get(source), distField.get(dist));
                }
            }
        }

    }



}


