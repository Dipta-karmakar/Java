package classes;

import java.awt.Container;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;

public class add_user extends JFrame implements ActionListener {
    Container con;
    ImageIcon img;
    JLabel img_Label, l1, l3, l4, l6, l7, lebel4, lebel7, lf3, lf4;
    JTextField tf1, field3, field4;
    JPasswordField pf1;
    JButton backBtn, AddBtn;
    File file;

    public add_user() {

        this.setTitle("add_user");
        this.setBounds(320, 150, 900, 600);

        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(137, 22, 63));

        // user labels

        l1 = new JLabel(" Add User");
        l1.setLayout(null);
        l1.setBounds(610, 52, 300, 60);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cascadia Code", Font.BOLD, 25));
        con.add(l1);

        l3 = new JLabel("User Name");
        l3.setBounds(484 + 50, 192, 300, 40);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        con.add(l3);

        l4 = new JLabel("Password");
        l4.setBounds(484 + 50, 282, 150, 40);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        con.add(l4);

        l6 = new JLabel("____________________________________________");
        l6.setBounds(484 + 50, 232, 400, 40);
        l6.setForeground(Color.white);
        l6.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        con.add(l6);

        l7 = new JLabel("_____________________________________________");
        l7.setBounds(484 + 50, 322, 400, 40);
        l7.setForeground(Color.white);
        l7.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        con.add(l7);

        // username
        tf1 = new JTextField();
        tf1.setBounds(534, 232, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tf1.setForeground(Color.white);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.white);
        tf1.setBorder(null);
        tf1.setOpaque(false);
        con.add(tf1);

        // password
        pf1 = new JPasswordField();
        pf1.setBounds(534, 322, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pf1.setForeground(Color.white);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.white);
        pf1.setBorder(null);
        pf1.setOpaque(false);
        con.add(pf1);

        // date of birth
        lebel4 = new JLabel("Date of Birth(dd/mm/yyyy)");
        lebel4.setBounds(534, 120, 300, 40);
        lebel4.setForeground(Color.white);
        lebel4.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel4);

        // date of birth
        field3 = new JTextField();
        field3.setBounds(540, 155, 230, 30);
        field3.setForeground(Color.white);
        field3.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        field3.setCaretColor(Color.white);
        field3.setBorder(null);
        field3.setOpaque(false);
        lf3 = new JLabel("______________________________");
        lf3.setBounds(534, 160, 250, 40);
        lf3.setForeground(Color.white);
        con.add(field3);
        con.add(lf3);

        // adding e-mail

        lebel7 = new JLabel("Email");
        lebel7.setBounds(530, 365, 300, 40);
        lebel7.setForeground(Color.white);
        lebel7.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        con.add(lebel7);

        // email
        field4 = new JTextField();
        field4.setBounds(535, 395, 380, 30);
        field4.setForeground(Color.white);
        field4.setFont(new Font("Cascadia Code", Font.PLAIN, 17));
        field4.setCaretColor(Color.white);
        field4.setBorder(null);
        field4.setOpaque(false);
        lf4 = new JLabel("________________________________________");
        lf4.setBounds(530, 400, 400, 40);
        lf4.setForeground(Color.white);
        con.add(field4);
        con.add(lf4);

        // Buttons
        backBtn = new JButton("BACK");
        backBtn.setBounds(750, 25, 100, 30);
        backBtn.setBackground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        con.add((backBtn));

        AddBtn = new JButton("Add");
        AddBtn.setBounds(520, 460, 320, 40);
        AddBtn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        AddBtn.setForeground(new Color(117, 22, 63));
        AddBtn.setBackground(new Color(255, 255, 255));
        AddBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AddBtn.setFocusPainted(false);
        AddBtn.addActionListener(this);
        con.add(AddBtn);

        img = new ImageIcon(getClass().getResource("../images/add_user.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(-30, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_Label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = tf1.getText();
        String password = pf1.getText();
        String DateOfBirth = field3.getText();
        String email = field4.getText();

        file = new File("./data/user.txt");
        if (e.getSource() == AddBtn) {
            user.registerUser(username, password, "./data/user.txt", DateOfBirth, email);
        } else if (e.getSource() == backBtn) {
            Admin_panel ap = new Admin_panel();
            ap.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        add_user ad = new add_user();
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
