package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Cursor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;

public class forgot_password extends JFrame implements ActionListener {
    Container con;
    ImageIcon img;
    JLabel img_Label, email_label, l3, l4, l6, l7, l10, l11;
    JTextField tf1, tf2, email_TextField;
    JButton back_Btn, recover_Btn;

    public forgot_password() {
        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(137, 22, 63));

        this.setTitle("Password Recovry");
        this.setBounds(320, 150, 900, 600);
        img = new ImageIcon(getClass().getResource("../images/forgot_password.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(-20, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_Label);

        l10 = new JLabel("Recover Password");
        l10.setBounds(560, 100, 300, 60);
        l10.setForeground(Color.white);
        l10.setFont(new Font("Segoe UI", Font.BOLD, 30));

        l3 = new JLabel("User Name");
        l3.setBounds(484 + 50, 212, 300, 40);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l4 = new JLabel("Date of Birth(dd/mm/yyyy)");
        l4.setBounds(484 + 50, 312, 300, 40);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l6 = new JLabel("__________________________________");
        l6.setBounds(484 + 50, 262, 400, 40);
        l6.setForeground(Color.white);
        l6.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l7 = new JLabel("___________________________________");
        l7.setBounds(484 + 50, 362, 400, 40);
        l7.setForeground(Color.white);
        l7.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        tf1 = new JTextField();
        tf1.setBounds(534, 252, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tf1.setForeground(Color.white);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.white);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        tf2 = new JTextField();
        tf2.setBounds(534, 352, 380, 30);
        tf2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tf2.setForeground(Color.white);
        tf2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf2.setCaretColor(Color.white);
        tf2.setBorder(null);
        tf2.setOpaque(false);

        email_label = new JLabel("Email");
        email_label.setBounds(534, 400, 300, 40);
        email_label.setForeground(Color.white);
        email_label.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(email_label);

        email_TextField = new JTextField();
        email_TextField.setBounds(534, 430, 380, 30);
        email_TextField.setForeground(Color.white);
        email_TextField.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        email_TextField.setCaretColor(Color.white);
        email_TextField.setBorder(null);
        email_TextField.setOpaque(false);
        l11 = new JLabel("____________________________________");
        l11.setBounds(534, 435, 400, 40);
        l11.setForeground(Color.white);
        con.add(email_TextField);
        con.add(l11);

        // Buttons

        back_Btn = new JButton("Back");
        back_Btn.setBounds(750, 30, 80, 35);
        back_Btn.setFocusPainted(false);
        back_Btn.setFont(new Font("Seigo UI", Font.BOLD, 14));
        back_Btn.setBackground(new Color(137, 22, 63));
        back_Btn.setForeground(Color.white);

        recover_Btn = new JButton("Recover");
        recover_Btn.setBounds(530, 500, 300, 40);
        recover_Btn.setFocusPainted(false);
        recover_Btn.setBackground(Color.white);
        recover_Btn.setFont(new Font("Seigo UI", Font.BOLD, 18));

        back_Btn.addActionListener(this);
        recover_Btn.addActionListener(this);

        recover_Btn.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent me) {
                recover_Btn.setBackground(new Color(137, 22, 63));
                recover_Btn.setForeground(Color.white);

            }

            public void mouseExited(MouseEvent me) {
                recover_Btn.setForeground(new Color(137, 22, 63));
                recover_Btn.setBackground(Color.white);

            }

            public void mouseClicked(MouseEvent me) {

            }

            public void mousePressed(MouseEvent me) {

            }

            public void mouseReleased(MouseEvent me) {

            }
        });

        con.add(l3);
        con.add(l4);
        con.add(l6);
        con.add(l7);
        con.add(l10);

        con.add(tf1);
        con.add(tf2);

        con.add(back_Btn);
        con.add(recover_Btn);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String uname = tf1.getText();
        String dateOfBirth = tf2.getText();
        String Email = email_TextField.getText();

        // user user = new user();
        if (e.getSource() == back_Btn) {
            // login l = new login("none");
            // dispose();

            login_type lp = new login_type();
            lp.setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == recover_Btn
                && ((tf1.getText().isEmpty() || tf2.getText().isEmpty() || email_TextField.getText().isEmpty()))) {
            JOptionPane.showMessageDialog(null, "Fill all info");
            // recover_password rp = new recover_password();
            // rp.setVisible(true);
            // this.setVisible(false);

        } else if ((e.getSource() == recover_Btn && (user.recoverUser(uname, "./data/user.txt", dateOfBirth, Email)))) {
            JOptionPane.showMessageDialog(null, "Users Information Recovered Successfully");
            user u = new user();
            String finalPass = u.getpassword(uname, "./data/user.txt", dateOfBirth, Email);

            recover_password rp = new recover_password(uname, finalPass);
            rp.setVisible(true);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "Doesnt match");
        }
    }

    public static void main(String[] args) {
        forgot_password fg = new forgot_password();
        fg.setVisible(true);
        fg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
