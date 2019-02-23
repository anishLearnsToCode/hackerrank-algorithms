// https://www.hackerrank.com/challenges/non-divisible-subset/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.util.Scanner;

public class NonDivisibleSubset {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfValues = s.nextInt();
        int divisor = s.nextInt();

        int array[] = input(numberOfValues);

        int answer = nonDivisibleSubset(divisor, array);
        System.out.println(answer);
    }

    private static int[] input(int numberOfElements) {
        int array[] = new int[numberOfElements];
        for(int index=0 ; index < numberOfElements ; index++) {
            array[index] = s.nextInt();
        }
        return array;
    }

    private static void print(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static int nonDivisibleSubset(int k, int[] S) {
        int maximum=0;
        int remainderCount[] = getRemainderArray(S, k);
        for (int index = 1 ; index <= (k-1) / 2 ; index++) {
            maximum += Math.max(remainderCount[index], remainderCount[k - index]);
        }
        return maximum + (remainderCount[0] > 0 ? 1 : 0) + (remainderCount[k/2] > 0 ? 1 : 0);
    }

    private static int[] getRemainderArray(int array[], int divisor) {
        int answer[] = new int[divisor];
        for (int element : array) {
            answer[element % divisor] ++;
        }
        return answer;
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