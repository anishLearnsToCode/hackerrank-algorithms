import java.util.Scanner;

public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int size, ans, i;
        int bird[] = new int[5];

        for(i=0 ; i<5 ; bird[i]=0, i++);

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];
        arr_input(arr, bird);

        ans = flock(bird);
        System.out.println(ans);
    }

    public static void arr_input(int arr[], int bird[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
            bird[arr[i]-1]++;
        }
    }

    public static int flock(int arr[]){
        int i, k;

        for(i=0, k=0 ; i<arr.length ; i++){
            if(arr[i]>arr[k])
                k=i;
        }

        return k+1;
    }
}
