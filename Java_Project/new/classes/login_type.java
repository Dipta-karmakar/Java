package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_type extends JFrame implements ActionListener {
    JPanel panel;
    JLabel label1, img_Label;
    JButton userBtn, adminBtn, backBtn;
    Container con;
    ImageIcon img, icon;

    public login_type() {

        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(117, 22, 63));

        // panel = new JPanel();
        // panel.setLayout(null);
        this.setTitle("Login Type");
        this.setBounds(320, 100, 850, 550);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        // panel.setBounds(0, 0, 850, 550);
        // panel.setBackground(new Color(117, 22, 63));

        label1 = new JLabel("Login As ");
        label1.setBounds(300, 150, 300, 50);
        // label1.setBackground(new Color(117, 22, 63));
        label1.setForeground(Color.white);

        label1.setFont(new Font("Seigo UI", Font.BOLD, 35));
        con.add(label1);
        // buttons

        userBtn = new JButton("USER");
        userBtn.setBounds(170, 310, 200, 50);
        userBtn.setFocusPainted(false);
        con.add(userBtn);
        userBtn.addActionListener(this);

        adminBtn = new JButton("ADMIN");
        adminBtn.setBounds(430, 310, 200, 50);
        con.add(adminBtn);
        adminBtn.addActionListener(this);

        backBtn = new JButton("BACK");
        backBtn.setBounds(80, 450, 70, 30);
        con.add(backBtn);
        backBtn.addActionListener(this);

        img = new ImageIcon(getClass().getResource("../images/admin.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(0, 0, 850, 550);
        con.add(img_Label);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            welcome w4 = new welcome();
            w4.setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == userBtn) {
            login lg = new login("user");
            this.setVisible(false);

        } else if (e.getSource() == adminBtn) {
            login lg = new login("admin");
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Default admin name and password is \"admin\" ");
        }

    }

    public static void main(String[] args) {
        login_type lg = new login_type();
        lg.setVisible(true);
    }

}
