package com.charter01.test13;

public class Teacher extends Person{
    public String sex;
    String work_age;
    public Teacher(String name,String sex,int age,String work_age){
        super(name,age);
        this.sex=sex;
        this.work_age=work_age;
    }
    public void play(Person person){
        System.out.println(person.name+"老师喜欢玩手机");
    }
    public void teach(){
        System.out.println("老师好好教书");
    }
}
