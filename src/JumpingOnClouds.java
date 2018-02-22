import java.util.Scanner;

public class JumpingOnClouds {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int clouds, jump, ans, position;

        System.out.print("Clouds : ");
        clouds = s.nextInt();

        int arr[] = new int[clouds];

        CircularArrayRotation.arr_input(arr);

        System.out.print("Enter jump amount : ");
        jump = s.nextInt();

        if(jump>=arr.length){
            position = jump - arr.length*(jump/arr.length);
        }else{
            position = jump;
        }

        ans = result(arr, 100, jump, position);
        System.out.println(ans);
    }

    public static int result(int arr[], int energy, int jump, int position){
        if(arr[position]==0)
            energy-=1;
        else
            energy-=3;

        if(position==0)
            return energy;

        int new_position;
        if(jump+position>=arr.length){
            new_position = (jump + position) - arr.length*((jump + position)/arr.length);
        }
        else
            new_position = jump + position;

        System.out.println(new_position);

        return result(arr, energy, jump, new_position);
    }
}
