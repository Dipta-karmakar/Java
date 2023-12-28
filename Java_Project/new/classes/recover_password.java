package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import java.awt.Color;
import java.awt.Container;

public class recover_password extends JFrame implements ActionListener {
    Container con;
    ImageIcon img;
    JLabel img_Label, l1, l2, l3, l4, heading;
    JButton backBtn, loginBtn;

    JTextField tf1, pf1;
    // because showing the password

    public recover_password(String uname, String pass) {

        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(137, 22, 63));

        this.setTitle("Recover Password");
        this.setBounds(320, 150, 900, 600);

        heading = new JLabel("Recovered Data");
        heading.setBounds(600, 140, 200, 30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Seigo UI", Font.BOLD, 24));
        con.add(heading);

        l1 = new JLabel("User Name");
        l1.setBounds(484 + 50, 212, 300, 40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l2 = new JLabel("Password");
        l2.setBounds(484 + 50, 312, 150, 40);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l3 = new JLabel("____________________________________________");
        l3.setBounds(484 + 50, 262, 400, 40);
        l3.setForeground(Color.white);
        l3.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l4 = new JLabel("_____________________________________________");
        l4.setBounds(484 + 50, 362, 400, 40);
        l4.setForeground(Color.white);
        l4.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        tf1 = new JTextField();
        tf1.setBounds(534, 252, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tf1.setForeground(Color.white);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.white);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        pf1 = new JTextField();
        pf1.setBounds(534, 352, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pf1.setForeground(Color.white);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.white);
        pf1.setBorder(null);
        pf1.setOpaque(false);

        tf1.setText(uname);
        pf1.setText(pass);
        // button
        backBtn = new JButton("Back");
        backBtn.setBounds(770, 30, 80, 35);
        backBtn.setBackground(new Color(137, 22, 63));
        backBtn.setFocusPainted(false);
        backBtn.setForeground(Color.white);
        backBtn.setFont(new Font("Seigo UI", Font.BOLD, 14));

        loginBtn = new JButton("Login");
        loginBtn.setBounds(530, 460, 300, 40);
        loginBtn.setBackground(Color.white);
        loginBtn.setForeground(new Color(137, 22, 63));
        loginBtn.setFont(new Font("Seigo UI", Font.BOLD, 18));
        loginBtn.setFocusPainted(false);

        backBtn.addActionListener(this);
        loginBtn.addActionListener(this);

        img = new ImageIcon(getClass().getResource("../images/recover_password.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(-30, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_Label);

        con.add(l1);
        con.add(l2);
        con.add(l3);
        con.add(l4);

        con.add(tf1);
        con.add(pf1);

        con.add(backBtn);
        con.add(loginBtn);

        this.setVisible(true);
    }

    // listeners

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            forgot_password f = new forgot_password();
            f.setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == loginBtn) {
            login_type lp = new login_type();
            lp.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        recover_password r = new recover_password(null, null);
        r.setVisible(true);
    }
}