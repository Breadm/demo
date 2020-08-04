package com.company;


import java.util.ArrayList;
import java.util.LinkedList;

@Plugin
public class MyClass2{
    String name;
    int number;
    @CollectionType(arg = "LinkedList")
    LinkedList<ArrayList> list;
    char[] chars;

    public MyClass2() {
        this.name = "name";
        this.number = 0;
        this.list = new LinkedList<>();
        this.chars = new char[1];
    }

    public MyClass2(String name, int number, LinkedList<ArrayList> list, char[] chars) {
        this.name = name;
        this.number = number;
        this.list = list;
        this.chars = chars;
    }

    private void someMethod(){

    }

    @RunMe
    private void fly(){
        System.out.println("------");
        System.out.println("MyClass2 is flying");
        System.out.println("------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
