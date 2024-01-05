package com.charter01.test13;

public class test {
    public static void main(String[] args) {
        Person[] person=new Person[2];
        person[0]=new Student("小明","男",18,"0001");
        person[1]=new Teacher("小光","男",24,"9999");
        person[0].play(person[0]);
        person[1].play(person[1]);
        for (int i = 0; i < person.length; i++) {
            if (person[i] instanceof Student) {
                ((Student) person[i]).study();
            }
            else {
                ((Teacher)person[i]).teach();
            }
        }
    }
}
