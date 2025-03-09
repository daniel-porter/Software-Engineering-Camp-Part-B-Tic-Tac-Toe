package TestMain;

import Main.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testSetAndGetPlayer() {
        Player player = new Player();
        player.setPlayer("X");
        assertEquals("X", player.getPlayer(), "Player should be X");

        player.setPlayer("O");
        assertEquals("O", player.getPlayer(), "Player should be O");
    }
}