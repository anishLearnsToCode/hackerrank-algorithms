import java.util.Scanner;

public class BreakingTheRecords {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int size, ans[];

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];

        arr_input(arr);

        ans = record(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void arr_input(int arr[]){
        Scanner  s= new Scanner(System.in);
        for(int i =0 ; i<arr.length ; arr[i]=s.nextInt() , i++);
    }

    public static int[] record(int arr[]){
        int low, high, i, high_count, low_count;

        for(low = arr[0], high = arr[0], i=1, low_count=0, high_count=0 ; i<arr.length ; i++){
            if(arr[i]>high){
                high = arr[i];
                high_count++;
            }

            else if(arr[i]<low){
                low = arr[i];
                low_count++;
            }
        }

        int ans[] = new int[2];
        ans[0]=high_count;
        ans[1]=low_count;

        return ans;
    }
}