import java.util.Scanner;

public class Polynomial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;
        double ans, x;

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];

        arr_input(arr);

        System.out.print("Eter x : ");
        x=s.nextDouble();

        ans = result(arr, x);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=arr.length-1 ; i>=0 ; i--){
            System.out.print("Coefficient "+(i+1)+" : ");
            arr[arr.length-1-i]= s.nextInt();
        }
    }

    public static double result(int arr[], double x){
        double ans, x_new;
        int i;

        for(i=arr.length-1, ans=0, x_new=1 ; i>=0 ; i--){
            ans += arr[i]*x;
            x_new *= x;
        }

        return ans;
    }
}
