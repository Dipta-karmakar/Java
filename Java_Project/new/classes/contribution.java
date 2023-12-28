package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

public class contribution extends JFrame implements ActionListener {

    JLabel l1, l1_2, l2, l3, l4, l5;
    Container con;
    ImageIcon img, icon;
    JButton ok;

    public contribution() {

        con = this.getContentPane();
        con.setLayout(null);

        this.setTitle("contribution");
        this.setBounds(330, 100, 850, 550);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        l2 = new JLabel("Contribution");
        l2.setBounds(300, 100, 300, 40);
        l2.setFont(new Font("Seigo UI", Font.BOLD, 35));
        l2.setForeground(Color.black);
        con.add(l2);

        l1_2 = new JLabel("_____________________");
        l1_2.setBounds(270, 110, 500, 40);
        l1_2.setForeground(Color.black);
        l1_2.setFont(new Font("Seigo UI", Font.BOLD, 25));
        con.add(l1_2);

        l3 = new JLabel("Dipta Prattoy Karmakar");
        l3.setBounds(270, 140, 500, 40);
        l3.setFont(new Font("Seigo UI", Font.BOLD, 25));
        l3.setForeground(Color.black);
        con.add(l3);

        l4 = new JLabel("ID : 23-51069-1");
        l4.setBounds(310, 170, 300, 40);
        l4.setFont(new Font("Seigo UI", Font.BOLD, 25));
        l4.setForeground(Color.black);
        con.add(l4);

        l5 = new JLabel("23-51069-1@student.aiub.edu");
        l5.setBounds(240, 200, 500, 40);
        l5.setFont(new Font("Seigo UI", Font.BOLD, 25));
        l5.setForeground(Color.black);
        con.add(l5);

        ok = new JButton("OK");
        ok.setBounds(310, 420, 200, 40);
        ok.setFocusPainted(false);
        ok.addActionListener(this);
        con.add(ok);

        img = new ImageIcon(getClass().getResource("../images/contribution.jpg"));
        l1 = new JLabel(img);
        l1.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        con.add(l1);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ok) {
            welcome w1 = new welcome();
            w1.setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        contribution c = new contribution();
        c.setVisible(true);
    }
}
