import java.util.Scanner;
public class MinMaxSum {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        long arr[] = new long[5];

        for(int i=0 ; i<5 ; arr[i] = s.nextInt(), i++);

        minMax(arr);
    }

    public static void minMax(long arr[]){
        int i;
        long min, max, sum;

        for(i=0, sum=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE ; i<5 ; i++){
            if(arr[i]>max)
                max = arr[i];
            else if(arr[i]<min)
                min = arr[i];

            sum += arr[i];
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
