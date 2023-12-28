package classes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Admin_panel extends JFrame implements ActionListener {
    JLabel label1, img_Label, bt1_1, bt2_2, bt3_3, bt4_4;
    Container con;
    JButton bt1, bt2, bt3, bt4, backBtn;
    ImageIcon img, icon;
    Dimension size;

    public Admin_panel() {

        con = this.getContentPane();
        con.setLayout(null);

        con.setBackground(new Color(117, 22, 63));
        this.setTitle("admin panel");
        this.setBounds(320, 150, 900, 600);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        // label
        label1 = new JLabel("Admin Panel");
        label1.setBounds(200, 30, 500, 50);
        label1.setFont(new Font("Seigo UI", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        label1.setLayout(null);
        con.add(label1);

        // BUTTONS

        // button-1
        bt1 = new JButton("User Details");
        bt1.setBounds(40, 140, 180, 80);
        bt1.setFont(new Font("Seigo UI", Font.BOLD, 17));
        bt1.setForeground(new Color(117, 22, 63));
        bt1.addActionListener(this);
        bt1.setFocusPainted(false);
        con.add(bt1);

        bt2 = new JButton("Add User");
        bt2.setBounds(260, 140, 180, 80);
        bt2.setFont(new Font("Seigo UI", Font.BOLD, 17));
        bt2.setForeground(new Color(117, 22, 63));
        bt2.addActionListener(this);
        bt2.setFocusPainted(false);
        con.add(bt2);

        bt3 = new JButton("Admin Details");
        bt3.setBounds(40, 240, 180, 80);
        bt3.setFont(new Font("Seigo UI", Font.BOLD, 17));
        bt3.setForeground(new Color(117, 22, 63));
        bt3.setFocusPainted(false);
        con.add(bt3);
        bt3.addActionListener(this);

        bt4 = new JButton("Add Admin");
        bt4.setBounds(260, 240, 180, 80);
        bt4.setFont(new Font("Seigo UI", Font.BOLD, 17));

        bt4.setForeground(new Color(117, 22, 63));
        bt4.setFocusPainted(false);
        bt4.addActionListener(this);
        con.add(bt4);

        // labels

        // bt1_1 = new JLabel("Player Information");
        // bt1_1.setBounds(170, 310, 400, 100);
        // bt1_1.setForeground(Color.WHITE);
        // // bt1_1.setFont(new Font("Seigo UI", Font.BOLD, 54));
        // con.add(bt1_1);

        backBtn = new JButton("BACK");
        backBtn.setBounds(40, 500, 100, 30);
        backBtn.setBackground(Color.white);
        backBtn.setForeground(new Color(117, 22, 63));
        backBtn.setFocusPainted(false);
        con.add((backBtn));
        backBtn.addActionListener(this);

        img = new ImageIcon(getClass().getResource("../images/admin_panel.jpg"));
        img_Label = new JLabel(img);
        size = img_Label.getPreferredSize();
        img_Label.setBounds(0, 0, size.width, size.height);
        con.add(img_Label);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {
            login_type lg = new login_type();
            lg.setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == bt4)

        {
            add_admin a = new add_admin();
            a.setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == bt3) {
            admin_details ad = new admin_details();
            ad.setVisible(true);
            this.setVisible(false);
        }

        // user Details

        else if (e.getSource() == bt1) {
            user_details us = new user_details();
            us.setVisible(true);
            this.setVisible(false);
        }
        // add user Button
        else if (e.getSource() == bt2) {
            add_user ad = new add_user();
            ad.setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        Admin_panel ad = new Admin_panel();
        ad.setVisible(true);
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
