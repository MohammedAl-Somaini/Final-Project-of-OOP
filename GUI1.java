package Frames;

import javax.swing.*;
import java.awt.*;

public class GUI1 extends JFrame {
    JPanel n;
    JLabel Wn;
    JButton b;
    JTextField t;
    public GUI1(){

        n.setLayout(new FlowLayout());
        n=new JPanel();
        Wn=new JLabel("Drug Name");
        t=new JTextField(20);
        b=new JButton("Ok");
        n.add(Wn);
        n.add(t);
        n.add(b);
        add(n);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GUI1 f;
        f = new GUI1();
    }
}
