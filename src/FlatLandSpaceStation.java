import java.util.Scanner;

public class FlatLandSpaceStation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, ans;

        System.out.print("Cities : ");
        n = s.nextInt();
        System.out.print("Space stations : ");
        m = s.nextInt();

        int arr[] = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n-1;
        arr_input(arr);

        arr = mergeSort(arr);
        arr_display(arr);

        ans = spaceStation(arr);
        System.out.println(ans);
        if((arr[1] - arr[0] + 1 > (ans + 1)/2 ) &&  (arr[1] - arr[0] >= arr[m+1] - arr[m] )){
            ans = arr[1] - arr[0];
        }
        else if(arr[m+1] - arr[m]  > (ans + 1)/2){
            ans = arr[m+1] - arr[m] ;
        }
        else{
            ans = (ans + 1) / 2 ;
        }

        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=1 ; i<arr.length-1 ; arr[i] = s.nextInt(), i++);
    }

    public static void arr_display(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+ " "), i++);
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length<=1){
            return arr;
        }

        int i;
        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length-smallArr1.length];

        for(i=0 ; i<smallArr1.length ; smallArr1[i]=arr[i], i++);
        for( ; i<arr.length ; smallArr2[i-smallArr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(smallArr1);
        int smallAns2[] = mergeSort(smallArr2);

        return merge(smallAns1, smallAns2);
    }

    public static int[] merge(int arr1[], int arr2[]){
        int ans[] = new int[arr1.length + arr2.length];
        int i, j, k, t;

        for(i=0, j=0, k=0 ; (i<=arr1.length) && (j<=arr2.length); ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], t++);
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

    public static int spaceStation(int arr[]){
        int i, k;

        for(i=0, k=0 ; i<arr.length-1 ; i++){
            if(arr[i+1]-arr[i] > k){
                k = arr[i+1] - arr[i];
            }
        }

        return k-1;
    }
}
