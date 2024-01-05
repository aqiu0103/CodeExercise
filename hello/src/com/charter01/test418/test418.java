package com.charter01.test418;
////中是另一种方法
public class test418 {
    public static void main(String[] args) {
        //传统方法，如下
        AA aa=new AA();
        f(aa);
        //匿名内部类当作实参来传递，如下所示
        f(new IA(){
            public void show(){
                System.out.println("使用匿名内部类来代替类或对象");
            }
        });//f括号里代表的是一个对象
    }
    static void f(IA ia){//这里的方法需要加关键词static，因为主方法是静态方法，静态方法只能调用静态成员
        ia.show();
    }
}



//接口
interface IA {
    public abstract void show();//接口定义抽象类
}

class AA implements IA {
    public void show(){
        System.out.println("类AA实现接口IA，并重写接口IA中的抽象方法show()");
    }
}