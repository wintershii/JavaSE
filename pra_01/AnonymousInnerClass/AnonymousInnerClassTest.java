package cn.pra_01.AnonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates anonymous inner classes
 *
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}

class TalkingClock{


    public void start(int interval, boolean beep){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("A the tone,the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        javax.swing.Timer t = new Timer(interval,listener);
        t.start();
    }

}
