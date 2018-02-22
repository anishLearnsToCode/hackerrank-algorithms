import java.util.Scanner;

public class Kangaroo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x1, x2, v1, v2;
        String ans;

        System.out.print("Enter x1, v1 : ");
        x1 = s.nextInt();
        v1 = s.nextInt();

        System.out.print("Enter x2, v2 : ");
        x2 = s.nextInt();
        v2 = s.nextInt();

        ans = speed(x1, v1, x2, v2);
        System.out.println(ans);
    }

    public static String speed(int x1, int v1, int x2, int v2){
        String ans="";

        if(v1==v2){
            if(x1==x2)
                ans = "YES";
            else
                ans = "NO";
        }

        else{
            if((((x2-x1)%(v1-v2))==0) && ((x2-x1)/(v1-v2)>=0))
                ans = "YES";
            else
                ans = "NO";
        }

        return ans;
    }
}
