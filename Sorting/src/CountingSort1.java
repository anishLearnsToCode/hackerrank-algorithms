import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];

        for(int i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);   //Array Input

        int indexArr[] = indexing(arr);
        print(indexArr);
    }

    private static int[] indexing(int arr[]){
        int indexArr[] = new int[100];
        for(int i=0 ; i<indexArr.length ; indexArr[i]=0, i++);
        for(int i=0 ; i<arr.length ; indexArr[arr[i]]++, i++);
        return indexArr;
    }

    private static void print(int arr[]) {
        for(int i=0 ; i<arr.length ; System.out.print(arr[i] + " "), i++);
    }
}
