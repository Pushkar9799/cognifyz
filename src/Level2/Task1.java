package Level2;

import java.util.Scanner;

public class Task1 {



        private static char[][] board = new char[3][3];
        private static final char PLAYER_X = 'X';
        private static final char PLAYER_O = 'O';

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean playAgain = true;

            while (playAgain) {
                initializeBoard();
                char currentPlayer = PLAYER_X;
                boolean gameWon = false;
                boolean boardFull = false;

                System.out.println("Welcome to Tic-Tac-Toe!");

                while (!gameWon && !boardFull) {
                    printBoard();
                    playerMove(currentPlayer, scanner);
                    gameWon = checkWin(currentPlayer);
                    boardFull = isBoardFull();

                    if (!gameWon) {
                        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                    }
                }

                printBoard();

                if (gameWon) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("It's a draw!");
                }

                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            }


        }

        private static void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        private static void printBoard() {
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("  -----");
                }
            }
        }

        private static void playerMove(char player, Scanner scanner) {
            int row, col;
            while (true) {
                System.out.print("Player " + player + ", enter your move (row and column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = player;
                    break;
                } else {
                    System.out.println("This move is not valid.");
                }
            }
        }

        private static boolean checkWin(char player) {
            // Check rows, columns, and diagonals
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    return true;
                }
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                    return true;
                }
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                return true;
            }
            return false;
        }

        private static boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    

