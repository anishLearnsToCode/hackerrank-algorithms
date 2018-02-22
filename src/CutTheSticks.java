import java.util.Scanner;

public class CutTheSticks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Size : ");
        size=s.nextInt();

        int arr[] = new int[size];

        arr_input(arr);

        sticks(arr);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }
    }

    public static void sticks(int arr[]){
        int i, j, min, c, k;

        for(i=0, c=0 ; ; i++, c=0){
            System.out.println(arr.length);

            min = arr[arr_min(arr)];

            for(j=0 ; j<arr.length ; j++){
                arr[j]-=min;

                if(arr[j]==0)
                    c++;
            }

            int new_arr[] = new int[arr.length-c];

            for(j=0, k=0 ; j<arr.length ; j++){
                if(arr[j]==0)
                    continue;

                new_arr[k++]=arr[j];
            }

            arr = new_arr;

            if(arr.length==0)
                break;
        }
    }

    public static int arr_min(int arr[]){
        int i, k;

        for(i=0, k=0 ; i<arr.length ; i++){
            if(arr[i]<arr[k])
                k=i;
        }

        return k;
    }
}
