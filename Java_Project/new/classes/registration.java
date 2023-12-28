package classes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import java.lang.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.Cursor;
import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.awt.EventQueue;

public class registration extends JFrame {
    Container con;
    JPanel panel;
    Dimension size;
    JLabel img_Label, l1, l2, l3, l4, l5, l6, l7;
    JLabel lebel1, lebel2, lebel3, lebel4, lebel5, lebel6, lebel7, lebel8, lebel9,
            lebel10, lebel11;

    JLabel lf1, lf2, lf3, lf4, lf5, lf6, lf7, lf8, lf9;
    JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9;
    JPasswordField pf1, pf2;
    JButton button1, button2, button3, button4, button5, backBtn;
    JRadioButton Box1, Box2, Box3;
    ButtonGroup Button_grp;
    JCheckBox c;
    JComboBox religion, securityQsn;
    ImageIcon i1, img, icon;

    public registration(String type) {

        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(117, 22, 63));

        this.setTitle("REGISTRATION");
        this.setBounds(320, 100, 1000, 650);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        img = new ImageIcon(getClass().getResource("../images/registration.jpg"));
        img_Label = new JLabel(img);
        size = img_Label.getPreferredSize();
        img_Label.setBounds(0, 0, size.width, size.height);
        con.add(img_Label);

        // // right portion

        l1 = new JLabel(" User Registration");
        l1.setLayout(null);
        l1.setBounds(630, 52, 300, 60);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cascadia Code", Font.BOLD, 25));
        con.add(l1);

        // 370,400,405
        lebel10 = new JLabel("User Name");
        lebel10.setBounds(550, 170, 200, 40);
        lebel10.setForeground(Color.white);
        lebel10.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel10);

        field5 = new JTextField();
        field5.setBounds(555, 200, 200, 30);
        field5.setForeground(Color.white);
        field5.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        field5.setCaretColor(Color.white);
        field5.setBorder(null);
        field5.setOpaque(false);

        lf5 = new JLabel("_______________________________");
        lf5.setBounds(550, 205, 220, 40);
        lf5.setForeground(Color.white);
        con.add(field5);
        con.add(lf5);

        lebel11 = new JLabel("Password");
        lebel11.setBounds(550, 230, 200, 40);
        lebel11.setForeground(Color.white);
        lebel11.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel11);

        pf1 = new JPasswordField();
        pf1.setBounds(555, 260, 200, 30);
        pf1.setForeground(Color.white);
        pf1.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        pf1.setCaretColor(Color.white);
        pf1.setEchoChar('*');
        pf1.setBorder(null);
        pf1.setOpaque(false);
        lf6 = new JLabel("_______________________________");
        lf6.setBounds(550, 265, 220, 40);
        lf6.setForeground(Color.white);
        con.add(pf1);
        con.add(lf6);

        // email

        lebel7 = new JLabel("Email");
        lebel7.setBounds(550, 300, 300, 40);
        lebel7.setForeground(Color.white);
        lebel7.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel7);

        field4 = new JTextField();
        field4.setBounds(555, 330, 380, 30);
        field4.setForeground(Color.white);
        field4.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        field4.setCaretColor(Color.white);
        field4.setBorder(null);
        field4.setOpaque(false);
        lf4 = new JLabel("________________________________________");
        lf4.setBounds(550, 335, 400, 40);
        lf4.setForeground(Color.white);
        con.add(field4);
        con.add(lf4);

        /// Date of birth
        lebel4 = new JLabel("Date of Birth(dd/mm/yyyy)");
        lebel4.setBounds(550, 370, 300, 40);
        lebel4.setForeground(Color.white);
        lebel4.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel4);

        field3 = new JTextField();
        field3.setBounds(555, 400, 230, 30);
        field3.setForeground(Color.white);
        field3.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        field3.setCaretColor(Color.white);
        field3.setBorder(null);
        field3.setOpaque(false);
        lf3 = new JLabel("______________________________");
        lf3.setBounds(550, 405, 250, 40);
        lf3.setForeground(Color.white);
        con.add(field3);
        con.add(lf3);

        button2 = new JButton("Register");
        button2.setBounds(550, 500, 400, 35);
        button2.setFont(new Font("Cascadia Code", Font.PLAIN, 20));
        button2.setBackground(Color.GREEN);
        button2.setForeground(Color.black);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button2.setFocusPainted(false);
        button2.setBackground(Color.WHITE);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String uname = field5.getText();
                String pass = String.valueOf(pf1.getPassword());
                String fname = "./data/user.txt";
                String DOB = field3.getText();
                String email = field4.getText();

                if (field5.getText().isEmpty() || String.valueOf(pf1.getPassword()).isEmpty()
                        || field3.getText().isEmpty()
                        || field4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all the information");
                } else if ((e.getSource() == button2 && type == "user")) {
                    user.registerUser(uname, pass, "./data/user.txt", DOB, email);
                    // JOptionPane.showMessageDialog(null, "user");
                }
            }
        });
        con.add(button2);

        lebel9 = new JLabel("Already have an account?");
        lebel9.setBounds(550, 570, 250, 30);
        lebel9.setForeground(Color.white);
        lebel9.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel9);

        button3 = new JButton("Sign In");
        button3.setBounds(780, 570, 150, 30);
        button3.setBackground(new Color(117, 22, 63));
        button3.setFont(new Font("Cascadia Code", Font.BOLD, 19));
        button3.setForeground(Color.white);
        button3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button3) {
                    login_type lp = new login_type();
                    lp.setVisible(true);
                    dispose();

                }
            }
        });
        con.add(button3);

        // back button
        backBtn = new JButton("BACK");
        backBtn.setBounds(860, 20, 100, 30);
        backBtn.setBackground(Color.white);
        backBtn.setForeground(new Color(117, 22, 63));
        backBtn.setFocusPainted(false);
        con.add((backBtn));
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backBtn) {
                    login_type lp = new login_type();
                    lp.setVisible(true);
                    // this.setVisible(false);
                    dispose();

                }
            };

        });

        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        registration g = new registration(null);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}