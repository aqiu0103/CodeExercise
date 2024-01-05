package com.charter01.test01;

public class Person {
    public String name;
    private int age;
    public String job;
    public Person(String name,int age,String job){
        this.name=name;
        this.age=age;
        this.job=job;
    }

    public int getAge() {
        return age;
    }
}
