import java.util.Scanner;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, k, ans[][], i, j, ans2;

        System.out.print("Size : ");
        n=s.nextInt();

        int arr[] = new int[n];

        arr_input(arr);

        System.out.print("Element : ");
        k=s.nextInt();

        ans = MaxSubset(arr, k);
        System.out.println("Complete");

        for(i=0 ; i<ans.length ; System.out.println(""), i++){
            for(j=0 ; j<ans[i].length ; j++){
                System.out.print(ans[i][j]+" ");
            }
        }

        ans2 = max_set(ans);
        System.out.println(ans2);

    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i =0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }
    }

    public static int[][] MaxSubset(int arr[], int k){
        if(arr.length==1){
            int ans[][] = new int[1][1];
            ans[0][0] = arr[0];
            return ans;
        }

        int i, j;
        boolean flag = true;

        int new_arr[] = new int[arr.length-1];
        for(i=0 ; i<new_arr.length ; new_arr[i]=arr[i], i++);
        //arr_display(new_arr);
        int smallAns[][] = MaxSubset(new_arr, k);

        for(i=0 ; i<smallAns.length ; flag = true, i++){
            for(j=0 ; j<smallAns[i].length ; j++){
                if((arr[arr.length-1]+smallAns[i][j])%k==0){
                    flag = false;
                    break;
                }
            }

            if(flag){
                int temp_arr[] = new int[smallAns[i].length+1];
                for(j=0 ; j<smallAns[i].length ; temp_arr[j] = smallAns[i][j], j++);
                temp_arr[temp_arr.length-1]=arr[arr.length-1];
                //smallAns[i] = new int[smallAns[i].length + 1];
                smallAns[i] = temp_arr;
                break;
            }

            else if(i==smallAns.length-1){
                int temp_smallAns[][] = new int[smallAns.length+1][];
                //for(j=0 ; j<smallAns.length ; temp_smallAns[j] = new int[smallAns[j].length], j++);
                //temp_smallAns[temp_smallAns.length-1] = new int[1];
                for(j=0 ; j<smallAns.length ; temp_smallAns[j]=smallAns[j], j++);
                temp_smallAns[temp_smallAns.length-1] = new int[1];
                temp_smallAns[temp_smallAns.length-1][0]=arr[arr.length-1];
                smallAns = temp_smallAns;
                break;
            }
            else{
                continue;
            }

        }

        return smallAns;
    }

    public static void arr_display(int arr[]){
        System.out.println("");
        for(int i =0 ; i<arr.length ; System.out.print(arr[i] + " "), i++);
    }

    public static int max_set(int arr[][]){
        int i, k;

        for(i=0, k=0 ; i<arr.length ; i++){
            if(arr[i].length>k)
                k=arr[i].length;
        }

        return k;
    }
}
