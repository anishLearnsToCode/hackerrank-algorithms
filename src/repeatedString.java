import java.util.Scanner;

public class repeatedString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int ans;
        long n;

        str = s.next();
        n = s.nextLong();

        ans = numberA(str, n);
        System.out.println(ans);
    }

    public static int numberA(String str, long n){
        int num, i, ans=0;

        for(i=0, num=0 ; i<str.length() ; i++){
            if(str.charAt(i)=='a')
                num++;
        }

        ans += num*(n/str.length());

        for(i=0 ; i<n%str.length() ; i++){
            if(str.charAt(i)=='a')
                ans++;
        }

        return ans;
    }
}
