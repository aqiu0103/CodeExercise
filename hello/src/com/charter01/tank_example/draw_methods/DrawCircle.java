package com.charter01.tank_example.draw_methods;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    //属性,定义一个面板属性
    private MyPanel mp=null;
    //主方法
    public static void main(String[] args) {
        new DrawCircle();
    }
    //构造器
    public DrawCircle(){
        mp=new MyPanel();//给mp赋一个对象实例，mp已经在上面定义过了
        this.add(mp);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    public void paint(Graphics g){
        super.paint(g);
        //g.drawOval(10,10,100,100);
        g.setColor(Color.BLUE);
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("你好",100,100);
    }
}
