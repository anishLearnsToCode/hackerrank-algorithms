import java.util.Scanner;

public class serviceLane {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, ans, i, index1, index2;

        System.out.print("Size : ");
        size = s.nextInt();

        int arr[] = new int[size];

        for(i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);

        System.out.print("Index 1 : ");
        index1 = s.nextInt();
        System.out.print("Index 2 : ");
        index2 = s.nextInt();

        ans = vehicle(index1, index2, arr);
        System.out.println(ans);
    }

    public static int vehicle(int index1, int index2, int arr[]){
        int new_arr[] = new int[1 + index2 - index1];
        int i;
        for(i=index1 ; i<=index2 ; new_arr[i - index1] = arr[i], i++);

        new_arr = mergeSort(new_arr);
        return new_arr[0];
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }

        int i;
        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length - smallArr1.length];

        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(smallArr1);
        int smallAns2[] = mergeSort(smallArr2);

        return merge(smallAns1, smallAns2);
    }

    public static int[] merge(int arr1[], int arr2[]){
        int i, j, k, t;
        int ans[] = new int[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; (i<=arr1.length) && (j<=arr2.length) ; ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length-j ; ans[k++] = arr2[j+t], t++);
                break;
            }else if(j==arr2.length){
                for(t=0 ; t<arr1.length-i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i];
                i++;
            }
            else{
                ans[k++] = arr2[j];
                j++;
            }
        }

        return ans;
    }
}
