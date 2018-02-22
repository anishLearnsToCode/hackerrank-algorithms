import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n, ans;
        String str;

        System.out.print("No. of dteps : ");
        n = s.nextInt();

        str = s.next();

        ans = hike(n, str);
        System.out.println(ans);
    }

    public static int hike(int steps, String str){
        int i, c, sum;
        boolean flag;

        for(i=0, c=0, sum=0, flag = true ; i<steps ; i++){
            sum += num(str.charAt(i));

            if((sum<0) && (flag)) {
                c++;
                flag = false;
            }

            if(sum==0){
                flag = true;
            }
        }


        return c;
    }

    public static int num(char ch){
        int ans;

        if(ch == 'U')
            ans = 1;
        else
            ans = -1;

        return ans;
    }
}
