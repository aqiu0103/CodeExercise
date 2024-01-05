package com.charter01.test418_;

public class test418_ {
    public static void main(String[] args) {
        new Cellphone().alarmclock(new Bell(){
            public void ring(){
                System.out.println("懒猪起床了");
            }
        });
    }
}


class Cellphone{
    public void alarmclock(Bell bell){
        bell.ring();
    }
}


interface Bell{
    public void ring();
}