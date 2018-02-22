import java.util.Scanner;
public class CaeserCipher {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;
        int k;

        str = s.next();
        System.out.print("Rotations : ");
        k = s.nextInt();
        k = (k+26)%26;
        System.out.println(k);

        str = ceaser(str, k);
        System.out.println(str);
    }

    public static String ceaser(String str, int k){
        int i;
        String ans="";

        for(i=0 ; i<str.length() ; i++){
            if(isUpper(str.charAt(i)) || isLower(str.charAt(i)))
                ans = ans + cipher((str.charAt(i)), k);
            else
                ans = ans + str.charAt(i);
        }

        return ans;
    }

    public static char cipher(char ch, int k){
        if(k==0)
            return ch;

        if(ch=='z')
            return cipher('a', k-1);
        else if(ch == 'Z')
            return cipher('A', k-1);

        return cipher((char)(ch+1), k-1);
    }

    public static boolean isUpper(char ch){
        return ((ch >= 65) && (ch <= 90));
    }

    public static boolean isLower(char ch){
        return ((ch >= 97) && (ch <= 122));
    }
}
