import java.util.Scanner;

public class FairRations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people, ans, sum, i, counter, k;

        System.out.print("People : ");
        people = s.nextInt();

        int arr[] = new int[people];

        for(i=0, counter=0, sum=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
            sum+=arr[i];
            if(arr[i]%2!=0)
                counter++;
        }

        if(sum%2==0){
            int odd[] = new int[counter];
            for(i=0, k=0 ; i<arr.length ; i++){
                if(arr[i]%2!=0){
                    odd[k++] = arr[i];
                }
            }

            for(i=0, sum=0 ; i<odd.length/2 ; i+=2){
                sum += odd[i+1] - odd[i];
            }

            ans = sum*2;
            System.out.println(ans);
        }
        else{
            System.out.println("NO");
        }
    }
}
