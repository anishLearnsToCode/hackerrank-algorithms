import java.util.Scanner;
public class PlusMinus {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n;

        System.out.print("Size : ");
        n = s.nextInt();

        int arr[] = new int[n];
        for(int i=0 ; i<n ; arr[i] = s.nextInt(), i++);

        result(arr, n);
    }

    public static void result(int arr[], int n){
        int i, positive, negative, zero;
        double p, neg, z;

        for(i=0, positive=0, negative=0, zero=0 ; i<n ; i++){
            if(arr[i]>0)
                positive++;
            else if(arr[i]<0)
                negative++;
            else
                zero++;
        }

        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zero);

        p = (double)(positive)/(double)n;
        neg = (double)(negative)/(double)n;
        z = (double)(zero)/(double)n;

        System.out.println(p);
        System.out.println(neg);
        System.out.println(z);
    }
}
