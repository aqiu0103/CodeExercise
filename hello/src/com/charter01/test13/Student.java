package com.charter01.test13;

public class Student extends Person{
    String sex;
    String stu_id;
    public Student(String name,String sex,int age,String stu_id){
        super(name,age);
        this.sex=sex;
        this.stu_id=stu_id;
    }

    @Override
    public void play(Person person) {
        System.out.println(person.name+"学生爱玩游戏");
    }
    public void study(){
        System.out.println("我会好好学习");
    }
}
