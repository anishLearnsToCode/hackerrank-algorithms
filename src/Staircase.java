import java.util.Scanner;
public class Staircase {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n;

        System.out.print("lLines : ");
        n = s.nextInt();

        pattern(n);
    }

    public static void pattern(int n){
        int i, j;

        for(i=0 ; i<n ; System.out.println(""), i++){
            for(j=0 ; j<n-i ; System.out.print(" "), j++);
            for(j=0 ; j<i+1 ; System.out.print("#"), j++);
        }
    }
}
