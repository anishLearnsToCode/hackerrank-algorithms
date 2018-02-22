import java.util.Scanner;

public class UtopianTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, ans;

        System.out.print("Cycles : ");
        n=s.nextInt();

        ans = cycle(n);
        System.out.println(ans);
    }

    public static int cycle(int n){
        int i, height;

        for(i=0, height=1 ; i<n ; i++){
            if(i%2==0){
                height *= 2;
            }else{
                height += 1;
            }
        }

        return height;
    }
}
