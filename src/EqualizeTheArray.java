import java.util.Scanner;

public class EqualizeTheArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, ans;

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];

        arr_input(arr);

        ans = minDelete(arr);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static int minDelete(int arr[]){
        int count[] = new int[100];
        int i, k;

        for(i=0 ; i<100 ; count[i]=0, i++);
        for(i=0 ; i<arr.length ; count[arr[i]]++, i++);
        for(i=0, k=0 ; i<100 ; i++){
            if(count[i]>count[k])
                k=i;
        }

        return arr.length-count[k];
    }
}
