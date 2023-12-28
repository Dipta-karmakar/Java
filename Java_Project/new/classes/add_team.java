package classes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entity.Team;
import EntityList.*;
import data.*;

public class add_team extends JFrame {

    Container con;
    JTextField team_Id, team_name;
    JLabel l1, l2;
    JButton add, cancel;
    DefaultTableModel d;
    manage_team a;

    public add_team(manage_team a, DefaultTableModel d) {
        this.a = a;
        this.d = d;
        con = this.getContentPane();
        con.setLayout(null);
        con.setBackground(Color.darkGray);

        this.setTitle("add team");
        this.setBounds(320, 150, 850, 550);

        l1 = new JLabel("ID");
        l1.setBounds(200, 100, 300, 40);
        l1.setForeground(Color.white);
        con.add(l1);

        team_Id = new JTextField();
        team_Id.setBounds(280, 100, 300, 40);
        con.add(team_Id);

        l2 = new JLabel("Team name");
        l2.setBounds(200, 200, 300, 40);
        l2.setForeground(Color.white);
        con.add(l2);

        team_name = new JTextField();
        team_name.setBounds(280, 200, 300, 40);
        con.add(team_name);

        add = new JButton("add");
        add.setBounds(150, 400, 250, 40);
        con.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (team_Id.getText().isEmpty() || team_name.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all fields");
                } else {

                    ArrayList<Team> allTeamss = TeamList.teams;

                    int flag = 0;
                    for (int i = 0; i < allTeamss.size(); i++) {
                        if (team_name.getText().equals(allTeamss.get(i).getTeamName())) {
                            System.out.println("team matched");
                            flag++;
                        } else {
                            System.out.println("team did not match");
                        }
                    }
                    if (flag == 0) {
                        addd();
                    } else {
                        JOptionPane.showMessageDialog(null, "Team already exists",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    dispose();

                }

            }
        });

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 400, 250, 40);
        con.add(cancel);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancel) {
                    a.setVisible(true);
                    dispose();
                }
            }
        });
        this.setVisible(true);

    }

    void addd() {
        TeamList.teams.add(new Team(Integer.parseInt(team_Id.getText()), team_name.getText()));
        d.addRow(new Object[] { team_Id.getText(), team_name.getText() });
        FileIO.writeInFile(team_Id.getText() + ";" + team_name.getText(), "./data/team.txt", true);
        this.dispose();
        a.setVisible(true);
    }

    public static void main(String[] args) {
        add_team a = new add_team(null, null);
        a.setVisible(true);
    }
}