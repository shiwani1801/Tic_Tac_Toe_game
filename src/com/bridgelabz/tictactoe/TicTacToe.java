package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    static char[] board = new char[10];
    static char userLetter;
    static char computerLetter;

    public static void main(String[] args) {
        createEmptyBoard();
        chooseLetter();
        while (true) {
            playerTurn();
            computerTurn();
            showBoard();
            checkFreeSpace();
            checkFirstPlayer();
            winner();

        }
    }
    /**
     * UC1
     * Method Name: createEmptyBoard
     * Static method to create empty board
     */
    static void createEmptyBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }

    /**
     * UC2
     * Method Name: chooseLetter
     * if user letter is 'X' then computer letter is become 'O' otherwise it becomes 'X'
     */
    static void chooseLetter() {
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
    static void showBoard() {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    /**
     * UC4
     * Method Name: playerTurn
     * method to make user to move to desired location
     */
    static void playerTurn() {
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
     * method to check if space is available in the board.
     */
    static void checkFreeSpace() {
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

    /**
     * UC6
     * Method Name: checkFirstPlayer
     * method to check who plays first computer or user
     */
    static void checkFirstPlayer() {
        int Head = 0;
        double toss = Math.floor(Math.random() * 10) % 2;
        if (toss == Head) {
            System.out.println("computer starts to play first");
        } else {
            System.out.println("User starts to play first");
        }
    }

    /**
     * UC7
     * MethodName: winner
     * method to check player possible winning positions
     */
    static void winner() {
        if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) ||
                (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter) ||
                (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter) ||
                (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter) ||
                (board[3] == userLetter && board[5] == userLetter && board[7] == userLetter)) {
            showBoard();
            System.out.println("Player win the game");
            System.exit(0);
        }
    }

    /**
     * UC8
     * Method Name: computerTurn
     * method to make computer move to random location in board
     */
    static void computerTurn() {
        int computerMove;
        while (true) {
            computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
            if (board[computerMove] == ' ') {
                break;
            }

        }
        System.out.println("Computer choose:: " + computerMove);
        board[computerMove] = computerLetter;
    }

}


