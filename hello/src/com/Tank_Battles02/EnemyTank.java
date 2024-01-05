package com.Tank_Battles02;

import java.util.Vector;
/*
* 把射击属性放到敌方坦克属性里，由于有多个敌方坦克，每辆敌方坦克都要发射子弹，故把多个子弹发射放到vector中
* */
public class EnemyTank extends Tank {
    Boolean isLive=true;
    Vector<Shot> shots=new Vector<>();
    //调用父类Tank构造器
    public EnemyTank(int x,int y){
        super(x,y);
    }
}
