package com.bridgelabz.tictactoe;

public class TicTacToe {
    static char[] board = new char[10];

    public static void main(String[] args) {
        createEmptyBoard();

    }

    /**
     * UC1
     * Method Name: createEmptyBoard
     * Static method to create empty board
     * It takes board array indexes from 1 to 9 using for loop
     */
    static void createEmptyBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }
}




