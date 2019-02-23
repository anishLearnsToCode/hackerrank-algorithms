import java.util.Scanner;

public class FormingAMagicSquare {
    private static int[][][] allPossibilities = {
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
    };

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int arr[][] = new int[3][3];
//        int ans;

//        arr_input2D(arr);

//        ans = magicSquare(arr);
//        System.out.println(ans);

        int square[][] = {
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 5}
        };

        int square2[][] = {
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}
        };

        System.out.println(formingMagicSquare(square));
        System.out.println(formingMagicSquare(square2));
    }

    static int formingMagicSquare(int[][] square) {
        int difference = Integer.MAX_VALUE;
        for (int[][] possibility : allPossibilities) {
            difference = Math.min(difference, difference(square, possibility));
        }
        return difference;
    }

    private static int difference(int square[][], int otherSquare[][]) {
        int difference = 0;
        for (int row=0 ; row < square.length ; row++) {
            for (int column=0 ; column < square[row].length ; column++) {
                difference += Math.abs(otherSquare[row][column] - square[row][column]);
            }
        }
        return difference;
    }

    public static void arr_input2D(int arr[][]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; arr[i][j] = s.nextInt(), j++);
        }
    }

    public static int magicSquare(int arr[][]){
        int perfectSquare[][] = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        int i, j, k, sum, minValue;
        //arr_output2D(perfectSquare);

        for(i=0, sum=0, minValue = Integer.MAX_VALUE ; i<4 ; sum=0, i++){
            rotate(arr);

            for(j=0 ; j<3 ; j++){
                for(k=0 ; k<3 ; k++){
                    sum += Math.abs(arr[j][k]-perfectSquare[j][k]);
                }
            }

            if(sum < minValue)
                minValue = sum;
        }

        return minValue;
    }

    public static void arr_output2D(int arr[][]){
        for(int i=0 ; i<arr.length ; System.out.println(""), i++){
            for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void rotate(int arr[][]){
        int new_arr[][] = new int[3][3];
        int i, j;

        for(i=0 ; i<3 ; i++){
            new_arr[i][2] = arr[0][i];
            new_arr[2][2-i] = arr[i][2];
            new_arr[i][0] = arr[2][i];
            new_arr[0][i] = arr[2-i][0];
        }
        new_arr[1][1] = arr[1][1];

        arr = new_arr;
    }
}