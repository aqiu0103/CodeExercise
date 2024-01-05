package com.charter01.test387;

public class CodeBlockDetail {
    public static void main(String[] args) {
        new B();
    }
}
class A{
    private static  int n1 =getN1();//静态变量初始化
    static {
        System.out.println("A静态代码块被调用");
    }
    {
        System.out.println("A普通代码块被调用");
    }
    public static int getN1(){
        System.out.println("getN1被调用");
        return 10;
    }
    public A(){
        System.out.println("调用A的构造器");
    }
}

class B extends A{
    private static  int n2 =getN2();//静态变量初始化
    static {
        System.out.println("B静态代码块被调用");
    }
    {
        System.out.println("B普通代码块被调用");
    }
    public static int getN2(){
        System.out.println("getN2被调用");
        return 11;
    }
    public B(){
        System.out.println("调用B的构造器");
    }
}
