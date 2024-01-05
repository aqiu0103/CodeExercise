package com.charter01.test416;

public class test416 {
    public static void main(String[] args) {
        tiger tiger = new tiger();
        tiger.cry();
        Outter outter = new Outter();
        outter.method();
        Father father = new Father();
        father.method();
    }
}

interface IA{
    public void cry();//创建一个接口,cry()是抽象方法，原本应该是public abstract void cry();
    default void smaile(){
        System.out.println("接口中的默认方法被实现");//普通类在实现接口时，不用非得实现接口中的非抽象方法
    }
}

//一般情况下要实现接口，（1）创建一个类来实现接口

class tiger implements IA{
    public void cry(){
        System.out.println("老虎叫");
    }
}

//内部类实现接口
class Outter{
    public static int n1=1;
    public static void method(){
        IA cat = new Cat();//外部类的方法中创建Cat类的对象实例
        cat.cry();//用cat对象调用cry（）方法
    }
    //当我们要访问上面Cat类中的cry（）方法，需要先创建一个Cat类的对象实例，用对象来调用cry（）方法
}

class Cat implements IA{//Cat类实现接口
    public void cry(){
        System.out.println("猫叫");
    }
}

//现在使用匿名内部类结合接口来练习一下
class Father{
    private int n1;
    public void method(){
        IA tiger=new IA(){
            public void cry(){
                System.out.println("猫叫（使用匿名内部类来实现接口）");
            }
        };
        tiger.cry();//别忘了还要用对象来调用匿名内部类重写的cry（）方法！！！！！！！写在匿名内部类外面、外部类的method（）方法内
    }
}

//需要注意的是一个程序中是由各种类构成，而类中只有属性、方法，而该类中的方法中可以创建其他类的对象实例来调用其他类中的方法（可以嵌套下去)
//一个Java文件只能有一个public类，类名与文件名一样