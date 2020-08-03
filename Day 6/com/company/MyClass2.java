package com.company;


import java.util.ArrayList;

public class MyClass2{
    String name;
    int number;
    ArrayList<ArrayList> list;
    char[] chars;

    public MyClass2() {
        this.name = "name";
        this.number = 0;
        this.list = new ArrayList<>();
        this.chars = new char[1];
    }

    public MyClass2(String name, int number, ArrayList<ArrayList> list, char[] chars) {
        this.name = name;
        this.number = number;
        this.list = list;
        this.chars = chars;
    }

    private void someMethod(){

    }

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
