package com.Tank_Battles02;

public class Hero extends Tank {

    Shot shot=null;

    public Hero(int x,int y){
        super(x,y);
    }


    /*现在已经有shot线程了，写一个方法让hero坦克去启动shot线程，并且根据hero的方向来确定shot线程的初始位置*/
    public void shotEnemyTank(){
        switch (getDirect()){//调用父类方法getDirect()得到hero的方向
            case 0:
                shot=new Shot(getX()+30,getY(),getDirect());//创建方向为0的shot线程实体
                new Thread(shot).start();//启动shot线程
                break;
            case 1:
                shot=new Shot(getX()+60,getY()+30,getDirect());
                new Thread(shot).start();
                break;
            case 2:
                shot=new Shot(getX()+30,getY()+60,getDirect());
                new Thread(shot).start();
                break;
            case 3:
                shot=new Shot(getX(),getY()+30,getDirect());
                new Thread(shot).start();
                break;
        }
    }
}
