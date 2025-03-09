package Main;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel DisplayBoard;
    private JPanel TicTacToePanel;
    private JPanel ControlMovePanel;
    private final JPanel mainPnl;

    private final Game game = new Game();
    private TTTBoard Board;

    public GUI() {
        setTitle("TicTacToe");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) screenSize.getWidth() / 2;
        int height = (int) screenSize.getHeight() / 2;
        setSize(width, height);
        setLocationRelativeTo(null);
        game.startGame();

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createDisplayBoard();
        mainPnl.add(DisplayBoard, BorderLayout.CENTER);

        createControlMovePanel();
        mainPnl.add(ControlMovePanel, BorderLayout.SOUTH);

        createTicTacToeTile();

        add(mainPnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createDisplayBoard() {
        DisplayBoard = new JPanel(new BorderLayout());
        JPanel displayTA = new JPanel(new BorderLayout());


        if (TicTacToePanel == null) {
            TicTacToePanel = new JPanel();
        }

        displayTA.add(TicTacToePanel, BorderLayout.SOUTH);
        DisplayBoard.add(displayTA, BorderLayout.CENTER);
    }

    private void createControlMovePanel() {
        ControlMovePanel = new JPanel();
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Courier", Font.BOLD, 20));
        quitButton.addActionListener(e -> System.exit(0));
        ControlMovePanel.add(quitButton);
    }

    private void createTicTacToeTile() {
        TicTacToePanel.removeAll();
        TicTacToePanel.setLayout(new GridLayout(TTTBoard.ROW, TTTBoard.COL));
        TicTacToePanel.setPreferredSize(new Dimension(100, 600));

        for (int row = 0; row < TTTBoard.ROW; row++) {
            for (int col = 0; col < TTTBoard.COL; col++) {
                TTTBoard.TicTacToeButton button = game.Board.getBoard()[row][col];
                TicTacToePanel.add(button);
                int finalRow = row;
                int finalCol = col;
                button.addActionListener(e -> game.handleMove(finalRow, finalCol));
            }
        }
        TicTacToePanel.revalidate();
        TicTacToePanel.repaint();
    }
}
