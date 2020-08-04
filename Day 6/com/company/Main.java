package com.company;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> arList = new ArrayList<>();
        arList.add(1); arList.add(2); arList.add(3);
        ArrayList<Integer> arList2 = new ArrayList<>();
        arList2.add(3); arList2.add(2); arList2.add(1);
        LinkedList<ArrayList> list = new LinkedList<>();
        list.add(arList); list.add(arList2);
        char[] chars = "hello".toCharArray();
        MyClass1 m = new MyClass1("one",1,list,chars);
        MyClass2 m2 = new MyClass2();

//        showMethods(m);
//
//        invokeMethod(m, "fly");

        copy(m,m2);
        System.out.println(m2.name + " " + m2.number);
        System.out.println(m2.list.toString());
        for (char c :m2.chars)
        {
            System.out.print(c);
        }
        System.out.println();

       // runRunMe();
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
                    distField.set(dist, cloneArray(sourceField.get(source)));
                } else {
                    if (sourceField.get(source) instanceof List) {
                        distField.set(dist, cloneList(sourceField.get(source)));
                    } else {
                        if (sourceField.get(source) instanceof Set) {
                            distField.set(dist, cloneSet(sourceField.get(source)));
                        } else {
                            copy(sourceField.get(source), distField.get(dist));
                        }
                    }
                }
            }
        }
    }



    private static Object cloneList(Object obj) throws Exception {
            Class sourceClass =obj.getClass();
            List<Object> arr = (List<Object>) obj;
            List<Object> clList =(List<Object>) sourceClass.newInstance();
            for (Object ob : arr) {
                Class obClass = ob.getClass();
                if (obClass.isPrimitive() || obClass.getName().contains("String")
                        || obClass.getSuperclass().getName().contains("Number")
                        || obClass.getSuperclass().getName().contains("Boolean")) {
                    clList.add(ob);
                } else {
                    clList.add(cloneList(ob));
                }
            }
            return clList;
    }

    private static Object cloneSet(Object obj) throws Exception {
        Class sourceClass =obj.getClass();
        Set<Object> set = (Set<Object>) obj;
        Set<Object> clSet =(Set<Object>) sourceClass.newInstance();
        for (Object ob : set) {
            Class obClass = ob.getClass();
            if (obClass.isPrimitive() || obClass.getName().contains("String")
                    || obClass.getSuperclass().getName().contains("Number")
                    || obClass.getSuperclass().getName().contains("Boolean")) {
                clSet.add(ob);
            } else {
                clSet.add(cloneSet(ob));
            }
        }
        return clSet;
    }

    private static Object cloneArray(Object obj) throws Exception {
            Method cloneMethod = Object.class.getDeclaredMethod("clone");
            cloneMethod.setAccessible(true);
            Object copy = cloneMethod.invoke(obj);
            if(copy instanceof Object[]) {
                Object[] array=(Object[]) copy;
                for (int ix = 0; ix < array.length; ix++)
                    array[ix]=cloneArray(array[ix]);
            }
            return copy;
    }



    public static void runRunMe() throws Exception {
        Reflections reflections = new Reflections("com.company");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Plugin.class);
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);
               if (method.isAnnotationPresent(RunMe.class)) {
                   Object obj = clazz.newInstance();
                   method.invoke(obj);
               }
            }
        }
    }



}


