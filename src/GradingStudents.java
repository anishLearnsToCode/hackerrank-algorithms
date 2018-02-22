import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i, ans[];

        System.out.print("Size : ");
        n=s.nextInt();

        int arr[] = new int[n];

        for(i=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }

        ans = grades(arr);

        for(i=0 ; i<ans.length ; i++)
            System.out.println(ans[i]);
    }

    public static int[] grades(int arr[]){
        int i;
        int ans[] = new int[arr.length];

        for(i=0 ; i<arr.length ; i++){
            if(arr[i]<38)
                ans[i] = arr[i];
            else if((5 - arr[i]%5)<3)
                ans[i] = arr[i] - arr[i]%5 + 5;
            else
                ans[i] = arr[i];
        }

        return ans;
    }
}
