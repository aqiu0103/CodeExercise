package com.charter01.test404;

public class test {
    public static void main(String[] args) {
        fun(new A());
    }
    public static void fun(Interface01 inter){
        inter.connect();
        inter.close();
    }
}
