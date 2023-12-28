package classes;

import java.lang.*;
import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class user {
    private String username;
    private String pass;
    private String DOB;
    private String email;
    private File file;
    private FileWriter fwriter;
    private Scanner sc;

    public user() {
        // this.username = "";
    }

    public user(String username, String pass)// name,pass
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

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //
    public String getusername() {
        return username;
    }

    public String getpass() {
        return pass;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public static int checkUser(String uname, String upass, String fname, String DOB, String email) {
        // fname = new File("./data/user.txt");
        int status = 0;
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");
                if (row.length() >= 2) {
                    String name = cols[0];
                    String pass = cols[1];
                    // String dateOfBirth = cols[2];
                    // String E_mail = cols[3];

                    if (uname.equals(name) && upass.equals(pass)) {
                        status = 1;
                        JOptionPane.showMessageDialog(null, "User Already exists");
                        break;
                    } else if (uname.equals(name) && !upass.equals(pass)) {
                        status = 2;
                    }
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read From File");
        }
        return status;
    }

    public static boolean registerUser(String uname, String upass, String fname, String DOB, String email) {
        if (checkUser(uname, upass, fname, DOB, email) == 0) {
            writeInFile(uname + ";" + upass + ";" + DOB + ";" + email, fname, true);
            JOptionPane.showMessageDialog(null, "User added Successfully");
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

    // getting user info
    public boolean getUser(String username, String pass) {
        boolean flag = false;
        file = new File("./data/user.txt");

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

    /// recover
    public static boolean recoverUser(String uname, String fname, String DOB, String email) {
        // fname = new File("./data/user.txt");
        boolean status = false;
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");

                // String dateOfBirth = cols[2];
                // String E_mail = cols[3];

                if (cols.length >= 4) {
                    String name = cols[0].trim();
                    String dateOfBirth = cols[2].trim();
                    String Email = cols[3].trim();
                    if (uname.equals(name) && DOB.equals(dateOfBirth) && email.equals(Email)) {
                        status = true;
                        break;
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

    /// get password
    public String getpassword(String uname, String fname, String dateOfBirth, String email) {
        String password = "";
        try {
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String cols[] = row.split(";");

                // String dateOfBirth = cols[2];
                // String E_mail = cols[3];

                if (cols.length >= 4) {
                    String name = cols[0].trim();
                    String dateBirth = cols[2].trim();
                    String Email = cols[3].trim();

                    if (uname.equals(name) && dateOfBirth.equals(dateBirth) && email.equals(Email)) {
                        password = cols[1].trim();
                        break;
                    }
                } else {
                    // JOptionPane.showMessageDialog(null, "Not found");

                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            // System.out.println("Cannot Read From File");
        }
        return password;
    }

}
