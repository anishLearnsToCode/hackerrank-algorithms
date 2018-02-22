import java.util.Scanner;

public class MinimumDistances {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, ans, i;

        System.out.print("size : ");
        size = s.nextInt();

        int arr[] = new int[size];

        for(i=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();
        }

        ans = minIndex(arr);
        System.out.println(ans);
    }

    public static int[] mergeSort(int arr[]){
        int i;

        if(arr.length==1){
            return arr;
        }

        int tempArr1[] = new int[arr.length/2];
        int tempArr2[] = new int[arr.length - tempArr1.length];

        for(i=0 ; i<tempArr1.length ; tempArr1[i] = arr[i], i++);
        for( ; i<arr.length ; tempArr2[i-tempArr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(tempArr1);
        int smallAns2[] = mergeSort(tempArr2);

        return merge(smallAns1, smallAns2);
    }

    public static int[] merge(int arr1[], int arr2[]){
        int ans[] = new int[arr1.length+arr2.length];
        int i, j, t, k;

        for(i=0, j=0, k=0 ; (i<=arr1.length) && (j<=arr2.length) ; ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length-j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length-i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i]<=arr2[j]){
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

    public static int minIndex(int arr[]){
        int min, i, j;

        for(i=0, min = Integer.MAX_VALUE ; i<arr.length-1 ; i++){
            for(j=i+1 ; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    if(j - i < min)
                        min = j - i;
                    break;
                }
            }
        }

        return min;
    }
}
