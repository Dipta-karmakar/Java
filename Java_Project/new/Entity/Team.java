package Entity;

import java.util.ArrayList;

public class Team {

    ArrayList<Player> players = new ArrayList<Player>();

    private String teamName;
    private int teamId;

    // const
    public Team() {
    }

    public Team(int teamId, String teamName) {
        this.teamName = teamName;
        this.teamId = teamId;
        System.out.println("Team " + teamName + " Created");
    }

    // set method
    public boolean insertPlayer(Player p) {
        players.add(p);
        return true;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    // get method
    public String getTeamName() {
        return this.teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public Player getPlayerByName(String s) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(s)) {
                return (Player) players.get(i);
            }
        }
        return null;
    }

    public Person getPlayerById(int ii) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == ii) {
                return players.get(i);
            }
        }
        return null;
    }

    public Player getByName(String s) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName() == s) {
                return (Player) players.get(i);
            }
        }
        return null;
    }

    public boolean searchByName(String s) {
        if (getByName(s) != null) {
            return true;
        } else
            return false;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    // insert
    public void insert(Player p) {
        players.add(p);
    }

    public boolean removeByName(String a) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(a)) {
                players.remove(i);
                System.out.println("removed: " + a);
                return true;
            }
        }
        return false;
    }

    public boolean removeById(int a) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == a) {
                players.remove(i);
                return true;
            }
        }
        return false;
    }
}