package TestMain;

import Main.TTTBoard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TTTTileButtonTest {

    @Test
    public void testTicTacToeButton() {
        TTTBoard.TicTacToeButton button = new TTTBoard.TicTacToeButton(0, 0);

        assertTrue(button.isEmpty(), "Button should be empty initially");
        button.setPlayer("X");
        assertEquals("X", button.getPlayer(), "Button should have player X");
        assertFalse(button.isEmpty(), "Button should not be empty after setting player");
    }

}
