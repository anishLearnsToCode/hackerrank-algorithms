import java.util.Scanner;
public class AbsolutePermutation {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n, k;

        System.out.print("Size : ");
        n = s.nextInt();
        System.out.print("K : ");
        k = s.nextInt();

        permutation(n, k);
    }

    public static void permutation(int n, int k){
        int arr[] = new int[100000];
        int i, j;
        for(i=0 ; i<arr.length ; arr[i] = i+1, i++);

        if(k > n-1){
            System.out.println("-1");
        }
        else{
            int ans[] = new int[n];
            if(k==0){
                for(i=0 ; i<n ; ans[i]=i+1, i++);
                for(i=0 ; i<n ; System.out.print(ans[i] + " "), i++);
            }

            else if(n%(2*k)==0){
                for(i=0 ; i<n/(2*k) ; i++){
                    for(j=0 ; j<k ; j++){
                        ans[i*(2*k)+j] = arr[i*(2*k)+k+j];
                        ans[i*(2*k)+j+k] = arr[i*(2*k)+j];
                    }
                }

                for(i=0 ; i<n ; System.out.print(ans[i] + " "), i++);
            }
            else
                System.out.println("-1");
        }
    }
}
