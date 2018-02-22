import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;

        str = s.next();
        String ans[] = subString(str);
        print(ans);

        ans = DeterminingDNAHealth.contigualSubString(str);
        System.out.println("");
        print(ans);
    }

    public static String[] subString(String str){
        int len = str.length(), k, i, start;
        String ans[] = new String[len*(len+1)/2];

        for(i=str.length()-1, k=0, start=0 ; i>=0 ; start += (str.length()-i-1), i--){
            String charString = str.substring(i, i+1);
            //Dupliaction
            for(int j=0 ; j<str.length()-i-1 ; j++) {
                ans[k++] = charString + ans[start+j];
            }

            //Assignment
            ans[k++] = charString;
        }
        return ans;
    }

    private static void print(String str[]){
        for(int i=0 ; i<str.length ; i++)
            System.out.println(str[i]);
    }
}
