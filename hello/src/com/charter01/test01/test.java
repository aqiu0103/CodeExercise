package com.charter01.test01;

public class test {
    public static void main(String[] args) {
        Initialize initilize =new Initialize();
        initilize.assignment();
        int[] a=new int[initilize.person.length];
        for (int i = 0; i < initilize.person.length; i++) {
            a[i]=initilize.person[i].getAge();
        }
        new acount().ordination(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
