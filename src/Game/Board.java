package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// In this class we are going to initalize the Chess Board
public class Board extends JPanel implements ActionListener {

    // Panel window size (in pixels)
    private static int BOARD_PIXEL_SIZE_W = 800;
    private static int BOARD_PIXEL_SIZE_H = 800;

    // Chess boards are 8 x 8 or A-H and 1-8
    // Spot A1 will be represented by [0][0], A2 by [0][1] etc.
    private static int COLUMNS = 8;
    private static int ROWS = 8;
    private static int TILE_SIZE = BOARD_PIXEL_SIZE_H/16; // a tile will be 1/16 of the board

    // set gameOver to false until game is over
    private static boolean GAME_OVER = false;

    // instance variable
    private int[][] myBoard;
    private static Timer timer; // the timer will be used for players' turns

    // Constructor that creates board
    public Board() {
        // set the size of the panel
        super.setPreferredSize(new Dimension(BOARD_PIXEL_SIZE_W, BOARD_PIXEL_SIZE_H));

        // First fill out the empty board
        myBoard = new int[COLUMNS][ROWS];

        // Populate the board with empty blocks
        for (int col = 0; col < COLUMNS; col = col + 2) {
            for (int row = 0; row < ROWS; row = row + 2) {
                myBoard[col][row] = 1; // 1 represent white tiles
            }
        }
        for (int col = 1; col < COLUMNS; col = col + 2) {
            for (int row = 1; row < ROWS; row = row + 2) {
                myBoard[col][row] = 1; // 0 represent white tiles
            }
        }

        // Initialize timer
        timer = new Timer(1000, this);
        timer.start();

        // TODO: 2) initialize state of game pieces
    }


    // Players will be given 20 minutes of time each to complete their game
    // If the timer ends on one players side the game is over and the other one wins
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void DrawBoard(Graphics page) {

        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS; row++) {
                int pixX = BOARD_PIXEL_SIZE_W/4 + col * TILE_SIZE;
                int pixY = BOARD_PIXEL_SIZE_H/4 + row * TILE_SIZE;

                if (myBoard[col][row] == 1){
                    page.drawRect(pixX, pixY, TILE_SIZE, TILE_SIZE);
                }else if (myBoard[col][row] == 0){
                    page.drawRect(pixX, pixY, TILE_SIZE, TILE_SIZE);
                    page.fillRect(pixX, pixY, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }


    // override the paintComponent method
    public void paintComponent(Graphics page) {
        // do what the parent does first
        super.paintComponent(page);

        DrawBoard(page);

        if (GAME_OVER) {
            Font f = page.getFont().deriveFont(Font.BOLD);
            page.setFont(f);
            page.drawString("GAME OVER", 100, 100);
        }
        super.repaint();
    }

}