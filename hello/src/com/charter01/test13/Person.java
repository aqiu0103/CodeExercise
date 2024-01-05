package com.charter01.test13;

public class Person {
    public String name;
    private int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void play(Person person){
        System.out.println(person.name+"爱玩");
    }

}
