import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int students, threshold;
        String ans;

        students=s.nextInt();
        threshold=s.nextInt();

        int arr[] = new int[students];
        arr_input(arr);

        ans = maths(students, threshold, arr);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);

        for(int i=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }
    }

    public static String maths(int students, int threshold, int arr[]){
        int i, c;
        String ans;

        for(i=0, c=0 ; i<arr.length ; i++){
            if(arr[i]<=0){
                c++;
            }
        }

        if(c<threshold)
            ans = "YES";
        else
            ans = "NO";

        return ans;
    }
}
