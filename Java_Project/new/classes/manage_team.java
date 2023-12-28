package classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entity.Team;
import EntityList.TeamList;
import data.FileIO;

public class manage_team extends JFrame implements ActionListener {
    // Container con;
    JLabel heading, img_label, addPlayerLabel, deletePlayerLabel, UpdatePlayerLabel, refreshLabel;
    DefaultTableModel model;

    JButton backBtn, addBtn, updateBtn, deleteBtn, refreshBtn;
    JTable table;
    JScrollPane scroll;
    JPanel con;
    ImageIcon img, addBtn_img, deleteBtn_img, updateBtn_img, refreshBtn_img, icon;

    // for add,delete,update
    JTextField namTextField, catagoryTextField, countryTextField, matchPlayedTextField;
    // JLabel nameLabel, catagoryLabel, countryLabel, matchPlayedLabel;

    public manage_team() {

        // con = this.getContentPane();
        con = new JPanel();
        con.setLayout(null);
        // con.setBackground(new Color(137, 22, 63));

        this.setTitle("Manage Team");
        this.setBounds(320, 150, 850, 550);

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        heading = new JLabel("Manage Your Team");
        heading.setBounds(220, 20, 300, 30);
        heading.setFont(new Font("Fira Code", Font.BOLD, 27));
        heading.setForeground(Color.black);
        con.add(heading);

        // Table

        // Buttons
        backBtn = new JButton("BACK");
        backBtn.setBounds(700, 25, 100, 30);
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.white);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        con.add((backBtn));

        // add button all
        addBtn = new JButton("Add");
        addBtn.setBounds(50, 80, 120, 40);
        addBtn.setBackground(Color.green);
        addBtn.setFocusPainted(false);
        con.add(addBtn);
        addBtn.addActionListener(this);

        // delete Player
        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(390, 80, 120, 40);
        deleteBtn.setBackground(Color.red);
        deleteBtn.setForeground(Color.white);
        deleteBtn.setFocusPainted(false);
        deleteBtn.addActionListener(this);
        con.add(deleteBtn);

        // update
        updateBtn = new JButton("Update");
        updateBtn.setBounds(220, 80, 120, 40);
        updateBtn.setBackground(Color.yellow);
        updateBtn.setFocusPainted(false);
        updateBtn.setFocusPainted(false);
        updateBtn.addActionListener(this);
        con.add(updateBtn);

        loadTeams();
        this.add(con);
        createTable();

        // background image

        img = new ImageIcon(getClass().getResource("../images/admin_details.jpg"));
        img_label = new JLabel(img);
        img_label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        con.add(img_label);

        this.setVisible(true);
    }

    int playerNO = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            add_team a = new add_team(this, model);
            a.setVisible(true);
            this.setVisible(false);

        }

        else if (e.getSource() == deleteBtn) {
            int rows[] = table.getSelectedRows();
            if (rows != null) {
                Arrays.sort(rows);
                for (int i = rows.length - 1; i >= 0; i--) {
                    TeamList.removeTeamByName(table.getModel().getValueAt(rows[i], 1).toString());
                    System.out.println("object deleted");

                    String teamName = table.getModel().getValueAt(rows[i], 1).toString();
                    System.out.println(teamName + " deleted");
                    // have to delete players also
                    deleteOthers(teamName);

                    model.removeRow(rows[i]);
                }
            }
            updateFile();
        } else if (e.getSource() == backBtn) {
            user_Homepage_Updated lp = new user_Homepage_Updated();
            lp.setVisible(true);
            this.dispose();
            TeamList.teams.clear();
        } else if (e.getSource() == updateBtn) {
            updateFile();
            TeamList.teams.clear();
            this.dispose();
            manage_team m = new manage_team();
            m.setVisible(true);
        }
    }

    public void createTable() {
        model = new DefaultTableModel();
        model.addColumn("Team Id");
        model.addColumn(" Team Name");
        System.out.println("collum added");

        table = new JTable(model);
        table.setBounds(0, 0, 600, 300);
        table.setRowHeight(30);

        table.setBackground(new Color(174, 247, 255));
        table.setSelectionBackground(Color.yellow);
        table.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(50, 130, 600, 300);

        ArrayList<Team> allTeam = TeamList.teams;

        for (int i = 0; i < allTeam.size(); i++) {
            model.addRow(new Object[] { allTeam.get(i).getTeamId(), allTeam.get(i).getTeamName() });
        }

        con.setLayout(null);
        con.add(scrollpane);
    }

    void deleteOthers(String teamName) {
        // delete players
        try {
            Scanner sc = new Scanner(new File("./data/players.txt"));
            String allLines = "";
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String cols[] = line.split(";");

                // throws exception //handeled
                if (cols.length >= 13 && !cols[12].equals(teamName)) {
                    allLines += line + "\n";
                }
            }
            if (allLines.length() > 1) {
                String filteredLines = allLines.substring(0, allLines.length() - 1);
                sc.close();
                FileIO.writeInFile(filteredLines, "./data/players.txt", false);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            System.out.println("file not found");
        }

    }

    public void updateFile() {
        int rows = model.getRowCount();
        String allLines = "";
        for (int i = 0; i < rows; i++) {
            String name = table.getModel().getValueAt(i, 1).toString();
            int id = Integer.parseInt(table.getModel().getValueAt(i, 0).toString());
            String line;
            if (i < rows - 1) {
                line = id + ";" + name + "\n";
            } else {
                line = id + ";" + name;
            }
            allLines += line;
        }
        System.out.println(allLines);
        FileIO.writeInFile(allLines, "./data/team.txt", false);
    }

    void loadTeams() {
        try {
            Scanner sc = new Scanner(new File("./data/team.txt"));
            TeamList.teams.clear();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String cols[] = line.split(";");
                Team team;

                System.out.println("Team found: " + cols[1]);

                team = new Team(Integer.parseInt(cols[0]), cols[1]);

                TeamList.teams.add(team);
                System.out.println(cols[1] + " team Loaded");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            System.out.println("file not found");
        }
    }
}
