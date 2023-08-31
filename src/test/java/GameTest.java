import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {
    Game players = new Game();
    Player player1 = new Player(111, "Nikita", 70);
    Player player2 = new Player(222, "Maria", 25);
    Player player3 = new Player(333, "Victoria", 1);
    Player player4 = new Player(444, "Victoria", 70);

    @Test
    public void shouldRegisterPlayers() {
        players.register(player1);

        Assertions.assertEquals(true, players.containsName("Nikita"));
    }

    @Test
    public void ShouldRegisterPlayersWithTheDifferentSameNames() {
        players.register(player3);
        players.register(player4);

        Assertions.assertEquals(true, players.containsName("Victoria1"));
    }

    @Test
    public void shouldFindByPlayerName() {
        players.register(player1);
        players.register(player2);
        players.register(player3);

        Assertions.assertEquals(player2, players.findByPlayerName("Maria"));
    }

    @Test
    public void notShouldFindByPlayerName() {
        players.register(player1);
        players.register(player3);

        Assertions.assertEquals(null, players.findByPlayerName("Maria"));
    }

    @Test
    public void shouldGetPlayerStrength() {
        players.register(player3);

        Assertions.assertEquals(1, players.getPlayerStrength("Victoria"));
    }

    @Test
    public void notShouldGetPlayerStrength() {
        players.register(player1);

        Assertions.assertEquals(0, players.getPlayerStrength("Victoria"));
    }

    @Test
    public void shouldBeDraw() {
        players.register(player1);
        players.register(player4);

        Assertions.assertEquals(0, players.round("Nikita", "Victoria"));
    }

    @Test
    public void shouldWinFirstPlayer() {
        players.register(player1);
        players.register(player2);

        Assertions.assertEquals(1, players.round("Nikita", "Maria"));
    }

    @Test
    public void shouldWinSecondPlayer() {
        players.register(player3);
        players.register(player4);

        Assertions.assertEquals(2, players.round("Victoria", "Victoria1"));
    }

    @Test
    public void shouldErrorNotRegisteredPlayerName1() {
        players.register(player1);
        players.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Victoria", "Maria");
        });
    }

    @Test
    public void shouldErrorNotRegisteredPlayerName2() {
        players.register(player1);
        players.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Nikita", "Victoria");
        });
    }

    @Test
    public void shouldFindName() {
        players.register(player1);

        Assertions.assertEquals(true, players.containsName("Nikita"));
    }

    @Test
    public void notShouldFindName() {
        players.register(player1);

        Assertions.assertEquals(false, players.containsName("Olia"));
    }
}
