package com.charter01.test01;

import java.util.Scanner;

public class Initialize {
    String name;
    int age;
    String job;
    public Person[] person=new Person[3];
    Scanner scanner=new Scanner(System.in);
    public void assignment(){
        for (int i = 0; i < person.length; i++) {
            System.out.println("输入第"+(i+1)+"个人的信息");
            System.out.println("输入姓名为");
            name=scanner.next();
            System.out.println("输入年龄为");
            age=scanner.nextInt();
            System.out.println("输入工作为");
            job=scanner.next();
            person[i]=new Person(name,age,job);
        }
    }
}
