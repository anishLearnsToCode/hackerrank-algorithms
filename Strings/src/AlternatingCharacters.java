import java.util.Scanner;
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int ans;

        str = s.next();
        ans = removeChar(str);
        System.out.println(ans);
    }

    public static int removeChar(String str){
        int i, j, delete;
        char ch1, ch2;

        if(str.charAt(0)=='A'){
            ch1 = 'A';
            ch2 = 'B';
        }
        else{
            ch1 = 'B';
            ch2 = 'A';
        }

        for(i=0, j=0, delete=0 ; i<str.length() ; i++){
            if((j+2)%2==0){
                if(str.charAt(i)==ch2)
                    delete++;
                else
                    j++;
            }else{
                if(str.charAt(i)==ch1)
                    delete++;
                else
                    j++;
            }
        }

        return delete;
    }
}
