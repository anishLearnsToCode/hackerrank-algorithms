import java.util.Scanner;
public class HackerrankInAString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;

        str = s.next();
        inString(str);
    }

    public static void inString(String str){
        String comparison = "hackerrank";
        int i, j;

        for(i=0, j=0 ; i<str.length() ; i++){
            if(str.charAt(i)==comparison.charAt(j))
                j++;

            if(j==comparison.length())
                break;
        }

        if(j==comparison.length())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
