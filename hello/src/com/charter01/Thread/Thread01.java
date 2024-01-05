package com.charter01.Thread;

public class Thread01 {
    public static void main(String[] args) {
    Dog dog=new Dog();
    Thread thread01=new Thread(dog);
    thread01.start();
    }
}
class Animal{
    public void Call(){
        System.out.println("汪汪汪。。");
    }
}
class Dog extends Animal implements Runnable{
    int count=0;
    @Override
    public void run() {
        while(true){
            Call();
            System.out.println(++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count==10)
                break;
        }
    }
}
