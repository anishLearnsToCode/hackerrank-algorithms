import java.util.Scanner;

public class FindTheMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int arr[] = new int[size];
        for(int i=0 ; i<size ; arr[i] = in.nextInt(), i++);

        arr = mergeSort(arr);
        print(arr);
        System.out.println(arr[size/2]);
    }

    private static int[] mergeSort(int arr[]){
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
        int ans[] = new int[arr1.length + arr2.length];
        int i, j, k, t;

        for(i=0, k=0, j=0 ; i<=arr1.length && j<=arr2.length ; ){
            if(i == arr1.length){
                for(t=0 ; t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            } else if(j == arr2.length){
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], t++);
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
}
