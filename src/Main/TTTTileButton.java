package Main;

public class TTTTileButton {

    private int row;
    private int col;
    private Game game;
    private TTTBoard board;
    private boolean buttonClicked;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;
    }



    public boolean playerClicked () {
        return !board.isEmpty(row, col);
    }



    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public TTTBoard getBoard() {
        return board;
    }

    public void setBoard(TTTBoard board) {
        this.board = board;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }



}
