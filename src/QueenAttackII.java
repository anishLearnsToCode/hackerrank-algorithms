import javafx.util.Pair;

import java.util.HashSet;
import java.util.Scanner;


public class QueenAttackII {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ans, n, k, queen_row , queen_col, i;

        System.out.print("Rows : ");
        n=s.nextInt();
        System.out.print("Obstacles : ");
        k = s.nextInt();
        int obstacles[][] = new int[k][k];

        System.out.print("Enter position of queen : ");
        queen_row = s.nextInt();
        queen_col = s.nextInt();
        HashSet<String> obstaclePositions = new HashSet<>(k);

        System.out.println("Enter obstacles : ");
        for(int index=0 ; index<k ; index++){
            System.out.print("Row , Col : ");
//            obstacles[i][0] = s.nextInt();
//            obstacles[i][1] = s.nextInt();
            int obstacleRow = s.nextInt();
            int obstacleColumn = s.nextInt();
            obstaclePositions.add(obstacleRow + " " + obstacleColumn);
        }

//        ans = queensAttack(n, k, queen_row, queen_col, obstacles);
//        System.out.println(ans);

        ans = anotherWay(n, k, queen_row, queen_col, obstaclePositions);
        System.out.println(ans);
    }

    private static void print(int row, int col) {
        System.out.println("At + (" + row + "," + col + ")");
    }

    static int anotherWay(int n, int k, int queenRow, int queenColumn, HashSet<String> obstacles) {
        int answer=0;

        // horizontal
        for (int row = queenRow, column = queenColumn - 1 ; column > 0 ; column--, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        for (int row = queenRow, column = queenColumn+1; column <= n ; column++, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        // Vertical
        for (int column = queenColumn, row = queenRow - 1 ; row > 0 ; row--, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        for (int column = queenColumn, row = queenRow + 1 ; row <= n ; row++, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        // Diagonal top left -> bottom right
        for (int row = queenRow-1, column = queenColumn-1 ; row > 0 && column > 0 ; row--, column--, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        for (int row = queenRow + 1, column = queenColumn+1 ; row <= n && column <= n ; row++, column++, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        // Diagonal bottom left -> top right
        for (int row = queenRow-1, column = queenColumn + 1; row > 0 && column <= n ; row--, column++, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        for (int row = queenRow+1, column = queenColumn-1 ; row <= n && column > 0 ; row++, column--, answer++) {
            if (obstacles.contains(row + " " + column)) {
                break;
            }
        }

        return answer;
    }

    static int queensAttack(int n, int k, int queenRow, int queenColumn, int[][] obstacles) {
        char chessBoard[][] = createBoardWithObstacles(n, queenRow, queenColumn, obstacles), answer=0;

        // horizontal
        for (int row = queenRow-1, column = queenColumn - 2 ; column >= 0 ; column--, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        for (int row = queenRow - 1, column = queenColumn ; column < n ; column++, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        // Vertical
        for (int column = queenColumn - 1, row = queenRow - 2 ; row >= 0 ; row--, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        for (int column = queenColumn - 1, row = queenRow ; row < n ; row++, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        // Diagonal top left -> bottom right
        for (int row = queenRow-2, column = queenColumn-2 ; row >= 0 && column >= 0 ; row--, column--, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        for (int row = queenRow, column = queenColumn ; row < n && column < n ; row++, column++, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        // Diagonal bottom left -> top right
        for (int row = queenRow-2, column = queenColumn ; row >= 0 && column < n ; row--, column++, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        for (int row = queenRow, column = queenColumn-2 ; row < n && column >= 0 ; row++, column--, answer++) {
            if (chessBoard[row][column] == '2') {
                break;
            }
        }

        return answer;
    }

    private static char[][] createBoardWithObstacles(int rows, int queenRow, int queenColumn, int obstacles[][]) {
        char board[][] = new char[rows][rows];
        board[queenRow-1][queenColumn-1] = '1';

        for (int obstacle[] : obstacles) {
            board[obstacle[0]-1][obstacle[1]-1] = '2';
        }

        return board;
    }
}