// https://www.hackerrank.com/challenges/queens-attack-2/problem

package implimentation;

import java.util.Scanner;

public class QueensAttackII {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int obstacles = scanner.nextInt();
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        ChessBoard chessBoard = new ChessBoard.Builder()
                .withChessBoardSize(length)
                .withQueenPosition(row, column)
                .withObstacles(obstacles)
                .build();
        System.out.println(chessBoard.allowedMovement);
    }

    private static class ChessBoard {
        private final int row;
        private final int column;
        private final int length;
        private final int obstacles;
        private final int allowedMovement;

        private ChessBoard(int length, int row, int column, int obstacles) {
            this.length = length;
            this.row = row;
            this.column = column;
            this.obstacles = obstacles;
            allowedMovement = takeObstaclesInput();
        }

        public static class Builder {
            private int length;
            private int row;
            private int column;
            private int obstacles;

            public Builder withChessBoardSize(int length) {
                this.length = length;
                return this;
            }

            public Builder withQueenPosition(int row, int column) {
                this.row = row;
                this.column = column;
                return this;
            }

            public Builder withObstacles(int obstacles) {
                this.obstacles = obstacles;
                return this;
            }

            public ChessBoard build() {
                return new ChessBoard(length, row, column, obstacles);
            }
        }

        private int takeObstaclesInput() {
            int upperObstacleLength = this.row - 1;
            int rightObstacleLength = this.length - this.column;
            int leftObstacleLength = this.column - 1;
            int lowerObstacleLength = this.length - this.row;
            int leftUpperDiagonal = Math.min(upperObstacleLength, leftObstacleLength);
            int leftLowerDiagonalLength = Math.min(lowerObstacleLength, leftObstacleLength);
            int rightUpperDiagonal = Math.min(upperObstacleLength, rightObstacleLength);
            int rightLowerDiagonal = Math.min(lowerObstacleLength, rightObstacleLength);

            for (int i = 0 ; i < obstacles ; i++) {
                int row = scanner.nextInt();
                int column = scanner.nextInt();
                if (isUpperObstacle(row, column)) {
                    upperObstacleLength = Math.min(upperObstacleLength, this.row - row - 1);
                } else if (isRightObstacle(row, column)) {
                    rightObstacleLength = Math.min(rightObstacleLength, column - this.column - 1);
                } else if (isLowerObstacle(row, column)) {
                    lowerObstacleLength = Math.min(lowerObstacleLength, row - this.row - 1);
                } else if (isLeftObstacle(row, column)) {
                    leftObstacleLength = Math.min(leftObstacleLength, this.column - column - 1);
                } else if (isLeftUpperDiagonal(row, column)) {
                    leftUpperDiagonal = Math.min(leftUpperDiagonal, this.row - row - 1);
                } else if (isRightUpperDiagonal(row, column)) {
                    rightUpperDiagonal = Math.min(rightUpperDiagonal, this.row - row - 1);
                } else if (isRightLowerDiagonal(row, column)) {
                    rightLowerDiagonal = Math.min(rightLowerDiagonal, row - this.row - 1);
                } else if (isLeftLowerDiagonal(row, column)) {
                    leftLowerDiagonalLength = Math.min(leftLowerDiagonalLength, row - this.row - 1);
                }
            }

            return upperObstacleLength + lowerObstacleLength
            + leftObstacleLength + rightObstacleLength
            + leftUpperDiagonal + rightLowerDiagonal
            + rightUpperDiagonal + leftLowerDiagonalLength;
        }

        private boolean isUpperObstacle(int row, int column) {
            return this.column == column && row < this.row;
        }

        private boolean isRightObstacle(int row, int column) {
            return this.row == row && column > this.column;
        }

        private boolean isLowerObstacle(int row, int column) {
            return this.column == column && row > this.row;
        }

        private boolean isLeftObstacle(int row, int column) {
            return this.row == row && column < this.column;
        }

        private boolean isLeftUpperDiagonal(int row, int column) {
            return Math.abs(this.row - row) == Math.abs(this.column - column)
                    && row < this.row && column < this.column;
        }

        private boolean isRightUpperDiagonal(int row, int column) {
            return Math.abs(this.row - row) == Math.abs(this.column - column)
                    && row < this.row && column > this.column;
        }

        private boolean isRightLowerDiagonal(int row, int column) {
            return Math.abs(this.row - row) == Math.abs(this.column - column)
                    && row > this.row && column > this.column;
        }

        private boolean isLeftLowerDiagonal(int row, int column) {
            return Math.abs(this.row - row) == Math.abs(this.column - column)
                    && row > this.row && column < this.column;
        }
    }
}
