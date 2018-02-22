import java.util.Scanner;

public class ConnectedCellsInAGrid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row, col, ans;

        System.out.print("Rows : ");
        row = s.nextInt();
        System.out.print("Columns : ");
        col = s.nextInt();

        int arr[][] = new int[row][col];
        int prev_index[][] = new int[row][col];
        initialize(prev_index);

        arr_input2D(arr);

        ans = Cell(arr, prev_index);
        System.out.println(ans);
    }

    public static void arr_input2D(int arr[][]){
        Scanner s = new Scanner(System.in);
        int i, j;

        for(i=0 ; i<arr.length ; i++){
            for(j=0 ; j<arr[i].length ; j++){
                arr[i][j]=s.nextInt();
            }
        }
    }

    public static void arr_display2D(int arr[][]){
        int i, j;

        for(i=0 ; i<arr.length ; System.out.println(""), i++){
            for(j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
        }
    }

    public static void initialize(int arr[][]){
        for (int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; arr[i][j]=0, j++);
        }
    }

    public static int region(int index1, int index2, int arr[][], int prev_arr[][]){
        int i, j, sum, a;
        boolean flag=true;

        for(i=index1-1, sum=0, a=1 ; i<=index1+1 ; i++){
            if((i<0) || (i>=arr.length))
                continue;

            for(j=index2-1 ; j<=index2+1 ; j++){
                if((j<0) || (j>=arr[0].length) || ((j==index2) && (i==index1))  || (prev_arr[i][j]==1))
                    continue;

                if(arr[i][j]==1){
                    //System.out.println(i+" "+j);
                    flag = false;
                    prev_arr[i][j]=1;
                    sum += a+region(i, j, arr, prev_arr);
                    a=0;
                    //System.out.println("sum = "+sum);
                }
            }
        }

        if(flag) {
            //System.out.println("Base Statement");
            sum = 1;
        }

        return sum;
    }

    public static int Cell(int arr[][], int prev_arr[][]){
        int i, j, k, max_value=Integer.MIN_VALUE;

        for(i=0 ; i<arr.length ; i++){
            for(j=0 ; j<arr[0].length ; j++){
                if((arr[i][j]==1) && (prev_arr[i][j]==0)){
                    prev_arr[i][j]=1;
                    k = region(i, j, arr, prev_arr);

                    if(k>max_value){
                        max_value=k;
                    }
                }
            }
        }

        return max_value;
    }
}
