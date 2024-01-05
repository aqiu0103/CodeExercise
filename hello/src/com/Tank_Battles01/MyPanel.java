package com.Tank_Battles01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义MyPanel中的属性，即面板中的坦克
    Hero hero=null;
    //构造函数
    public MyPanel(){
        hero=new Hero(200,200);
    }

    //绘图方法
    public void paint(Graphics g){
        super.paint(g);//调用父类初始化
        g.fillRect(0,0,1000,750);
        DrawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//画hero坦克

        /*画出子弹*/
        if (hero.shot!=null && hero.shot.isLive==true){g.fill3DRect(hero.shot.getX(),hero.shot.getY(),2,2,false);}
    }
/*
* direct是坦克的方向
* type是坦克的类型，分敌我
* */
    public void DrawTank(int x,int y,Graphics g,int direct,int type){   //画坦克的方法
        switch(type){
            case 0:
                g.setColor(Color.cyan);
                break;//这里也需要加上break,不然会一直执行下去
            case 1:
                g.setColor(Color.BLUE);
                break;
        }
        switch(direct){   //0上 1右 2下 3左
            case 0:
                g.fill3DRect(x,y,10,60,false);//画左轮子
                g.fill3DRect(x+10, y+10,40,40,false);//画身体
                g.fill3DRect(x+50,y,10,60,false);//画右轮子
                g.drawLine(x+30, y, x+30, y+30);//画炮筒
                g.drawOval(x+10, y+10,40,40);
                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);//画左轮子
                g.fill3DRect(x+10, y+10,40,40,false);//画身体
                g.fill3DRect(x,y+50,60,10,false);//画右轮子
                g.drawLine(x+60, y+30, x+30, y+30);//画炮筒
                g.drawOval(x+10, y+10,40,40);
                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);//画左轮子
                g.fill3DRect(x+10, y+10,40,40,false);//画身体
                g.fill3DRect(x+50,y,10,60,false);//画右轮子
                g.drawLine(x+30, y+60, x+30, y+30);//画炮筒
                g.drawOval(x+10, y+10,40,40);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);//画左轮子
                g.fill3DRect(x+10, y+10,40,40,false);//画身体
                g.fill3DRect(x,y+50,60,10,false);//画右轮子
                g.drawLine(x, y+30, x+30, y+30);//画炮筒
                g.drawOval(x+10, y+10,40,40);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirect(0);
            hero.MoveUp();
        } else if (e.getKeyCode()==KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.MoveRight();
        } else if (e.getKeyCode()==KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.MoveDown();
        } else if (e.getKeyCode()==KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.MoveLeft();
        }

        /*按下J键，让hero中的shotEnemyTank()方法去启动相应的shot线程*/
        if(e.getKeyCode()==KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    /*现在我们已经有子弹打出去的位置数据了，现在要给它画出来，每隔50ms就画一次，
    所以要用到线程，就让MyPanel去实现线程那个接口
    * */
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.repaint();
        }
    }
}
