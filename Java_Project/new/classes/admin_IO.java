package classes;

import java.lang.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class admin_IO {
    private String username;
    private String pass;
    private File file;
    private FileWriter fwriter;
    private Scanner sc;

    public admin_IO() {
        // this.username = "";
    }

    public admin_IO(String username, String pass)// name,pass
    {
        this.username = username;
        this.pass = pass;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpass(String pass) {
        this.pass = pass;
    }

    public String getusername() {
        return username;
    }

    public String getpass() {
        return pass;
    }

    public static int checkAdmin(String uname, String upass, String fname) {
        int status = 0;
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");

                if (cols.length >= 2) {
                    String name = cols[0];
                    String pass = cols[1];

                    if (uname.equals(name) && upass.equals(pass)) {
                        status = 1;
                        JOptionPane.showMessageDialog(null, "Admin Already exists");
                        break;
                    } else if (uname.equals(name) && !upass.equals(pass)) {
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

    public static boolean registerAdmin(String uname, String upass, String fname) {
        if (checkAdmin(uname, upass, fname) == 0) {
            writeInFile(uname + ";" + upass, fname, true);
            JOptionPane.showMessageDialog(null, " Admin Successfully added");
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
    public boolean getAdmin(String username, String pass) {
        boolean flag = false;
        file = new File("./data/admin.txt");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split(";");
                if (value[0].equals(username) && value[1].equals(pass)) {
                    flag = true;
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return flag;

    }

}
