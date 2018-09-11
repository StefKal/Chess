package Tests;

import Game.Board;

import javax.swing.*;

public class BoardTest {


    public static void main(String[] args){
        // create JFrame object
        JFrame myFrame = new JFrame("Tetris Animation");

        // set the frame to quit when closed

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a block panel object
        Board board = new Board();

        // add the block panel to the frame
        myFrame.getContentPane().add(board);

        // pack the frame
        myFrame.pack();

        // make the frame visible
        myFrame.setVisible(true);
    }
}
