package com.company;

public class Calculator <T extends Number> {
    public Number sum(T obj1, T obj2) {
        return obj1.doubleValue()+obj2.doubleValue();
    }

    public Number sub(Number obj1, Number obj2) {
        return obj1.doubleValue()-obj2.doubleValue();
    }

    public Number mul(Number obj1, Number obj2) {
        return obj1.doubleValue()*obj2.doubleValue();
    }

    public Number div(Number obj1, Number obj2) {
        return obj1.doubleValue()/obj2.doubleValue();
    }
}
