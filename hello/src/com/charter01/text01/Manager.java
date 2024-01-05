package com.charter01.text01;

public class Manager extends Employee{
    private int bonus;

    public Manager(String name,int salary,int bonus){
        super(name,salary);
        this.bonus=bonus;
    }

    public void manage(){
        System.out.println("Manager have arranged sth~");
    }

    public int getAnnual(){
        return 12*getSalary()+bonus;
    }
}
