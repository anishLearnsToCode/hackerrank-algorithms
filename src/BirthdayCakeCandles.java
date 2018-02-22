import java.util.Scanner;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int size, ans, i;

        size = s.nextInt();

        int arr[] = new int[size];

        for(i=0 ; i<size ; i++){
            arr[i]=s.nextInt();
        }

        ans = result(size, arr);

        System.out.println(ans);
    }

    public static int result(int size, int arr[]){
        int i, k, c;

        for(i=0, k=0, c=0 ; i<arr.length ; i++){
            if(arr[i]>k) {
                c = 0;
                k=arr[i];
            }
            if(arr[i]==k){
                c++;
            }
        }

        return c;
    }
}
