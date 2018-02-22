import java.util.Scanner;

public class OrganizingContainersOfBalls {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int size, i, j;
        String ans;

        System.out.print("Enter the size : ");
        size = s.nextInt();

        long arr[][] = new long[size][size];
        long container[] =  new long [size];

        for(i=0 ; i<container.length ; container[i]=0, i++);

        for(i=0 ; i<arr.length ; i++){
            for(j=0, container[i]=0 ; j<arr.length ; j++){
                arr[i][j] = s.nextInt();
                if(arr[i][j]!=0){
                    container[i] += arr[i][j];
                }
            }
        }

        ans = swapping(container, arr);
        System.out.println(ans);
    }

    public static String swapping(long container[], long arr[][]){
        int i, k, j, n=arr.length;
        boolean flag;
        long sum, extra;
        String ans;

        for(i=0, extra=0 ; i<n ; i++){
            for(j=0, sum=0 ; j<n ; j++){
                if(j==i)
                    continue;

                sum += arr[i][j];
            }

            extra += container[i] - sum;
        }

        if(extra%2==0)
            ans = "Possible";
        else
            ans = "Impossible";

        return ans;
    }
}
