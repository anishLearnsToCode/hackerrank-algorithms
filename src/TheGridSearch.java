import java.util.Scanner;
import java.util.SplittableRandom;

public class TheGridSearch {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int row, col, i, j;
        String ans;

        System.out.print("Enter no. of rows : ");
        row = s.nextInt();
        String grid[] = new String[row];
        arr_input(grid);

        System.out.print("Rows(P) : ");
        row = s.nextInt();
        String pattern[] = new String[row];
        arr_input(pattern);

        ans = patternSearch(grid, pattern);
        System.out.println(ans);
    }

    public static void arr_input(String str[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<str.length ; str[i] = s.next(), i++);
    }

    public static String patternSearch(String grid[], String pattern[]){
        String ans="";
        int i, j, k, grid_row = grid.length, grid_col = grid[0].length(), pattern_row = pattern.length, pattern_col = pattern[0].length();
        boolean flag;

        if((pattern.length <= grid.length) && (pattern[0].length() <= grid[0].length())){

            for(i=0, flag = false ; i<grid_row - pattern_row + 1 ; i++){
                for(j=0 ; j<grid_col - pattern_col + 1 ; j++){
                    if(grid[i].charAt(j) == pattern[0].charAt(0)){
                        if(check(i, j, grid, pattern)){
                            ans = "YES";
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if(!flag){
                ans = "NO";
            }
        }
        else
            ans = "NO";

        return ans;
    }

    public static boolean check(int rowIndex, int colIndex, String grid[], String pattern[]){
        boolean flag = true;
        int i, j, grid_row=grid.length, grid_col = grid[0].length(), pattern_row = pattern.length, pattern_col = pattern[0].length();

        for(i=rowIndex ; i<pattern_row + rowIndex ; i++){
            for(j=colIndex ; j<pattern_col + colIndex ; j++){
                if(grid[i].charAt(j) != pattern[i - rowIndex].charAt(j - colIndex)){
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
