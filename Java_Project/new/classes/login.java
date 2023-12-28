package classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class login {
    JFrame f1;
    JPanel p1;
    JPanel p2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, imglabel;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, backBtn;
    JCheckBox c1;
    JComboBox religion;
    ImageIcon i1, icon;
    JRadioButton r1, r2;
    ButtonGroup bg1;
    int pc = 0;

    login(String type) {

        f1 = new JFrame();
        // f1.setUndecorated(true);
        // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // i1 = new ImageIcon("image/logo.png");
        // f1.setIconImage(i1.getImage());

        p1 = new JPanel();
        p1.setBounds(0, 0, 1000, 700);
        p1.setBackground(new Color(117, 22, 63));

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        f1.setIconImage(icon.getImage());

        // labels
        l10 = new JLabel("Log In");
        l10.setBounds(672, 52, 300, 60);
        l10.setForeground(Color.white);
        l10.setFont(new Font("Segoe UI", Font.BOLD, 30));

        // l2 = new JLabel("Let's get started");
        // l2.setBounds(584, 120, 300, 40);
        // l2.setForeground(Color.white);
        // l2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l3 = new JLabel("User Name");
        l3.setBounds(484 + 50, 212, 300, 40);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l4 = new JLabel("Password");
        l4.setBounds(484 + 50, 312, 150, 40);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l6 = new JLabel("____________________________________________");
        l6.setBounds(484 + 50, 262, 400, 40);
        l6.setForeground(Color.white);
        l6.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l7 = new JLabel("_____________________________________________");
        l7.setBounds(484 + 50, 362, 400, 40);
        l7.setForeground(Color.white);
        l7.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l8 = new JLabel();
        l8.setIcon(new ImageIcon("image/login.jpg"));
        Dimension size = l8.getPreferredSize();
        l8.setBounds(0, 0, size.width, size.height);

        l9 = new JLabel("Don't have an account?");
        l9.setBounds(524, 562, 240, 40);
        l9.setForeground(Color.white);
        l9.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        i1 = new ImageIcon(getClass().getResource("../images/login.jpg"));
        l1 = new JLabel(i1);
        l1.setBounds(-40, 0, i1.getIconWidth(), i1.getIconHeight());
        p1.add(l1);

        // username
        tf1 = new JTextField("a");
        tf1.setBounds(534, 252, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tf1.setForeground(Color.white);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.white);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        // password
        pf1 = new JPasswordField("a");
        pf1.setBounds(534, 352, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pf1.setForeground(Color.white);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.white);
        pf1.setBorder(null);
        pf1.setOpaque(false);

        // c1 = new JCheckBox("Remember me");
        // c1.setBounds(534, 392, 160, 40);
        // c1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        // c1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // c1.setForeground(Color.white);
        // c1.setFocusPainted(false);
        // c1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        // c1.setContentAreaFilled(false);

        b2 = new JButton("Forgot Password?");
        b2.setBounds(710, 392, 170, 40);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);

        b3 = new JButton("Login");
        b3.setBounds(534, 460, 340, 40);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 22));
        b3.setForeground(new Color(117, 22, 63));
        b3.setBackground(new Color(255, 255, 255));
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setFocusPainted(false);
        // b3.addActionListener(religion);

        b4 = new JButton("Sign Up");
        b4.setBounds(765, 562, 90, 40);
        b4.setForeground(Color.white);
        b4.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b4.setForeground(new Color(255, 255, 255));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setFocusPainted(false);
        b4.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setContentAreaFilled(false);

        backBtn = new JButton("BACK");
        backBtn.setBounds(830, 50, 100, 30);
        backBtn.setFocusPainted(false);
        backBtn.setBackground(Color.white);
        f1.add((backBtn));

        bg1 = new ButtonGroup();
        // radio buttons
        r1 = new JRadioButton("Admin");
        r1.setBounds(540, 150, 150, 20);
        r1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        r1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        r1.setForeground(Color.white);
        r1.setBorderPainted(false);
        r1.setContentAreaFilled(false);
        r1.setFocusPainted(false);

        r2 = new JRadioButton("User");
        r2.setBounds(540, 180, 150, 20);
        r2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        r2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        r2.setForeground(Color.white);
        r2.setBorderPainted(false);
        r2.setContentAreaFilled(false);
        r2.setFocusPainted(false);

        if (type == "user") {
            r2.setSelected(true);
            r1.setEnabled(false);

        } else if (type == "admin") {
            tf1.setText("");
            pf1.setText("");
            r1.setSelected(true);
            r2.setEnabled(false);
            b2.setEnabled(false);

        }

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == b2) {
                    forgot_password l = new forgot_password();
                    l.setVisible(true);
                    f1.setVisible(false);

                }
            }
        });

        // login button
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = tf1.getText();
                String password = pf1.getText();
                user u = new user();
                admin_IO a = new admin_IO();
                if (tf1.getText().isEmpty() || pf1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");

                }

                else if (((e.getSource() == b3 && type == "user")) && (u.getUser(name, password))) {
                    JOptionPane.showMessageDialog(null, name + ", Successfully logged in");
                    user_Homepage_Updated us = new user_Homepage_Updated();
                    us.setVisible(true);
                    f1.setVisible(false);

                    // opening admin panel
                } else if (((e.getSource() == b3 && type == "admin")) && (a.getAdmin(name, password))) {
                    JOptionPane.showMessageDialog(null, name + ", Successfully logged in");
                    Admin_panel ap = new Admin_panel();

                    ap.setVisible(true);
                    f1.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Doesnt match");
                }

            }
        });

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backBtn) {
                    login_type lt = new login_type();
                    lt.setVisible(true);
                    f1.setVisible(false);
                }

            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == b4 && type == "user") {

                    registration r1 = new registration(type);
                    r1.setVisible(true);
                    f1.setVisible(false);
                } else if (ae.getSource() == b4 && type == "admin") {
                    admin_registration ar = new admin_registration(type);
                    ar.setVisible(true);
                    f1.setVisible(false);
                }

                else {
                    JOptionPane.showMessageDialog(null, "Select User or Admin");
                }
            }
        });

        bg1.add(r1);
        bg1.add(r2);

        f1.add(l1);
        // f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l6);
        f1.add(l7);
        f1.add(l9);
        f1.add(l10);
        // p1.add(l1);
        f1.add(r1);
        f1.add(r2);

        f1.add(tf1);
        f1.add(pf1);

        // f1.add(c1);

        // buttons
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);

        f1.add(p1);

        f1.setBounds(330, 100, 1000, 700);
        f1.setTitle("LOG IN");
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        login l = new login("user");

    }

}