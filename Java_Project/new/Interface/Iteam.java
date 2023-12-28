package Interface;

import Entity.Person;
import Entity.Player;

public interface Iteam {
    boolean insertPlayer(Player p);

    Player getPlayerByName(String s);

    Person getPlayerById(int ii);

    Player getByName(String s);

    boolean searchByName(String s);

    boolean removeByName(String a);
}
