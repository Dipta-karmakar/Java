package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import EntityList.TeamList;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user_Homepage_Updated extends JFrame implements ActionListener {
    Container con;
    ImageIcon img, icon;
    JLabel img_Label, heading, l1;
    JButton bt1, bt2, bt3, bt4, backBtn;
    TeamList l;

    public user_Homepage_Updated()

    {
        con = this.getContentPane();
        con.setLayout(null);

        this.setBounds(320, 150, 850, 550);
        this.setTitle("User Homepage");

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        heading = new JLabel("User Homepage");
        heading.setBounds(320, 30, 300, 40);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Seigo UI", Font.BOLD, 28));
        con.add(heading);

        l1 = new JLabel("_____________________________________");
        l1.setBounds(290, 40, 300, 40);
        l1.setFont(new Font("Seigo UI", Font.BOLD, 30));
        con.add(l1);

        bt1 = new JButton("Manage Team");
        bt1.setBounds(110, 180, 200, 50);
        bt1.setBackground(Color.GREEN);
        bt1.setFocusPainted(false);
        bt1.setFont(new Font("Seigo UI", Font.BOLD, 19));
        bt1.setForeground(Color.black);
        con.add(bt1);
        bt1.addActionListener(this);

        bt2 = new JButton("Manage Player");
        bt2.setBounds(110, 260, 200, 50);
        bt2.setBackground(Color.green);
        bt2.setFocusPainted(false);
        bt2.setFont(new Font("Seigo UI", Font.BOLD, 19));
        bt2.setForeground(Color.black);
        con.add(bt2);
        bt2.addActionListener(this);

        bt3 = new JButton("Manage Owner");
        bt3.setBounds(110, 340, 200, 50);
        bt3.setBackground(Color.green);
        bt3.setFocusPainted(false);
        bt3.setFont(new Font("Seigo UI", Font.BOLD, 19));
        bt3.setForeground(Color.black);
        con.add(bt3);
        bt3.addActionListener(this);

        // Buttons
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 25, 100, 30);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.black);
        backBtn.setFocusPainted(false);
        con.add((backBtn));
        backBtn.addActionListener(this);

        img = new ImageIcon(getClass().getResource("../images/user_homepage1.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_Label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt1) {
            manage_team t = new manage_team();
            t.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == bt2) {

            manage_player m = new manage_player(this, l);
            m.setVisible(true);
            this.dispose();

        } else if (e.getSource() == bt3) {
            JOptionPane.showMessageDialog(null, "Currently not available");
        } else if (e.getSource() == backBtn) {
            login_type lp = new login_type();
            lp.setVisible(true);
            this.dispose();

        }
    }

    public static void main(String[] args) {

        user_Homepage_Updated w = new user_Homepage_Updated();
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}