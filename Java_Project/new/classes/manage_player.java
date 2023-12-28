package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import EntityList.TeamList;
import Entity.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import data.FileIO;

public class manage_player extends JFrame implements ActionListener {
    JPanel panel;
    JButton backBtn, addBtn, delete, transfer, updateBtn, loadBtn;

    ImageIcon image, icon;
    JLabel background, img_Label;

    Font font = new Font("Seigo UI", Font.PLAIN, 16);

    JTable table, table1;
    DefaultTableModel model, model1;

    TeamList l;

    public manage_player(user_Homepage_Updated h, TeamList l) {

        super("Player Management");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(125, 40, 1250, 670);
        this.l = l;

        icon = new ImageIcon(getClass().getResource("../images/icon.png"));
        this.setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);

        backBtn = new JButton(" Back");
        addBtn = new JButton("Add Player");
        delete = new JButton("Delete");
        updateBtn = new JButton("Update");
        loadBtn = new JButton("Load Players");

        backBtn.setBounds(1030, 550, 140, 40);
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.white);
        backBtn.setFont(font);
        backBtn.addActionListener(this);

        addBtn.setBounds(250, 330, 100, 30);
        addBtn.setBackground(Color.GREEN);
        addBtn.addActionListener(this);

        delete.setBounds(570, 330, 100, 30);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.white);
        delete.addActionListener(this);

        updateBtn.setBounds(400, 330, 130, 30);
        updateBtn.setBackground(Color.YELLOW);
        updateBtn.addActionListener(this);

        loadBtn.setBounds(750, 330, 140, 30);
        loadBtn.setBackground(Color.GREEN);
        loadBtn.addActionListener(this);

        panel.add(backBtn);
        panel.add(addBtn);
        panel.add(delete);
        panel.add(updateBtn);
        panel.add(loadBtn);

        // TeamList.teams.clear();
        loadTeams();
        LoadPlayers();
        this.add(panel);
        createTable();
        createteamTable();

        image = new ImageIcon(getClass().getResource("../images/manage_player.jpg"));
        img_Label = new JLabel(image);
        img_Label.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        panel.add(img_Label);
        this.add(img_Label);
        this.setVisible(true);
    }

    public void createTable() {

        // id;name;age;nation;salary;agreement;jersey no;position;hand;height;prev
        // team;Runs;current team
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("age");
        model.addColumn("Nationality");
        model.addColumn("Salary");
        model.addColumn("Agreement");
        model.addColumn("Jersey no");
        model.addColumn("Type");
        model.addColumn("Hand");
        model.addColumn("Height");
        model.addColumn("Prev Team");
        model.addColumn("Runs");
        model.addColumn("Team");

        table = new JTable(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        table.setBounds(0, 0, 400, 300);
        table.setRowHeight(30);
        table.setBackground(new Color(174, 247, 255));
        table.setSelectionBackground(Color.yellow);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(20, 20, 1200, 300);

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }

    public void updateFile() {
        int rows = model.getRowCount();
        String allLines = "";
        for (int i = 0; i < rows; i++) {
            System.out.println("update running");
            // id;name;age;nation;salary;agreement;jersey no;position;hand;height;prev
            // team;Runs;current team
            String id = table.getModel().getValueAt(i, 0).toString();
            String name = table.getModel().getValueAt(i, 1).toString();
            String age = table.getModel().getValueAt(i, 2).toString();
            String nation = table.getModel().getValueAt(i, 3).toString();
            String salary = table.getModel().getValueAt(i, 4).toString();
            String agreement = table.getModel().getValueAt(i, 5).toString();
            String jerseyNo = table.getModel().getValueAt(i, 6).toString();
            String position = table.getModel().getValueAt(i, 7).toString();
            String hand = table.getModel().getValueAt(i, 8).toString();
            String height = table.getModel().getValueAt(i, 9).toString();
            String prevClub = table.getModel().getValueAt(i, 10).toString();
            String runs = table.getModel().getValueAt(i, 11).toString();
            String currentTeam = table.getModel().getValueAt(i, 12).toString();
            String line;
            if (i < rows - 1) {
                line = id + ";" + name + ";" + age + ";" + nation + ";" + salary + ";" + agreement + ";" + jerseyNo
                        + ";" + position + ";" + hand + ";" + height + ";" + prevClub + ";" + runs + ";" + currentTeam
                        + "\n";
            } else {
                line = id + ";" + name + ";" + age + ";" + nation + ";" + salary + ";" + agreement + ";" + jerseyNo
                        + ";" + position + ";" + hand + ";" + height + ";" + prevClub + ";" + runs + ";" + currentTeam;
            }
            allLines += line;
        }
        FileIO.writeInFile(allLines, "./data/players.txt", false);
    }

    public void actionPerformed(ActionEvent e) {
        if (backBtn == e.getSource()) {
            this.dispose();
            user_Homepage_Updated h = new user_Homepage_Updated();
            h.setVisible(true);
        } else if (e.getSource() == addBtn) {
            // AddTeam m=new AddTeam(this,l,model);
            AddPlayer p = new AddPlayer(this, l, model);
            this.setVisible(false);
        } else if (e.getSource() == delete) {
            int rows[] = table.getSelectedRows();
            if (rows != null) {
                Arrays.sort(rows);
                for (int i = rows.length - 1; i >= 0; i--) {
                    String name = table.getModel().getValueAt(rows[i], 1).toString();
                    String team = table.getModel().getValueAt(rows[i], 12).toString();
                    TeamList.getTeam(team).removeByName(name);// l. chilo age
                    model.removeRow(rows[i]);
                    updateFile();
                }
            } else {
                JOptionPane.showMessageDialog(this, "select a team first",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == updateBtn) {
            updateFile();
            LoadPlayers();
        } else if (e.getSource() == loadBtn) {

            System.out.println("load wroked");

            // for (int i = 0; i < model.getRowCount(); i++) {
            // model.removeRow(i);
            // }

            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            int rows[] = table1.getSelectedRows();
            System.out.println("length: " + rows.length);

            if (rows != null) {
                Arrays.sort(rows);
                for (int i = rows.length - 1; i >= 0; i--) {

                    String teamName = table1.getModel().getValueAt(rows[i], 1).toString();

                    System.out.println(teamName);

                    // reading file
                    // ...

                    try {
                        Scanner sc = new Scanner(new File("./data/players.txt"));
                        while (sc.hasNextLine()) {
                            String line = sc.nextLine();
                            String cols[] = line.split(";");

                            // Check if the array has enough elements
                            if (cols.length >= 13) {
                                String playersTeam = cols[12];

                                if (playersTeam.equals(teamName)) {
                                    System.out.println("Player found: " + cols[12]);
                                    Player player = TeamList.getTeam(cols[12]).getPlayerByName(cols[1]);
                                    model.addRow(new Object[] { player.getId(), player.getName(), player.getAge(),
                                            player.getNation(), player.getSalary(), player.getAgreement(),
                                            player.getJerseyNo(), player.getPosition(), player.getHand(),
                                            player.getHeight(), player.getPreviousTeam(), player.getRuns(), cols[12] });
                                }
                            } else {
                                System.out.println("Invalid format in line: " + line);
                            }
                        }
                        sc.close();
                    } catch (FileNotFoundException e1) {
                        System.out.println("File not found: " + e1.getMessage());
                        System.out.println("file not found");
                    }

                    // ...

                }
            }

        }
    }

    public void LoadPlayers() {
        try {
            Scanner sc = new Scanner(new File("./data/players.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String cols[] = line.split(";");

                // Check if the array has enough elements
                if (cols.length >= 13) {
                    Player player;

                    System.out.println("Player found: " + cols[1]);

                    player = new Player(cols[1], Integer.parseInt(cols[2]), cols[3], Double.parseDouble(cols[4]),
                            new Date(1, 1, 2000), Double.parseDouble(cols[5]), Integer.parseInt(cols[6]), cols[7],
                            cols[8],
                            Double.parseDouble(cols[9]), cols[10], Integer.parseInt(cols[11]),
                            Integer.parseInt(cols[0]));

                    System.out.println(l.getTeam(cols[12]).getTeamName());
                    TeamList.getTeam(cols[12]).insert(player);

                    System.out.println(cols[1] + " Player Loaded");
                } else {
                    System.out.println("Invalid format in line: " + line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            System.out.println("file not found");
        }
    }

    public void createteamTable() {
        model1 = new DefaultTableModel();
        model1.addColumn("ID");
        model1.addColumn("Name");

        table1 = new JTable(model1);
        table1.setFont(font);
        table1.getTableHeader().setFont(font);

        table1.setRowHeight(30);
        table1.setBackground(new Color(174, 247, 255));
        table1.setSelectionBackground(Color.yellow);
        JScrollPane scrollpane = new JScrollPane(table1);
        scrollpane.setBounds(300, 370, 600, 250);

        ArrayList<Team> teams = l.getAll();
        for (int j = 0; j < teams.size(); j++) {

            System.out.println("adding row");
            System.out.println(teams.get(j).getTeamId() + "team id");
            model1.addRow(new Object[] { teams.get(j).getTeamId(), teams.get(j).getTeamName() });
        }

        panel.setLayout(null);
        panel.add(scrollpane);

        this.setContentPane(panel);
    }
    // loadinig teams

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