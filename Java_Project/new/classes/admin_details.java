package classes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_details extends JFrame implements ActionListener {
    Container con;
    JTable table1;
    JScrollPane scrollPane;
    JLabel label1, img_Label;
    ImageIcon img;
    JButton backBtn;

    public admin_details() {

        this.setTitle("admin_details");
        this.setBounds(320, 150, 850, 550);

        con = this.getContentPane();
        con.setLayout(null);

        label1 = new JLabel("Admin Details");
        label1.setBounds(330, 30, 300, 40);
        label1.setFont(new Font("Seigo UI", Font.BOLD, 35));
        label1.setForeground(Color.BLACK);
        con.add(label1);

        String colums[] = { "Username", "Password", "Email" };
        String Rows[][] = {

                { "dipto", "night", "diptokarmakar13@gmail.com" },

        };

        table1 = new JTable(Rows, colums);
        table1.setFont(new Font("Seigo UI", Font.BOLD, 12));

        scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(100, 100, 650, 350);

        con.add(scrollPane);

        backBtn = new JButton("BACK");
        backBtn.setBounds(40, 470, 100, 30);
        backBtn.setBackground(Color.white);
        backBtn.setForeground(new Color(117, 22, 63));
        backBtn.setFocusPainted(false);
        con.add((backBtn));
        backBtn.addActionListener(this);

        img = new ImageIcon(getClass().getResource("../images/admin_details.jpg"));
        img_Label = new JLabel(img);
        img_Label.setBounds(0, 0, 850, 550);
        con.add(img_Label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            this.setVisible(false);
            Admin_panel ap = new Admin_panel();
            ap.setVisible(true);
        }
    }

    public static void main(String[] args) {
        admin_details ad = new admin_details();
        ad.setVisible(true);
        ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setVisible(false);
    }

}
