import java.util.Scanner;

public class sequenceEquation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("size : ");
        size = s.nextInt();

        int arr[] = new int[size];

        CircularArrayRotation.arr_input(arr);

        function(arr);
    }

    public static void function(int arr[]){
        int i, j, k;

        for(i=0 ; i<arr.length ; i++){
            if(arr[i]==i+1){
                System.out.println(i+1);
                continue;
            }

            for(j=0 ; j<arr.length ; j++){
                if(arr[j]==i+1){
                    break;
                }
            }

            for(k=0 ; k<arr.length ; k++){
                if(arr[k]==j+1){
                    System.out.println(k+1);
                }
            }
        }
    }
}
