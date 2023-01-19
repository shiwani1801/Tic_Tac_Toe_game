package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    //create a board of char array of size 10
    static char[] board = new char[10];
    static char userLetter;
    static char computerLetter;

    public static void main(String[] args) {
        createEmptyBoard();
        chooseLetter();
        while (true) {
            playerTurn();
            showBoard();
            checkFreeSpace();

        }
    }

    /**
     * UC1
     * Method Name: createEmptyBoard
     * Static method to create empty board
     * It takes board array indexes from 1 to 9 using for loop
     */
    private static void createEmptyBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }

    /**
     * UC2
     * Method Name: chooseLetter
     *  if user letter is 'X' then computer letter is become 'O' otherwise it becomes 'X'
     */
    private static void chooseLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a letter :: X or O : ");
        userLetter = scanner.next().toUpperCase().charAt(0);
        computerLetter = (userLetter == 'X') ? 'O' : 'X';
    }

    /**
     * UC3
     * Method Name: showBoard
     * method to display current board
     */
    private static void showBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }
    /**
     * UC4
     * Method Name: playerTurn
     *  method to make user to move to desired location
     */
    private static void playerTurn() {
        int playerMove;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose your location(1-9): ");
            playerMove = scanner.nextInt();
            if (board[playerMove] == ' ') {
                break;
            }
        }
        System.out.println("Player choose:: " + playerMove);
        board[playerMove] = userLetter;
    }
    /**
     * UC5
     * Method Name: checkFreeSpace
     * Description: method to check if space is available in the board.
     */
    private static void checkFreeSpace() {
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces = 0;
        for (int index = 1; index < board.length; index++) {
            if ((board[index] == ' ')) {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if (isSpaceAvailable == false) {
            System.err.println("Board is full! You can't make another move");
            System.exit(0);
        } else {
            System.out.println("Free space is available! you have " + numOfFreeSpaces + " moves left");
        }
    }


}
