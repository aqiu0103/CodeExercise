package com.charter01.text01;

public class ordStaff extends Employee{
    //定义构造器
    public ordStaff(String name,int salary){
        super(name,salary);
    }

    //特有方法
    public void work(){
        System.out.println("ordinary staff are working~");
    }

    //重写getAnnual()方法
    public int getAnnual(){
        return 11*getSalary();
    }

}
