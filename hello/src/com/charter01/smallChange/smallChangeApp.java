package com.charter01.smallChange;

import java.util.Scanner;

public class smallChangeApp {
    //属性
    boolean bool=true;
    int key;
    double revenue;
    double outlay;
    Scanner scanner=new Scanner(System.in);
    String detail="";
    String payType;
    double balance=0;
    //方法
    //菜单
    public void menu(){
        do {
            System.out.println("=====零钱通菜单======");
            System.out.println("1.零钱通明细");
            System.out.println("2.收益入账");
            System.out.println("3.支出入账");
            System.out.println("4.退出");
            System.out.println("请输入你的选择");
            key=scanner.nextInt();
            switch (key){
                case 1:
                    Detail();
                    break;
                case 2:
                    income();
                    break;
                case 3:
                    pay();
                    break;
                case 4:
                    bool=false;
                    break;
            }
        }while (bool);
    }
    //明细
    public void Detail(){
        System.out.println(detail);
    }
    //收益入账
    public void income(){
        System.out.println("收入为:");
        revenue=scanner.nextDouble();
        balance+=revenue;
        detail+="收入"+revenue+"\t"+"余额"+balance+"/t";
    }
    //消费
    public void pay(){
        System.out.println("支出为:");
        outlay=scanner.nextDouble();
        System.out.println("消费类型为");
        payType=scanner.next();
        balance-=outlay;
        detail+=payType+"支出"+outlay+"\t"+"余额"+balance+"/t";
    }

}
