import java.util.ArrayList;
import java.util.Scanner;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int arr[] = new int[size];

        for(int i=0 ; i<size ; i++){
            arr[i] = in.nextInt();
        }

        arr = mergeSort(arr);
        print(arr);

        int difference = Integer.MAX_VALUE;
        ArrayList<Integer> ansList = new ArrayList<>();

        for(int i=0 ; i<size-1 ; i++){
            if(arr[i+1] - arr[i] < difference){
                ansList = new ArrayList<>();
                ansList.add(arr[i]);
                ansList.add(arr[i+1]);
                difference = arr[i+1] - arr[i];
            }
            else if(arr[i+1] - arr[i] == difference){
                ansList.add(arr[i]);
                ansList.add(arr[i+1]);
            }
        }

        print(ansList);
    }

    private static int[] mergeSort(int arr[]) {
        if(arr.length == 1 || arr.length == 0){
            return arr;
        }

        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length - smallArr1.length];
        int i;

        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        int ans1[] = mergeSort(smallArr1);
        int ans2[] = mergeSort(smallArr2);

        return merge(ans1, ans2);
    }

    private static int[] merge(int arr1[], int arr2[]) {
        int i, j, k, t;
        int ans[] = new int[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; i<=arr1.length && j<=arr2.length ; ) {
            if(i == arr1.length) {
                for(t=0 ; t<arr2.length -j ; ans[k++] = arr2[j+t], t++);
                break;
            } else if(j == arr2.length) {
                for(t=0 ; t<arr1.length -i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i];
                i++;
            } else {
                ans[k++] = arr2[j];
                j++;
            }
        }

        return ans;
    }

    private static void print(int arr[]) {
        for(int i=0 ; i<arr.length ; System.out.print(arr[i] + " "), i++);
    }

    private static void print(ArrayList<Integer> list) {
        System.out.println("");
        for(int i=0 ; i<list.size() ; System.out.print(list.get(i) + " "), i++);
    }
}
