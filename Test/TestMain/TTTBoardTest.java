package TestMain;

import Main.TTTBoard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TTTBoardTest {

    @Test
    public void testCreateBoard() {
        TTTBoard board = new TTTBoard();
        board.createBoard();

        for (int row = 0; row < TTTBoard.ROW; row++) {
            for (int col = 0; col < TTTBoard.COL; col++) {
                assertNotNull(board.getBoard()[row][col], "Board tile should not be null");
                assertTrue(board.isEmpty(row, col), "Board tile should be empty initially");
            }
        }
    }

    @Test
    public void testSetAndGetPlayer() {
        TTTBoard board = new TTTBoard();
        board.createBoard();

        board.setPlayer(0, 0, "X");
        assertEquals("X", board.getPlayer(0, 0), "Tile (0, 0) should have player X");

        board.setPlayer(1, 1, "O");
        assertEquals("O", board.getPlayer(1, 1), "Tile (1, 1) should have player O");
    }

    @Test
    public void testIsEmpty() {
        TTTBoard board = new TTTBoard();
        board.createBoard();

        assertTrue(board.isEmpty(0, 0), "Tile (0, 0) should be empty initially");
        board.setPlayer(0, 0, "X");
        assertFalse(board.isEmpty(0, 0), "Tile (0, 0) should not be empty after setting player");
    }
}