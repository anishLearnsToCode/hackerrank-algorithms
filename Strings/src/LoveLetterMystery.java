import java.util.Scanner;
public class LoveLetterMystery {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int ans;

        str = s.next();
        ans = reduceToPalindrome(str);
        System.out.println(ans);
    }

    public static int reduceToPalindrome(String str){
        int i, c;

        for(i=0, c=0 ; i<str.length()/2 ; i++){
            c += Math.abs( str.charAt(i) - str.charAt(str.length()-1-i));
        }

        return c;
    }
}
