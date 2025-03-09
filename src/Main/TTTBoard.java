package Main;

import javax.swing.*;

public class TTTBoard {
    public static final int ROW = 3;
    public static final int COL = 3;
    private final TicTacToeButton[][] Board = new TicTacToeButton[ROW][COL];

    public void createBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                Board[r][c] = new TicTacToeButton(r, c);
            }
        }
    }

    public String getPlayer(int r, int c) {
        return Board[r][c].getPlayer();
    }

    public void setPlayer(int r, int c, String player) {
        Board[r][c].setPlayer(player);
    }

    public boolean isEmpty(int r, int c) {
        return Board[r][c].isEmpty();
    }

    public TicTacToeButton[][] getBoard() {
        return Board;
    }

    public static class TicTacToeButton extends JButton {
        private String player = "";

        public TicTacToeButton(int row, int col) {
            setText("");
        }

        public String getPlayer() {
            return player;
        }

        public void setPlayer(String player) {
            this.player = player;
            setText(player);
        }

        public boolean isEmpty() {
            return player.isEmpty();
        }
    }
}