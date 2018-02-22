import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];

        input(arr);

        int variable = s.nextInt();
        int ans = binarySearch(arr, variable);
        System.out.println(ans);
    }

    private static int binarySearch(int arr[], int x) {
        int i, tail, head;
        for(i=0, tail=0, head=arr.length ; i<arr.length ; i++){

            if(arr[(tail + head)/2] == x)
                return (tail + head)/2;

            else if(arr[(tail + head)/2] > x)
                head = (tail + head)/2;

            else
                tail = (tail + head)/2;
        }
        return (tail + head)/2;
    }

    private static void input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();
        }
    }
}
