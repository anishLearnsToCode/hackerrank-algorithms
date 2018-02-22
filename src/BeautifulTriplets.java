import java.util.Scanner;

public class BeautifulTriplets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, i, d, j, ans;

        System.out.print("Size : ");
        size = s.nextInt();

        int arr[] = new int[size];
        int elementArr[] = new int[size];
        int indexArr[] = new int[size];

        /*
        for(i=0 ; i<indexArr.length ; indexArr[i]=0, i++);

        for(i=0, j=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();
            if(i==0){
                elementArr = new int[1];
                elementArr[0] = arr[0];
                indexArr[0]++;
            }
            else if(arr[i] == arr[i-1]){
                indexArr[j]++;
            }
            else{
                elementArr[j+1] = arr[i];
                indexArr[j+1]++;
                j=i;
            }
        }*/

        for(i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);

        System.out.print("Enter difference : ");
        d = s.nextInt();

        ans = triplets(arr, d);
        System.out.println(ans);
    }

    public static int triplets(int arr[], int d){
        int i, j, k, c;

        for(i=0, j=1, k=2, c=0 ; (i<arr.length-2) && (j<arr.length-1) && (k<arr.length) ;){
            if(arr[j]-arr[i] == d){
                if(arr[k]-arr[j]==d){
                    c++;
                    i++;
                    j++;
                    k++;
                }
                else if(arr[k] - arr[j] > d){
                    i++;
                }
                else{
                    k++;
                }
            }

            else if(arr[j]-arr[i] > d){
                i++;
            }
            else{
                j++;
            }
        }

        return c;
    }
}
