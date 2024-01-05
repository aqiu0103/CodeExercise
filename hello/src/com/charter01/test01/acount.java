package com.charter01.test01;

public class acount {
    int temp;
    public void ordination(int[] a){
        for (int i = a.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
