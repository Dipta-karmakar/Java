package classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class add_player extends JFrame implements ActionListener {

    Container con;
    JTextField namTextField, catagoryTextField, countryTextField, matchPlayedTextField;
    JLabel nameLabel, catagoryLabel, countryLabel, matchPlayedLabel;
    JButton addBtn;

    public add_player() {
        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(137, 22, 63));

        this.setTitle("Add Player");
        this.setBounds(320, 150, 850, 550);

        nameLabel = new JLabel("Player Name");
        nameLabel.setBounds(50, 100, 150, 40);
        nameLabel.setForeground(Color.white);
        con.add(nameLabel);

        namTextField = new JTextField();
        namTextField.setBounds(200, 100, 300, 30);
        namTextField.setForeground(Color.black);
        con.add(namTextField);

        catagoryLabel = new JLabel("Catagory");
        catagoryLabel.setBounds(50, 150, 150, 40);
        catagoryLabel.setForeground(Color.white);
        con.add(catagoryLabel);

        catagoryTextField = new JTextField();
        catagoryTextField.setBounds(200, 150, 300, 30);
        catagoryTextField.setForeground(Color.black);
        con.add(catagoryTextField);

        countryLabel = new JLabel("Country");
        countryLabel.setBounds(50, 200, 150, 40);
        countryLabel.setForeground(Color.white);
        con.add(countryLabel);

        countryTextField = new JTextField();
        countryTextField.setBounds(200, 200, 300, 30);
        countryTextField.setForeground(Color.black);
        con.add(countryTextField);

        matchPlayedLabel = new JLabel("Match Played");
        matchPlayedLabel.setBounds(50, 250, 150, 40);
        matchPlayedLabel.setForeground(Color.white);
        con.add(matchPlayedLabel);

        matchPlayedTextField = new JTextField();
        matchPlayedTextField.setBounds(200, 250, 300, 30);
        matchPlayedTextField.setForeground(Color.black);
        con.add(matchPlayedTextField);

        // button
        addBtn = new JButton("Add");
        addBtn.setBounds(200, 450, 300, 30);
        addBtn.setBackground(Color.white);
        addBtn.addActionListener(this);
        con.add(addBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = namTextField.getText();
        String catagory = catagoryTextField.getText();
        String country = countryTextField.getText();
        String matchPlayed = matchPlayedTextField.getText();

        if (e.getSource() == addBtn) {
            // manage_team u = new manage_team();
            // u.setVisible(true);
            // this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        add_player a = new add_player();
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
