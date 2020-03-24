package com.code.musicboard;


//Test21.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MyPanel extends JPanel{
    int x[] = new int[59];
    int y[] = new int[59];
    int width[] = new int[59];
    int height = 20;
    Color color[] = new Color[59];//the color of each note

    //一根紫 竹 直 苗 苗,      5  ĺ  65 3 │ 52 32 1 ─
    //送給寶寶做管 簫,      6 ĺ   3 5  6 3 │5 ─ ─ ─
    //簫兒對準口,            ĺ 6 3 6 5 ─
    //口兒對準簫,           6 5 3 6  5 ─
    //簫 中吹 出  新 時 調, 56  ĺ  65 3 │ 52 32 1 ─
    //小寶寶, 小寶 寶,      1 13 2 ─  | 1 13 2  ─
    //咿底 咿底學會了.啊～～  6 ĺ   6  ĺ  2 6 | 5 . 6  23 56│ 5 ─ ─ ─

    String[] lyric = {"一", " 根", "紫～", "竹", "直～", "苗～", "苗,", "送", "給", "寶", "寶", "做", "管", "簫,",
            "簫", "兒", "對", "準", "口,", "口", "兒", "對", "準", "簫,",
            "簫～", "中", "吹～", "出", "新～", "時～ ", "調,",
            "小", "寶～", "寶,", "小", "寶～", "寶,",
            "咿", "底", "咿", "底", "學 ", "會", "了,", "啊 ～     ～    ～"};//共45個

    int[] numNotes = {1, 1, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            2, 1, 2, 1, 2, 2, 1,
            1, 2, 1, 1, 2, 1,
            1, 1, 1, 1, 1, 1, 1, 6};//共45個

    int[][] notes = {{5,2},{8,2},{6,1},{5,1},{3,2},{5,1},{2,1},{3,1},{2,1},{1,4},{6,1},{8,1},
            {3,1},{5,1},{6,2},{3,2},{5,8},{8,1},{6,1},{3,1},{6,1},{5,4},{6,1},{8,1},
            {3,1},{6,1},{5,4},{5,1},{6,1},{8,2},{6,1},{5,1},{3,2},{5,1},{2,1},{3,1},
            {2,1},{1,4},{1,2},{1,1},{3,1},{2,4},{1,2},{1,1},{3,1},{2,4},{6,1},{8,1},
            {6,1},{8,1},{9,2},{6,2},{5,3},{6,1},{2,1},{3,1},{5,1},{6,1},{5,8}};//共59個

    String[] simplifiedNote = {"| 5", "  1", " 6", "5", "3", "| 5", "2", "3", "2", "1  - ", "| 6", "1",
            "3", "5", "6", " 3", " 5  -  -  -", "| 1", "6", "3", "6", "5  - ", "| 6", "1",
            "3", "6", "5  -", "| 5", "6", "1", "6", "5", " 3", "| 5", "2", "3",
            "2", "1   -", "| 1", "1", "3", "2   -", "| 1", "1", "3", "2  -", "| 6", "1",
            "6", "1", "2", "6", "| 5   .", "6", "2", "3", "5", "6", "| 5  -  -  - "};//共59個

    Color color0 = new Color(255,255,255); //白色
    Color color1 = new Color(255,0,0); //紅色
    Color color2 = new Color(255,165,0); //橙色
    Color color3 = new Color(255,255,0); //黃色
    Color color4 = new Color(0,128,0); //綠色
    Color color5 = new Color(0,0,255); //藍色
    Color color6 = new Color(75,0,130); //靛色
    Color color7 = new Color(100,0,153); //紫色
    Color color8 = new Color(153,0,0); //暗紅
    Color color9 = new Color(0,0,0); //黑色
    Color color10 = new Color(37,255,255); //淺藍

    public void display(){
        for (int i = 0;i < notes.length; i++) {
            //System.out.println("notes[" + i + "][0] = " + notes[i][0]);
            switch (notes[i][0]) {
                case 1:
                    y[i] = 400;
                    color[i] = color1;
                    break;
                case 2:
                    y[i] = 400 - 20;
                    color[i] = color2;
                    break;
                case 3:
                    y[i] = 400 - 20*2;
                    color[i] = color3;
                    break;
                case 4:
                    y[i] = 400 - 20*3;
                    color[i] = color4;
                    break;
                case 5:
                    y[i] = 400 - 20*4;
                    color[i] = color5;
                    break;
                case 6:
                    y[i] = 400 - 20*5;
                    color[i] = color6;
                    break;
                case 7:
                    y[i] = 400 - 20*6;
                    color[i] = color7;
                    break;
                case 8:
                    y[i] = 400 - 20*7;
                    color[i] = color1;
                    break;
                case 9:
                    y[i] = 400 - 20*8;
                    color[i] = color2;
            }

            switch (notes[i][1]) {
                case 1: width[i] = 20;
                    break;
                case 2: width[i] = 20 * 2;
                    break;
                case 3: width[i] = 20 * 3;
                    break;
                case 4: width[i] = 20 * 4;
                    break;
                case 5: width[i] = 20 * 5;
                    break;
                case 6: width[i] = 20 * 6;
                    break;
                case 7: width[i] = 20 * 7;
                    break;
                case 8: width[i] = 20 * 8;
            }
        }

        x[0] = 100;
        for (int i = 1; i < notes.length; i++){
            x[i] = x[i-1] + width[i-1];
        }



        int timeLast = 0; //total executing time

        while(timeLast < 900){
            for (int i = 0; i < notes.length; i ++){
                x[i]--;
            }
            this.repaint();
            try {Thread.sleep(10);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
            timeLast = timeLast + 1;
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(color9);
        g2d.setFont(new Font("新細明體", Font.BOLD, 20));

        int y1 = 130; //C調 4/4 Y坐標
        int y2 = 180; //簡譜行Y坐標
        int y3 = 210; //歌詞行Y坐標
        int y4 = 163; //加高音點
        int y5 = 180; //加八分音符底線
        int y6 = 470;  //色彩音符說明

        int chrPosition = 0;
        g2d.drawString("C調  4/4", 16, y1);

        //色彩音符說明
        g2d.drawString("色彩音符：", 16, y6);
        g2d.setColor(color1);

        g2d.fillRoundRect(126, y6-16, 20,20, 3,3);
        g2d.setColor(color9);
        g2d.drawString(": Do", 150, y6);//126 + 24
        g2d.setColor(color2);
        g2d.fillRoundRect(206, y6-16, 20,20, 3,3);//150 + 56
        g2d.setColor(color9);
        g2d.drawString(": Re", 230, y6);//206 + 24
        g2d.setColor(color3);
        g2d.fillRoundRect(286, y6-16, 20,20, 3,3);//230 + 56
        g2d.setColor(color9);
        g2d.drawString(": Mi", 310, y6);//286 + 24
        g2d.setColor(color4);
        g2d.fillRoundRect(366, y6-16, 20,20, 3,3);//310 + 56
        g2d.setColor(color9);
        g2d.drawString(": Fa",390, y6);//366 + 24
        g2d.setColor(color5);
        g2d.fillRoundRect(446, y6-16, 20,20, 3,3);//390 + 56
        g2d.setColor(color9);
        g2d.drawString(": So", 470, y6);//446 + 24
        g2d.setColor(color6);
        g2d.fillRoundRect(526, y6-16, 20,20, 3,3);//470 + 56
        g2d.setColor(color9);
        g2d.drawString(": La", 550, y6);//526 + 24
        //g2d.setColor(color7);
        //g2d.fillRoundRect(606, y6-16, 20,20, 3,3);//550 + 56
        //g2d.setColor(color9);
        //g2d.drawString(":Si", 630, y6);//606 + 24

        //寫出簡譜
        for (int i = 0;i < simplifiedNote.length; i++){

            g2d.drawString(simplifiedNote[i], x[i], y2);
        }

        //在簡譜下方寫出歌詞
        g2d.setColor(color9);
        for (int i = 0;  i < lyric.length; i++){
            if (i != 0 && numNotes[i-1] == 2) {
                chrPosition = chrPosition + 1;
                g2d.drawString(lyric[i], x[chrPosition], y3);
            }
            else {
                g2d.drawString(lyric[i], x[chrPosition], y3);
            }
            chrPosition = chrPosition + 1;
        }


        //在簡譜上方加高音點
        g2d.setColor(color9);
        g2d.drawString(".", x[1]+14, y4);
        g2d.drawString(".", x[11]+2, y4);
        g2d.drawString(".", x[17]+11, y4);
        g2d.drawString(".", x[23]+2, y4);
        g2d.drawString(".", x[29]+2, y4);
        g2d.drawString(".", x[47]+2, y4);
        g2d.drawString(".", x[49]+2, y4);
        g2d.drawString(".", x[50]+2, y4);

        //在簡譜下方加八分音符底線
        g2d.setColor(color9);
        g2d.drawString("_", x[2]+4, y5);
        g2d.drawString("_", x[3], y5);
        g2d.drawString("_", x[5]+8, y5);
        g2d.drawString("_", x[6], y5);
        g2d.drawString("_", x[7], y5);//5
        g2d.drawString("_", x[8], y5);
        g2d.drawString("_", x[10]+8, y5);
        g2d.drawString("_", x[11], y5);
        g2d.drawString("_", x[12], y5);
        g2d.drawString("_", x[13], y5);//10
        g2d.drawString("_", x[17]+8, y5);
        g2d.drawString("_", x[18], y5);
        g2d.drawString("_", x[19], y5);
        g2d.drawString("_", x[20], y5);
        g2d.drawString("_", x[22]+8, y5);//15
        g2d.drawString("_", x[23], y5);
        g2d.drawString("_", x[24], y5);
        g2d.drawString("_", x[25], y5);
        g2d.drawString("_", x[27]+8, y5);
        g2d.drawString("_", x[28], y5);//20
        g2d.drawString("_", x[30], y5);
        g2d.drawString("_", x[31], y5);
        g2d.drawString("_", x[33]+8, y5);
        g2d.drawString("_", x[34], y5);
        g2d.drawString("_", x[35], y5);
        g2d.drawString("_", x[36], y5);//25
        g2d.drawString("_", x[39], y5);
        g2d.drawString("_", x[40], y5);
        g2d.drawString("_", x[43], y5);//1
        g2d.drawString("_", x[44], y5);//3
        g2d.drawString("_", x[46]+8, y5);//6
        g2d.drawString("_", x[47], y5);//1
        g2d.drawString("_", x[48], y5);//6
        g2d.drawString("_", x[49], y5);//1
        g2d.drawString("_", x[53], y5);//6
        g2d.drawString("_", x[54], y5);//2
        g2d.drawString("_", x[55], y5);//3
        g2d.drawString("_", x[56], y5);//5
        g2d.drawString("_", x[57], y5);//6

        //在歌詞下方繪出彩色譜
        for (int i = 0;i < notes.length; i++){

            g2d.setColor(color[i]);
            g2d.fillRoundRect(x[i], y[i], width[i], height, 3,3); //畫圓角方塊

            g2d.setColor(color8);
            g2d.drawLine(x[i],230, x[i]+width[i], 230);//畫水平上線

            g2d.setColor(color8);
            g2d.drawLine(x[i],231, x[i], 429);//畫直紅線

            g2d.setColor(color8);
            g2d.drawLine(x[i],430, x[i]+width[i], 430);//畫水平下線
        }
        g2d.setColor(color8);
        g2d.drawLine(x[notes.length-1]+ width[notes.length - 1],231, x[notes.length - 1] + width[notes.length - 1],429);//畫邊界直紅線
    }
}

public class Test21 implements Runnable {
    private Thread t;
    private String threadName;

    Test21(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

//    AudioTest au1 = new AudioTest();
    MyPanel jp = new MyPanel();

    public void run() {

        try {
            //jp.display();
//            if (au1!=null) {au1.AudioPlay();}
            if (jp!=null) {
                JFrame  jf = new JFrame("康樂彩歌");
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
        } finally {}
        //System.out.println(threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }


    public static void main(String[] args) {
        Test21 R1 = new Test21( "Thread-1");
        R1.start();

    }
}