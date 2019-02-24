import java.util.Scanner;

public class ThreeDSurfaceArea {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int height = scanner.nextInt();
        int width = scanner.nextInt();

        int[][] matrix = new int[height+2][width+2];
        input(matrix);

        System.out.println(surfaceArea(matrix, height, width));
    }

    private static int surfaceArea(int[][] matrix, int height, int width) {
        int surfaceArea = height * width ;

        for (int row=1 ; row < height+1 ; row++) {
            for (int column = 1; column < width+1 ; column++) {

                if (column == 1) {
                    surfaceArea += Math.abs(matrix[row][column] - matrix[row][column-1]);
                }

                surfaceArea += Math.abs(matrix[row][column] - matrix[row][column + 1])
                        + Math.abs(matrix[row][column] - matrix[row - 1][column])
                        + 1;
            }

            if (row == height) {
                for (int heights : matrix[row]) {
                    surfaceArea += heights;
                }
            }
        }

        return surfaceArea;
    }

    private static void input(int[][] matrix) {
        for (int row=1 ; row < matrix.length-1; row++) {
            for (int column=1 ; column < matrix[row].length-1 ; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
//        print(matrix);
    }

    private static void print(int[][] matrix) {
        for(int[] row : matrix) {
            System.out.print("{ ");
            for(int column: row) {
                System.out.print(column + " ");
            }
            System.out.println(" } ");
        }
    }
}
