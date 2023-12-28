package data;

import java.util.Scanner;
import java.io.*;

public class FileIO {

	public static int checkUser(String uname, String upass, String fname) {
		int status = 0;
		try {
			Scanner sc = new Scanner(new File(fname));
			while (sc.hasNextLine()) {
				String row = sc.nextLine();
				String cols[] = row.split(";");
				String name = cols[0];
				String pass = cols[1];

				if (uname.equals(name) && upass.equals(pass)) {
					status = 1;
					break;
				} else if (uname.equals(name) && !upass.equals(pass)) {
					status = 2;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Read From File");
		}
		return status;
	}

	public static boolean registerUser(String uname, String upass, String fname) {
		if (checkUser(uname, upass, fname) == 0) {
			writeInFile(uname + ";" + upass, fname, true);
			return true;
		}
		return false;
	}

	public static void readFromFile(String fname) {
		try {
			Scanner sc = new Scanner(new File(fname));
			while (sc.hasNextLine()) {
				String row = sc.nextLine();
				String cols[] = row.split(";");
				String name = cols[0];
				String pass = cols[1];

				System.out.println("-------------");
				System.out.println("User Name : " + name);
				System.out.println("User Pass : " + pass);

			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Read From File");
		}
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

}