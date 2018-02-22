import java.util.Scanner;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, k;

        System.out.print("Size : ");
        n=s.nextInt();

        int arr[] = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i]=s.nextInt();
        }

        System.out.print("Element : ");
        k=s.nextInt();

        System.out.println();
    }
}
