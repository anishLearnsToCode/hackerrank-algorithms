import java.util.Scanner;

public class BonApetit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, k, bill;

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];
        arr_input(arr);

        System.out.print("k : ");
        k=s.nextInt();

        System.out.print("Bill : ");
        bill = s.nextInt();

        System.out.println(food(k, bill, arr));
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0  ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static String food(int k, int bill, int arr[]){
        int i, sum;
        String ans;

        for(i=0, sum=0 ; i<arr.length ; i++){
            if(i==k)
                continue;

            sum+=arr[i];
        }
        sum/=2;

        if(sum == bill)
            ans = "Bon Apetit";
        else
            ans = (bill - sum)+"";

        return ans;
    }
}
