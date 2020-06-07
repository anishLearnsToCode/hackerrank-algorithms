package implimentation;

import java.util.Scanner;

public class TheBomberManGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int time = scanner.nextInt();
        String[] str = getGrid(rows);
        printBomberManGrid(str, rows, time);
    }

    private static void printBomberManGrid(String[] grid, int row, int time){
        String[] full = getFullGrid(grid, row);
        String[] explosion1 = invert(grid);
        String[] explosion2 = invert(explosion1);

        if(time == 1) {
            print(grid);
        } else if(time % 2 == 0) {
            print(full);
        } else if( (time/2) % 2 == 1){
            print(explosion1);
        } else {
            print(explosion2);
        }
    }

    private static boolean isBomb(String[] grid, int row, int column) {
        return grid[row].charAt(column) == 'O';
    }

    public static boolean isInVicinityOfBomb(String[] grid, int row, int column){
        return (row > 0 && grid[row-1].charAt(column) == 'O')
                || (column<grid[0].length()-1 && grid[row].charAt(column+1)=='O')
                || (row < grid.length - 1 && grid[row+1].charAt(column) == 'O')
                || (column > 0 && grid[row].charAt(column - 1) == 'O');
    }

    public static String[] invert(String[] grid){
        String[] result = new String[grid.length];
        for(int row = 0 ; row < grid.length ; row++){
            result[row] = "";
            for(int column = 0 ; column < grid[0].length() ; column++){
                result[row] += isBomb(grid, row, column) || isInVicinityOfBomb(grid, row, column) ? "." : "O";
            }
        }

        return result;
    }

    private static String[] getFullGrid(String[] grid, int rows) {
        String[] full = new String[grid.length];
        for(int row = 0 ; row < rows ; row++){
            full[row] = "";
            for(int column = 0 ; column < grid[0].length() ; column++){
                full[row] += 'O';
            }
        }
        return full;
    }

    private static String[] getGrid(int length){
        String[] array = new String[length];
        for(int i = 0 ; i < length ; i++){
            array[i] = scanner.next();
        }
        return array;
    }

    private static void print(String[] array){
        for (String string : array) {
            System.out.println(string);
        }
    }
}
