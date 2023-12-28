package classes;

import java.lang.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class manage_team_IO {
    private int username;
    private String pass;
    private File file;
    private FileWriter fwriter;
    private Scanner sc;

    public manage_team_IO() {
        // this.username = "";
    }

    public manage_team_IO(int username, String pass)// name,pass
    {
        this.username = username;
        this.pass = pass;
    }

    public void setusername(int username) {
        this.username = username;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public int getusername() {
        return username;
    }

    public String getpass() {
        return pass;
    }

    public static int checkTeam(int uname, String upass, String fname) {
        int status = 0;
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");

                if (cols.length >= 2) {
                    String name = cols[0];
                    String pass = cols[1];

                    int id = Integer.parseInt(name);

                    if ((uname == id) && upass.equals(pass)) {
                        status = 1;
                        JOptionPane.showMessageDialog(null, "Team Already exists");
                        break;
                    } else if ((uname == id) && !upass.equals(pass)) {
                        status = 2;
                    }
                } else {
                    System.out.println("Invalid data format in file: " + fname);
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        }
        return status;
    }

    public static boolean registerTeam(int uname, String upass, String fname) {
        if (checkTeam(uname, upass, fname) == 0) {
            writeInFile(uname + ";" + upass, fname, true);
            JOptionPane.showMessageDialog(null, " Team Successfully added");
            return true;
        }
        return false;
    }

    public static void writeInFile(String line, String fname, boolean append) {
        try {
            FileWriter fw = new FileWriter(new File(fname), append);
            fw.write(line + "\n");
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        } catch (Exception e) {
            System.out.println("Cannot Read From File");
        }
    }

    // getting admin info
    public boolean getTeam(int id, String name) {
        boolean flag = false;
        file = new File("./data/team.txt");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split(";");
                if (value.length >= 2) {

                    int Id = Integer.parseInt(value[0]);
                    if (Id == id && value[1].equals(name)) {
                        flag = true;
                    } else {
                        System.out.println("invalid data format");
                    }
                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return flag;
    }

    // delete
    public static boolean deleteTeam(String rows, String fname) {
        // fname = new File("./data/user.txt");
        boolean status = false;
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");

                String arr[] = rows.split(";");
                // String dateOfBirth = cols[2];
                // String E_mail = cols[3];

                if (cols.length >= 2) {
                    String id = cols[0];
                    String name = cols[1];

                    if (id.equals(arr[0]) && name.equals(arr[1])) {
                        cols[0] = "";
                        cols[1] = "";
                        status = true;
                        break;
                        // JOptionPane.showMessageDialog(null, "removed");
                    }
                } else {
                    // JOptionPane.showMessageDialog(null, "Not found");

                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            // System.out.println("Cannot Read From File");
        }
        return status;
    }

}
