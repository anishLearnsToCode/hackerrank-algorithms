import java.util.Scanner;

public class HurdleRace {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, k, ans;

        System.out.print("Size : ");
        size=s.nextInt();
        System.out.print("Max hieht (k) : ");
        k=s.nextInt();

        int arr[] = new int[size];
        arr_input(arr);

        ans = result(k, arr);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);

        for(int i =0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }
    }

    public static int result(int k, int arr[]){
        int i, max;

        for(i=0, max=0 ; i<arr.length ; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        return parse(max-k);
    }

    public static int parse(int num){
        int ans;

        if(num>=0){
            ans = num;
        }
        else{
            ans = 0;
        }

        return ans;
    }
}
