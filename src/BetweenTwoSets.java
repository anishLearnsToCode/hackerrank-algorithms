import java.util.Scanner;

public class BetweenTwoSets {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int a, b, ans;


        System.out.print("A : ");
        a=s.nextInt();
        int arr1[] = new int[a];

        arr_input(arr1);

        System.out.print("B : ");
        b=s.nextInt();
        int arr2[] = new int[b];

        arr_input(arr2);

        //ans = set(arr1, arr2);
        //System.out.println(ans);

        System.out.println("Ans : " + subSet(arr1, arr2));

        //System.out.print("Number : ");
        //int num = s.nextInt();
        //int ans1[] = factor(num);
        //for(int i=0 ; i<ans1.length ; System.out.print(ans1[i]+" "), i++);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static int set(int arr1[], int arr2[]){
        int i, k, j, t, n, c, position, factor_arr[], temp_ans[];
        int ans[] = new int[0];
        int lcm[] = new int[1];
        lcm[0]=1;
        boolean flag;

        for(i=0 ; i<arr1.length ; i++){

            factor_arr = factor(arr1[i]);

            if(i==0){
                ans = factor_arr;
            }

            else {
                for (j = 0, k = 0, position = k, flag = false; j < factor_arr.length; flag = false, position = k, j++) {

                    for (; k < ans.length; k++) {
                        if (factor_arr[j] == ans[k]) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        temp_ans = new int[ans.length + 1];
                        for (t = 0; t < ans.length; temp_ans[t] = ans[t], t++) ;
                        temp_ans[temp_ans.length - 1] = factor_arr[j];
                        ans = temp_ans;
                        k = 0;
                    } else {
                        temp_ans = new int[lcm.length + 1];
                        for (t = 0; t < lcm.length; temp_ans[t] = lcm[t], t++) ;
                        temp_ans[temp_ans.length - 1] = factor_arr[j];
                        lcm = temp_ans;
                        k = position + 1;
                    }
                }
            }
        }

        System.out.println("Ans : ");
        arr_output(ans);
        System.out.println("LCM : ");
        arr_output(lcm);

        for(i=0, n=1, c=0 ; i<ans.length ; n*=ans[i], i++);
        int minValue = arr2[arr_min(arr2)];

        for(i=0, flag=true ; n<=minValue ; flag = true, i++){

            n *= lcm[lcm.length%i];

            for(j=0 ; j<arr2.length ; j++){
                if(arr2[j]%n!=0){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                c++;
            }
        }

        System.out.println("Answer : ");
        return c;
    }

    public static int[] factor(int n){
        int i, j;
        int ans[] = new int[0];

        for(i=2 ; n!=1 ; ){
            if(n%i==0){
                int temp_arr[] = new int[ans.length+1];
                for(j=0 ; j<ans.length ; temp_arr[j]=ans[j], j++);
                temp_arr[temp_arr.length-1]=i;
                ans = temp_arr;
                n/=i;
            }
            else
                i++;
        }

        return ans;
    }

    public static int arr_min(int arr[]){
        int i, k;

        for(i=0, k=0 ; i<arr.length ; i++){
            if(arr[i]<arr[k])
                k=i;
        }

        return k;
    }

    public static int arr_max(int arr[]){
        int i, k;

        for(i=0, k=0 ; i<arr.length ; i++){
            if(arr[i]>arr[k])
                k=i;
        }

        return k;
    }

    public static void arr_output(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }

    public  static int subSet(int arr1[], int arr2[]){
        int i, j, c;
        int maxValue = arr1[arr_max(arr1)];
        int minValue = arr2[arr_min(arr2)];
        boolean flag, flag2;

        System.out.println(maxValue);
        System.out.println(minValue);

        for(i=maxValue, flag = true, c=0 ; i<=minValue ; flag = true, i++){
            for(j=0 ; j<arr1.length ; j++){
                if(i%arr1[j]!=0){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(j=0, flag2 = true ; j<arr2.length ; j++){
                    if(arr2[j]%i!=0){
                        flag2 = false;
                        break;
                    }
                }

                if(flag2){
                    c++;
                }
            }
        }

        return c;
    }
}
