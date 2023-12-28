package Entity;

import Interface.*;

public class Player extends Person implements Iplayer {
    private int jerseyNo;
    private String position;
    private String hand;
    private double height;
    private String prevTeam;
    private int runs;

    // extends Person
    // constructor
    // hand,prevTeam,runs
    //
    public Player(String name, int age, String nation, double salary, Date joiningdate, double agreement, int jerseyNo,
            String position, String hand, double height, String prevTeam, int runs, int id) {
        super(name, age, nation, salary, "player", joiningdate, agreement, id);
        this.jerseyNo = jerseyNo;
        this.position = position;
        this.hand = hand;
        this.height = height;
        this.prevTeam = prevTeam;
        this.runs = runs;
        super.setType("player");
    }

    public Player() {
        super("N/A", 0, "N/A", 0.00, "Player", new Date(0, 0, 0), 0, 0);
        this.jerseyNo = jerseyNo;
        this.position = position;
        this.hand = hand;
        this.height = height;
        this.prevTeam = prevTeam;
        this.runs = runs;
        super.setType("Player");
    }

    // setter methods
    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPreviousClub(String prevTeam) {
        this.prevTeam = prevTeam;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    // getter methods
    public int getJerseyNo() {
        return this.jerseyNo;
    }

    public String getPosition() {
        return this.position;
    }

    public String getHand() {
        return this.hand;
    }

    public double getHeight() {
        return this.height;
    }

    public String getPreviousTeam() {
        return this.prevTeam;
    }

    public int getRuns() {
        return this.runs;
    }

    public void showInfo() {
        System.out.println("Id" + super.getId());
        System.out.println("Person Details");
        System.out.println("Name: " + super.getName());
        System.out.println("Age: " + super.getAge());
        System.out.println("Nation: " + super.getNation());
        System.out.println("Salary: " + super.getSalary());
        System.out.println("Type: " + super.getType());
        System.out.println("Joining Date: " + super.getJoiningDate());
        System.out.println("Agreement" + super.getAgreement());
        System.out.println("Player's Jersy Number : " + this.jerseyNo);
        System.out.println("Players's playing position : " + this.position);
        System.out.println("Player's playing hand : " + this.hand);
        System.out.println("player's height : " + this.height);
        System.out.println("Previous team of  player : " + this.prevTeam);
        System.out.println("Number of runs of player : " + this.runs);
    }
}
