package com.code.musicboard;

//Test7.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class Test7 {
    public static void main(String[] args)  throws IOException
    {
        JFrame  jf = new JFrame("康樂彩歌");
        MyPanel jp = new MyPanel();
        //jp.setBackground(Color.lightGray);

        jp.setBorder(BorderFactory.createLineBorder(Color.black));
        jf.setBounds(0, 0, 1368, 730);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("選歌：");    //創建標簽
        label1.setFont(new Font("新細明體", Font.PLAIN, 20));
        JComboBox cmbox = new JComboBox();    //創建JComboBox
        //cmb.setLocation(500,500);
        cmbox.setFont(new Font("新細明體", Font.PLAIN, 20));
        //cmb.setBounds(120,80,150,30);

        cmbox.addItem("紫竹調");
        cmbox.addItem("走一同去郊遊");
        cmbox.addItem("大野狼");
        cmbox.addItem("歸來吧蘇連多");
        cmbox.addItem("追尋");
        cmbox.addItem("三輪車");
        cmbox.addItem("我家門前有小河");
        cmbox.addItem("漁家樂");
        cmbox.addItem("嚕啦啦");
        cmbox.addItem("踏雪尋梅");

        JRadioButton rb2 = new JRadioButton("加人聲", false);
        rb2.setFont(new Font("新細明體", Font.PLAIN, 20));

        JButton btPlay = new JButton("PLAY");
        btPlay.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

        JButton btStop = new JButton("STOP");
        btStop.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

        JButton btContinue = new JButton("CONTINUE");
        btContinue.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

        jp.add(label1);
        jp.add(cmbox);
        //jp.add(rb1);
        jp.add(rb2);
        jp.add(btPlay);
        jp.add(btStop);
        jp.add(btContinue);

        btPlay.addActionListener(new ActionListener() {//给按钮添加事件接收器
            @Override
            public void actionPerformed(ActionEvent e) {//接受到事件后,进行下面的处理
                //System.out.println("Hello World");// 控制台打印输出
                //JOptionPane.showMessageDialog(null, "Hello World");// 弹出对话框,显示Hello World
            }
        });

        jf.setVisible(true);
        jf.add(jp);

        //AudioTest au1 = new AudioTest();
        //au1.AudioPlay();
        jp.display();
    }
}

