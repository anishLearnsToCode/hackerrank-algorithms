import java.util.Scanner;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int clouds, ans;

        System.out.print("Clouds : ");
        clouds = s.nextInt();

        int arr[]  = new int[clouds];

        arr_input(arr);

        ans = path(arr, 0)-1;
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static int path(int arr[], int position){
        int path1=Integer.MAX_VALUE, path2=Integer.MAX_VALUE, ans;

        if(position==arr.length-1)
            return 1;

        if(arr[position+1]==0)
            path1 = 1 + path(arr, position+1);
        if(((position+2) <arr.length ) && (arr[position+2]==0))
            path2 = 1 + path(arr, position+2);

        if(path1<=path2)
            ans = path1;
        else
            ans = path2;

        return ans;
    }
}
