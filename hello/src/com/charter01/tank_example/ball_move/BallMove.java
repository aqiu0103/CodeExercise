package com.charter01.tank_example.ball_move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {
    //属性
    private MyPanel mp=null;
    public static void main(String[] args) {
        new BallMove();
    }
    //构造函数
    public BallMove(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }
}

/*
*面板实现键盘监听接口
* */
class MyPanel extends JPanel implements KeyListener {
    int x=10;
    int y;
    //面板里有画图方法
    public void paint(Graphics g){
        super.paint(g);//调用父类JPanel中的paint方法来初始化画笔
        g.fillOval(x,y,10,10);
    }

    //有字符输入，该方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下按键，该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            y=y+3;
            this.repaint();
        }
        else if (e.getKeyCode()==KeyEvent.VK_UP) {
            y=y-3;
            this.repaint();
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            x=x+3;
            this.repaint();
        }
        else {
            x=x-3;
            this.repaint();
        }
    }

    //释放按键，该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
