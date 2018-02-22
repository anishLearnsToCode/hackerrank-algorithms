import java.util.Scanner;

public class FormingAMagicSquare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[][] = new int[3][3];
        int ans;

        arr_input2D(arr);

        ans = magicSquare(arr);
        System.out.println(ans);
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
