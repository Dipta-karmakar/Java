package classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class user_details extends JFrame implements ActionListener {
    Container con;
    JLabel heading, img_label;

    JButton backBtn, deleteBtn, refreshBtn;
    JTable table;
    JScrollPane scroll;
    ImageIcon img;

    public user_details() {

        con = this.getContentPane();
        con.setLayout(null);
        // con.setBackground(new Color(137, 22, 63));

        this.setTitle("user_details");
        this.setBounds(320, 150, 850, 550);

        heading = new JLabel("User Data");
        heading.setBounds(340, 40, 300, 30);
        heading.setFont(new Font("Seigo UI", Font.BOLD, 25));
        heading.setForeground(Color.white);
        con.add(heading);

        String colums[] = { "Username", "Password", "E-mail", "DateOFBirth" };
        String rows[][] = {

                { "dipto", "pass", "Dipto@gmail.com", "23/12/2002" },
        };

        table = new JTable(rows, colums);

        scroll = new JScrollPane(table);
        scroll.setBounds(60, 100, 700, 300);
        con.add(scroll);

        // Buttons
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 25, 100, 30);
        backBtn.setBackground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        con.add((backBtn));

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(100, 440, 150, 35);
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setForeground(Color.white);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setFont(new Font("Seigo UI", Font.BOLD, 16));
        con.add(deleteBtn);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(300, 440, 150, 35);
        refreshBtn.setBackground(Color.white);
        refreshBtn.setForeground(Color.black);
        refreshBtn.setFocusPainted(false);
        refreshBtn.setFont(new Font("Seigo UI", Font.BOLD, 16));
        refreshBtn.addActionListener(this);
        con.add(refreshBtn);

        img = new ImageIcon(getClass().getResource("../images/user_details.jpg"));
        img_label = new JLabel(img);
        img_label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            Admin_panel ap = new Admin_panel();
            ap.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == refreshBtn) {
            this.setVisible(false);
            user_details us = new user_details();
            us.setVisible(true);
        }
    }

    public static void main(String[] args) {
        user_details us = new user_details();
        us.setVisible(true);
        us.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
