import java.util.*;
public class Ttt {
        public static void main(String[] args) {
            char[][] board = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            char currentPlayer = 'X';
            boolean gameWon = false;

            while (!gameWon) {
                printBoard(board);
                int[] move = getMove();
                int row = move[0];
                int col = move[1];

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayer;
                    gameWon = checkWin(board, currentPlayer);
                    if (!gameWon) {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            printBoard(board);
            System.out.println("Player " + currentPlayer + " wins!");
        }

        private static void printBoard(char[][] board) {
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

        private static int[] getMove() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            return new int[]{row, col};
        }

        private static boolean isValidMove(char[][] board, int row, int col) {
            return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
        }

        private static boolean checkWin(char[][] board, char player) {
            // Check rows, columns, and diagonals for a win
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                        (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                    return true;
                }
            }
            return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player);
        }
}

