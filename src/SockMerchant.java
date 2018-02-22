import java.util.Scanner;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, ans;

        System.out.print("Size : ");
        size= s.nextInt();

        int sock[] = new int[size];
        arr_input(sock);
        System.out.println("Input collected");

        ans = pair(sock);
        System.out.print(ans);
    }

    public static  void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static void arr_display(int arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
        System.out.println("");
    }

    public static int pair(int arr[]){
        int buffer[] = new int[0];
        int i, c, j, k, t;
        boolean flag;

        for(i=0, c=0, flag = true ; i<arr.length ; flag = true, i++){
            //System.out.println("i = "+i);
            for(j=0 ; j<buffer.length ; j++){
                //System.out.println("j = "+j);

                if(arr[i]==buffer[j]){

                    int temp_arr[] = new int[buffer.length-1];

                    for(k=0, t=0 ; k<buffer.length ; k++){
                        if(k==j)
                            continue;

                        temp_arr[t++]=buffer[k];
                    }

                    buffer = temp_arr;
                    c++;

                    flag = false;

                    break;
                }
            }

            if(flag){
                int temp_arr[] = new int[buffer.length+1];
                for(k=0 ; k<buffer.length ; temp_arr[k]=buffer[k], k++);
                temp_arr[temp_arr.length-1]=arr[i];
                buffer = temp_arr;
            }

            //arr_display(buffer);
        }

        return c;
    }
}
