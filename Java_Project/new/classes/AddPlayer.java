package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import EntityList.*;
import data.*;

public class AddPlayer extends JFrame implements ActionListener {
    JPanel panel;
    JTable table;
    FileIO fIo = new FileIO();
    Font font = new Font("Seigo UI", Font.BOLD, 18);

    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11,
            jLabel12, jLabel13;

    JTextField id, name, age, nation, salary, agreement, jerseyNo, type, hand, height, prevTeam, Runs, CurrentTeam;

    JButton addBtn, cancelBtn;

    ImageIcon image, icon;
    JLabel background;

    DefaultTableModel model;
    TeamList l;
    manage_player mp;

    public AddPlayer(manage_player mp, TeamList l, DefaultTableModel model) {
        super("Player Management");
        // this.l = l;
        this.mp = mp;
        this.model = model;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(320, 150, 800, 500);
        this.setLayout(null);

        this.setIconImage(new ImageIcon("../images/icon.png").getImage());

        // Label

        jLabel12 = new JLabel("ID");
        jLabel12.setBounds(290, 180, 70, 40);
        jLabel12.setFont(font);
        jLabel12.setForeground(Color.WHITE);
        this.add(jLabel12);

        jLabel1 = new JLabel("Name");
        jLabel1.setBounds(20, 20, 60, 40);
        jLabel1.setFont(font);
        jLabel1.setForeground(Color.WHITE);
        this.add(jLabel1);

        jLabel2 = new JLabel("Age");
        jLabel2.setBounds(20, 60, 40, 40);
        jLabel2.setFont(font);
        jLabel2.setForeground(Color.WHITE);
        this.add(jLabel2);

        jLabel3 = new JLabel("Nation");
        jLabel3.setBounds(20, 110, 60, 25);
        jLabel3.setFont(font);
        jLabel3.setForeground(Color.WHITE);
        this.add(jLabel3);

        jLabel4 = new JLabel("Salary");
        jLabel4.setBounds(20, 150, 70, 25);
        jLabel4.setFont(font);
        jLabel4.setForeground(Color.WHITE);
        this.add(jLabel4);

        jLabel5 = new JLabel("Agreement");
        jLabel5.setBounds(20, 190, 100, 25);
        jLabel5.setFont(font);
        jLabel5.setForeground(Color.WHITE);
        this.add(jLabel5);

        jLabel6 = new JLabel("Jersy No");
        jLabel6.setBounds(20, 230, 90, 25);
        jLabel6.setFont(font);
        jLabel6.setForeground(Color.WHITE);
        this.add(jLabel6);

        jLabel7 = new JLabel("Type");
        jLabel7.setBounds(20, 270, 80, 30);
        jLabel7.setFont(font);
        jLabel7.setForeground(Color.WHITE);
        this.add(jLabel7);

        jLabel8 = new JLabel("Hand");
        jLabel8.setBounds(290, 30, 50, 30);
        jLabel8.setFont(font);
        jLabel8.setForeground(Color.WHITE);
        this.add(jLabel8);

        jLabel9 = new JLabel("Height");
        jLabel9.setBounds(290, 60, 80, 50);
        jLabel9.setFont(font);
        jLabel9.setForeground(Color.WHITE);
        this.add(jLabel9);

        jLabel10 = new JLabel("Prev Team");
        jLabel10.setBounds(290, 110, 110, 30);
        jLabel10.setFont(font);
        jLabel10.setForeground(Color.WHITE);
        this.add(jLabel10);

        jLabel11 = new JLabel("Runs");
        jLabel11.setBounds(290, 140, 60, 50);
        jLabel11.setFont(font);
        jLabel11.setForeground(Color.WHITE);
        this.add(jLabel11);

        jLabel13 = new JLabel("Team");
        jLabel13.setBounds(290, 230, 110, 25);
        jLabel13.setFont(font);
        jLabel13.setForeground(Color.WHITE);
        this.add(jLabel13);

        // TextField
        id = new JTextField();
        id.setBounds(400, 190, 110, 30);
        this.add(id);

        name = new JTextField();
        name.setBounds(110, 20, 130, 30);
        this.add(name);

        age = new JTextField();
        age.setBounds(110, 70, 130, 30);
        this.add(age);

        nation = new JTextField();
        nation.setBounds(110, 110, 130, 30);
        this.add(nation);

        salary = new JTextField();
        salary.setBounds(110, 150, 130, 30);
        this.add(salary);

        agreement = new JTextField();
        agreement.setBounds(130, 190, 110, 30);
        this.add(agreement);

        jerseyNo = new JTextField();
        jerseyNo.setBounds(130, 230, 110, 30);
        this.add(jerseyNo);

        type = new JTextField();
        type.setBounds(130, 270, 110, 30);
        this.add(type);

        hand = new JTextField();
        hand.setBounds(401, 30, 110, 30);
        this.add(hand);

        height = new JTextField();
        height.setBounds(400, 70, 110, 30);
        this.add(height);

        prevTeam = new JTextField();
        prevTeam.setBounds(400, 110, 110, 30);
        this.add(prevTeam);

        Runs = new JTextField();
        Runs.setBounds(400, 150, 110, 30);
        this.add(Runs);

        CurrentTeam = new JTextField();
        CurrentTeam.setBounds(400, 230, 110, 30);
        this.add(CurrentTeam);

        // Btn
        addBtn = new JButton("Add");
        addBtn.setBounds(130, 380, 130, 40);
        addBtn.setFont(font);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);
        this.add(addBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(400, 380, 130, 40);
        cancelBtn.setFont(font);
        cancelBtn.setBackground(Color.red);
        cancelBtn.addActionListener(this);
        this.add(cancelBtn);

        panel = new JPanel();

        image = new ImageIcon(getClass().getResource("../images/admin_panel.jpg"));
        background = new JLabel(image);
        background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        panel.add(background);

        this.add(panel);

        this.add(background);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            ArrayList<Team> allTeamss = TeamList.teams;
            Player p = new Player(name.getText(), Integer.parseInt(age.getText()), nation.getText(),
                    Double.parseDouble(salary.getText()), new Date(1, 1, 2000), Double.parseDouble(agreement.getText()),
                    Integer.parseInt(jerseyNo.getText()), type.getText(), hand.getText(),
                    Double.parseDouble(height.getText()), prevTeam.getText(), Integer.parseInt(Runs.getText()),
                    Integer.parseInt(id.getText()));

            TeamList.getTeam(CurrentTeam.getText()).insert(p);
            add();
        } else if (e.getSource() == cancelBtn) {
            this.setVisible(false);
            mp.setVisible(true);
        }
    }

    void add() {
        String string = "";
        string += id.getText() + ";" + name.getText() + ";" + age.getText() + ";" + nation.getText() + ";"
                + salary.getText() + ";" + agreement.getText() + ";" + jerseyNo.getText() + ";" + type.getText()
                + ";" + hand.getText() + ";" + height.getText() + ";" + prevTeam.getText() + ";" + Runs.getText() + ";"
                + CurrentTeam.getText();

        FileIO.writeInFile(string, "./data/players.txt", true);

        this.setVisible(false);
        mp.setVisible(true);
    }

}
