import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public Player findByPlayerName(String playerName) {

        for (Player player : playersList) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {

        if (findByPlayerName(player.getName()) != null) {
            String newNamePlayer = player.getName() + "1";
            player.setName(newNamePlayer);
        }
         playersList.add(player);
    }


    public int getPlayerStrength(String playerName) {

        for (Player player : playersList)
            if (player.getName() == playerName) {
                return player.getStrength();
            }
        return 0;
    }


    public int round(String playerName1, String playerName2) {

        if (findByPlayerName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (findByPlayerName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }


        if (getPlayerStrength(playerName1) < getPlayerStrength(playerName2)) {
            return 2;
        }
        if (getPlayerStrength(playerName1) > getPlayerStrength(playerName2)) {
            return 1;

        } else return 0;
    }
}
