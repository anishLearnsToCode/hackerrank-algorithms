import java.util.Scanner;

public class CircularArrayRotation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, k, element, ans;

        System.out.print("Size : ");
        size = s.nextInt();

        int arr[] = new int[size];

        arr_input(arr);

        System.out.print("Element : ");
        element = s.nextInt();
        System.out.print("Cycle : ");
        k = s.nextInt();

        ans = cycle(arr, k, element);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();
        }
    }

    public static int cycle(int arr[], int cycle, int element){
        int ans;
        ans  = element - cycle;

        if((Math.abs(ans)+arr.length)%arr.length==0){
            ans = 0;
        }

        if(ans<0){
            ans = ans + arr.length*((Math.abs(ans)+arr.length)/arr.length);
        }

        return arr[ans];
    }
}
