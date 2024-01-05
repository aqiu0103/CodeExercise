package com.charter01.text01;

public class major {
    public static void main(String[] args) {
        Employee[] employee=new Employee[3];
        for (int i = 0; i < employee.length; i++) {
            employee[0]=new Employee("小明",1000);
            employee[1]=new ordStaff("小光",2000);
            employee[2]=new Manager("小米",3000,300);
        }
        text text01 = new text();
        for (Employee value : employee) {
            text01.showEmpAnnal(value);
            text01.testWork(value);
        }
//        Manager manager=new Manager("xxx",1000,200);
//        text text01 = new text();
//        text01.showEmpAnnal(manager);
//        text01.testWork(manager);


        }
    }

