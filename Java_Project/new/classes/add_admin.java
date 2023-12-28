package classes;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;

public class add_admin extends JFrame {

    Container con;
    JPanel panel1, panel2;
    JButton Add, backBtn;
    ImageIcon img;
    JLabel img_label, l3, l4, l6, l7, l8, l9, l10;
    JTextField tf1;
    JPasswordField pf1;

    public add_admin() {
        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(117, 22, 63));

        this.setTitle("add_admin");
        this.setBounds(320, 150, 900, 650);

        img = new ImageIcon(getClass().getResource("../images/add_admin.jpg"));
        img_label = new JLabel(img);
        img_label.setBounds(-55, 0, img.getIconWidth(), 650);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 450, 650);
        panel1.setLayout(null);
        // panel1.setBackground(Color.MAGENTA);
        panel1.add(img_label);
        con.add(panel1);

        // labels
        l10 = new JLabel("Add Admin");
        l10.setBounds(590, 82, 300, 60);
        l10.setForeground(Color.white);
        l10.setFont(new Font("Segoe UI", Font.BOLD, 30));

        l3 = new JLabel("User Name");
        l3.setBounds(484 + 50, 212, 300, 40);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l4 = new JLabel("Password");
        l4.setBounds(484 + 50, 312, 150, 40);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        l6 = new JLabel("_________________________________________");
        l6.setBounds(484 + 50, 262, 400, 40);
        l6.setForeground(Color.white);
        l6.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l7 = new JLabel("__________________________________________");
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

        pf1 = new JPasswordField();
        pf1.setBounds(534, 352, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pf1.setForeground(Color.white);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.white);
        pf1.setBorder(null);
        pf1.setOpaque(false);

        Add = new JButton("Add");
        Add.setBounds(534, 460, 310, 40);
        Add.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Add.setForeground(new Color(117, 22, 63));
        Add.setBackground(new Color(255, 255, 255));
        Add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Add.setFocusPainted(false);

        backBtn = new JButton("BACK");
        backBtn.setBounds(760, 20, 100, 30);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(117, 22, 63));
        backBtn.setFocusPainted(false);

        // adding

        // panel e component add must container e add er por korte hobe

        con.add(l3);
        con.add(l4);
        con.add(l6);
        con.add(l7);
        con.add(l10);
        con.add(tf1);
        con.add(pf1);
        con.add(Add);
        con.add(backBtn);

        this.setVisible(true);

        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == backBtn) {
                    Admin_panel ap = new Admin_panel();
                    ap.setVisible(true);
                    dispose();
                    // this.setVisible(false);

                }

            }

        });

        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                admin_IO u = new admin_IO();
                if (ae.getSource() == Add) {
                    admin_IO.registerAdmin(tf1.getText(), pf1.getText(), "./data/admin.txt");

                }
            }

        });
        Add.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {

            }

            public void mouseEntered(MouseEvent me) {
                Add.setBackground(new Color(117, 22, 63));
                Add.setForeground(Color.WHITE);

            }

            public void mouseExited(MouseEvent me) {
                Add.setBackground(Color.white);
                Add.setForeground(new Color(117, 22, 63));

            }

            public void mousePressed(MouseEvent me) {

            }

            public void mouseReleased(MouseEvent me) {

            }
        });
    }

    public static void main(String[] args) {
        add_admin a = new add_admin();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
