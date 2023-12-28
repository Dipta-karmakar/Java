package classes;

import Entity.*;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {

    JButton exitButton, contributionButton, startButton;

    JLabel imageLabel, headingLabel, titlelabel;
    ImageIcon img, icon;
    Font font;

    public welcome() {
        // this.setUndecorated(true);
        Container con = this.getContentPane();
        con.setLayout(null);

        setTitle("Wellcome_page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(330, 80, 850, 550);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        headingLabel = new JLabel("Cricket Team Management System");
        headingLabel.setBounds(65, 80, 800, 50);
        headingLabel.setForeground(Color.black);
        headingLabel.setFont(new Font("Fira Code", Font.BOLD, 40));
        con.add(headingLabel);

        // Buttons
        font = new Font("Fira Code", Font.BOLD, 15);
        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 400, 200, 40);
        exitButton.addActionListener(this);
        exitButton.setFocusPainted(false);
        con.add(exitButton);

        startButton = new JButton("Let's Start");
        startButton.setBounds(540, 400, 200, 40);
        startButton.addActionListener(this);
        startButton.setFocusPainted(false);
        con.add(startButton);

        contributionButton = new JButton("Contribution");
        contributionButton.setBounds(320, 400, 200, 40);
        contributionButton.addActionListener(this);
        contributionButton.setFocusPainted(false);
        con.add(contributionButton);

        img = new ImageIcon(getClass().getResource("../images/stadium2.jpg"));
        imageLabel = new JLabel(img);
        imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        con.add(imageLabel);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        {
            if (ae.getSource() == exitButton) {
                dispose();
            } else if (ae.getSource() == contributionButton) {
                contribution c1 = new contribution();
                c1.setVisible(true);
                this.setVisible(false);
            } else if (ae.getSource() == startButton) {

                login_type lg = new login_type();
                lg.setVisible(true);
                this.setVisible(false);

            }
        }
    }

    public static void main(String[] args) {
        welcome wc = new welcome();
        wc.setVisible(true);

    }
}