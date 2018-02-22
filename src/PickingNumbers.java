import java.util.Scanner;

public class PickingNumbers {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int size, ans;

        System.out.print("Size : ");
        size = s.nextInt();

        int arr[] = new int[size];
        arr_input(arr);

        arr = mergeSort(arr);
        arr_display(arr);

        ans = subSet(arr);
        System.out.println("\n"+ans);

        ans = subSet2(arr);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);
    }

    public static void arr_display(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }

        int i;

        int temp_arr1[] = new int[arr.length/2];
        int temp_arr2[] = new int[arr.length - temp_arr1.length];

        for(i=0 ; i<temp_arr1.length ; temp_arr1[i] = arr[i], i++);
        for( ; i<arr.length ; temp_arr2[i - temp_arr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(temp_arr1);
        int smallAns2[] = mergeSort(temp_arr2);

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

    public static int subSet(int arr[]){
        int i, j, c, k, position;
        boolean flag;

        for(i=1, j=0, c=0, flag = true, k=0, position=1 ; i<arr.length ; ){
            System.out.println("i = "+ i + "j = "+j);

            if(i == arr.length -1){
                if((arr[i] - arr[j])<=1){
                    c = i-j +1;
                }else{
                    c = i-j;
                }

                if(c>k)
                    k=c;

                break;
            }

            if(arr[i]==arr[j]){
                i++;
                position = i+1;
            }
            else if(Math.abs(arr[i]-arr[j])==1){
                if(flag) {
                    position = i;
                    flag = false;
                }
                i++;
            }
            else{
                flag = true;
                c=i-j;
                if(c>k){
                    k=c;
                }
                j = position;
                position = i;
                i++;
            }


        }

        return k;
    }

    public static int subSet2(int arr[]){
        int count[] = new int[100];
        int i, j, k;

        for(i=0 ; i<100 ; count[i]=0, i++);
        for(i=0 ; i<arr.length ; count[arr[i]-1]++, i++);

        for(i=0, k=0 ; i<99 ; i++){
            if((count[i]+count[i+1])>k)
                k=count[i]+count[i+1];
        }

        return k;
    }
}
