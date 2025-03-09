package Main;

import javax.swing.*;

public class Game {
    private Player player;
    TTTBoard Board;
    private boolean playing = true;

    public Game() {
        Board = new TTTBoard();
        player = new Player();
    }

    public void startGame() {
        player.setPlayer("X");
        Board.createBoard();
    }

    public TTTBoard getBoard() {
        return Board;
    }

    public Player getPlayer() {
        return player;
    }

    public void handleMove(int row, int col) {
        if (Board.isEmpty(row, col)) {
            Board.setPlayer(row, col, player.getPlayer());

            if (isWin(player.getPlayer())) {
                JOptionPane.showMessageDialog(null, "Player " + player.getPlayer() + " wins!");
                playagain();
                return;
            } else if (isTie()) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                playagain();
                return;
            }

            player.setPlayer(player.getPlayer().equals("X") ? "O" : "X");
        } else {
            JOptionPane.showMessageDialog(null, "Tile is already taken!");
        }
    }


    public boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private boolean isRowWin(String player) {
        for (int row = 0; row < 3; row++) {
            if (Board.getPlayer(row, 0) == null ||
                    Board.getPlayer(row, 1) == null ||
                    Board.getPlayer(row, 2) == null) {
                continue;
            }

            if (Board.getPlayer(row, 0).equals(player) &&
                    Board.getPlayer(row, 1).equals(player) &&
                    Board.getPlayer(row, 2).equals(player)) {
                return true;
            }
        }
        return false;
    }


    private boolean isColWin(String player) {
        for (int col = 0; col < 3; col++) {
            if (Board.getPlayer(0, col).equals(player) &&
                    Board.getPlayer(1, col).equals(player) &&
                    Board.getPlayer(2, col).equals(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(String player) {
        return (Board.getPlayer(0, 0).equals(player) &&
                Board.getPlayer(1, 1).equals(player) &&
                Board.getPlayer(2, 2).equals(player)) ||
                (Board.getPlayer(0, 2).equals(player) &&
                        Board.getPlayer(1, 1).equals(player) &&
                        Board.getPlayer(2, 0).equals(player));
    }

    public boolean isTie() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (Board.isEmpty(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void playagain() {
        String[] options = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(null, "Would you like to play again?",
                "TicTacToe", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            Board.createBoard();
            player.setPlayer("X");
            playing = true;
        } else {
            System.exit(0);
        }
    }
}
