package com.Tank_Battles02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义MyPanel中的属性，即面板中的坦克
    Hero hero=null;
    Vector<EnemyTank> enemyTanks=new Vector<>();
    Vector<Boom> booms=new Vector<>();//把爆炸的三张效果图放到组中存放
    Image image1=null;
    Image image2=null;
    Image image3=null;

    //构造函数
    public MyPanel(){
        hero=new Hero(200,200);

        /*敌方坦克参数初始化,同时把shot参数放到敌方坦克中*/
        for (int i = 0; i < 3; i++) {
            //敌方坦克初始化参数
            EnemyTank enemyTank =new EnemyTank(10+i*100,10);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);

            //敌方坦克shot属性初始化，把它放到shots里
            Shot shot=new Shot(enemyTank.getX(),enemyTank.getY(),enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();//同时启动shot线程
        }

        /*初始化爆炸效果，把三张效果图先赋值给变量image*/
        image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/稿定抠图1.png"));
        image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/稿定抠图2.png"));
        image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/稿定抠图3.png"));
    }

    //绘图方法
    public void paint(Graphics g){
        super.paint(g);//调用父类初始化
        g.fillRect(0,0,1000,750);
        DrawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//画hero坦克

        /*画出敌方坦克和敌方子弹*/
        //先把敌方坦克取出来
        for (EnemyTank enemyTank : enemyTanks) {
            if(enemyTank.isLive) {
                DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);//若坦克存在，则画出坦克

                for (int j = 0; j < enemyTank.shots.size(); j++) {//遍历每个敌方坦克的shot
                    Shot shot = enemyTank.shots.get(j);//取出该敌方坦克的shot参数
                    if (shot.isLive) {
                        g.fill3DRect(shot.getX() + 30, shot.getY() + 60, 2, 2, false);//注意这里是shot的坐标
                    } else enemyTank.shots.remove(shot);
                }
            }
        }

        /*画出我方子弹*/
        if (hero.shot!=null && hero.shot.isLive){
            g.fill3DRect(hero.shot.getX(),hero.shot.getY(),2,2,false);
        }

        /*如果booms集合中有boom对象，则将其取出，并根据爆炸的生命周期的不同阶段来绘制相应的image*/
        for (int i = 0; i < booms.size(); i++) {
            Boom boom=booms.get(i);//取出boom对象
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(boom.life>6){
                g.drawImage(image1, boom.x, boom.y, 60,60,this);
            }
            else if(boom.life>3){
                g.drawImage(image2, boom.x, boom.y, 60,60,this);
            }
            else if(boom.life>0){
                g.drawImage(image3, boom.x, boom.y, 60,60,this);
            }
            boom.lifeDown();//每次减少一生命值
            if(boom.life==0){
                booms.remove(boom);
            }
        }
    }

    /*判断我方坦克子弹是否命中敌方坦克*/
    public void hitTank(Shot shot,EnemyTank enemyTank){
        if(shot!=null&&shot.isLive&&shot.getX()>=enemyTank.getX()&& shot.getX()<=enemyTank.getX()+60&&
                shot.getY()>=enemyTank.getY()&&shot.getY()<=enemyTank.getY()+60){
            /*如果命中了，就加一个boom对象到booms集合中！！！！！！！！！！！！*/
            Boom boom=new Boom(enemyTank.getX(),enemyTank.getY());
            booms.add(boom);

            enemyTank.isLive=false;
            enemyTanks.remove(enemyTank);
            shot.isLive=false;//我方坦克击中敌方坦克后子弹就没有了，因此之后在敌方坦克被命中时的操作要加一个对我方子弹是否存在的判断


        }
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
            for (int i = 0; i < enemyTanks.size(); i++) {//判断我方子弹是否击中敌方坦克
               EnemyTank enemyTank=enemyTanks.get(i);
                hitTank(hero.shot,enemyTank);
            }
            this.repaint();//paint方法重绘
        }
    }
}
