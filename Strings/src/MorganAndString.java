import java.util.Scanner;

public class MorganAndString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next(), str2 = s.next();

        String ans = minLexographicString(str1, str2);
        System.out.println(ans);
    }

    private static String minLexographicString(String str1, String str2) {
        int i, j;
        String ans = "";
        for(i=0, j=0 ; i<=str1.length() && j<=str2.length() ; ){

            if(i==str1.length()){
                ans += str2.substring(j);
                break;
            }
            else if(j == str2.length()){
                ans += str1.substring(i);
                break;
            }

            if(str1.charAt(i) < str2.charAt(j)){
                ans += str1.charAt(i);
                i++;
            } else {
                ans += str2.charAt(j);
                j++;
            }
        }
        return ans;
    }
}
