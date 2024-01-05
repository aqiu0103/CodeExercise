package com.charter01.text01;

public class Employee {
    public String name;
    private int salary;
    public Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }
    //定义一个计算年工资的方法
    public int getAnnual(){
        return 12*salary;
    }

    public int getSalary(){
        return salary;
    }


}
