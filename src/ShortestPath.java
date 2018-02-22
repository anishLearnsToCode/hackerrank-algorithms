import java.util.Scanner;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row, col, ans;

        System.out.print("Rows : ");
        row=s.nextInt();
        System.out.print("Columns : ");
        col=s.nextInt();

        int arr[][] = new int[row][col];
        int position_arr[][] = new int[row][col];
        initialize(position_arr);

        ans = path_len(0, 0, arr, position_arr);
        System.out.println(ans);
    }

    public static void initialize(int arr[][]){
        int i, j;
        for(i=0 ; i<arr.length ; i++){
            for(j=0 ; j<arr[0].length ; j++){
                arr[i][j]=0;
            }
        }
    }

    public static int path_len(int index1, int index2, int arr[][], int position_arr[][]){
        int i, j, k;

        for(i=index1-1 ; i<=index1+1 ; i++){
            if((i<0) || (i>=arr.length))
                continue;

            for(j=index2-1 ; j<=index2+1 ; j++){
                if((j<0) || (j>=arr[0].length) || (position_arr[i][j]==1) || ((i==index1) && (j==index2)))
                    continue;

                if(arr[i][j]==0){

                }
            }
        }

        return 1;
    }
}
