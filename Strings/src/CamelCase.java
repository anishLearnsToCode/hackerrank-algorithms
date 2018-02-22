import java.util.Scanner;
public class CamelCase {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;

        str = s.next();
        int ans = camelCase(str);
        System.out.println(ans);
    }

    public static int camelCase(String str){
        int i, counter;

        for(i=0, counter=0 ; i<str.length() ; i++){
            if(isUpper(str.charAt(i)))
                counter++;
        }

        return counter+1;
    }

    public static boolean isUpper(char ch){
        return ((ch >= 65) && (ch <= 90));
    }
}
