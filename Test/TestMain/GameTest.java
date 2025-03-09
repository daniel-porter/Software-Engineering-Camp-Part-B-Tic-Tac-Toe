package TestMain;

import Main.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testStartGame() {
        Game game = new Game();
        game.startGame();
        assertEquals("X", game.getPlayer().getPlayer());
        assertNotNull(game.getBoard());
    }

    @Test
    public void testHandleMove() {
        Game game = new Game();
        game.startGame();
        game.handleMove(0, 0);
        assertEquals("X", game.getBoard().getPlayer(0, 0));
        game.handleMove(0, 0);
        assertEquals("X", game.getBoard().getPlayer(0, 0));
        game.handleMove(1, 1);
        assertEquals("O", game.getBoard().getPlayer(1, 1));
    }

    @Test
    public void testIsWin() {
        Game game = new Game();
        game.startGame();
        game.handleMove(0, 0);
        game.handleMove(1, 0);
        game.handleMove(0, 1);
        game.handleMove(1, 1);
        game.handleMove(0, 2);
        assertTrue(game.isWin("X"));
        game = new Game();
        game.startGame();
        game.handleMove(0, 0);
        game.handleMove(0, 1);
        game.handleMove(1, 0);
        game.handleMove(1, 1);
        game.handleMove(2, 0);
        assertTrue(game.isWin("X"));
        game = new Game();
        game.startGame();
        game.handleMove(0, 0);
        game.handleMove(0, 1);
        game.handleMove(1, 1);
        game.handleMove(1, 0);
        game.handleMove(2, 2);
        assertTrue(game.isWin("X"));
    }

    @Test
    public void testIsTie() {
        Game game = new Game();
        game.startGame();
        game.handleMove(0, 0);
        game.handleMove(0, 1);
        game.handleMove(0, 2);
        game.handleMove(1, 0);
        game.handleMove(1, 1);
        game.handleMove(1, 2);
        game.handleMove(2, 0);
        game.handleMove(2, 1);
        game.handleMove(2, 2);
        assertFalse(game.isTie());
    }
}