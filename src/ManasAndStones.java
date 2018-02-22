import java.util.Scanner;

public class ManasAndStones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, a, b, t, i;

        System.out.print("Enter no. of testcase : ");
        t=s.nextInt();

        for(i=0 ; i<t ; i++) {
            System.out.print("No. of stones : ");
            n = s.nextInt();
            System.out.print("a : ");
            a = s.nextInt();
            System.out.print("b : ");
            b = s.nextInt();

            trail(n, a, b);
        }
    }

    public static void trail(int n, int a, int b){
        int stone1, stone2, i, ans;
        int arr[] = new int[n];

        if(a==b){
            System.out.println((n-1)*a);
            return;
        }
        else if(a>b){
            stone1 = b;
            stone2 = a;
        }
        else{
            stone1 = a;
            stone2 = b;
        }

        for(i=0 ; i<n ; i++){
            ans = (n-1-i)*stone1 + i*stone2;
            System.out.print(ans+" ");
            arr[i] = ans;
        }

        /*
        arr = mergeSort(arr);
        System.out.println("");
        for(i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }*/
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
                for(t=0 ; t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], i++);
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
