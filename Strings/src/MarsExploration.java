import java.util.Scanner;
public class MarsExploration {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;
        int ans;

        str = s.next();
        ans = marsMessage(str);
        System.out.println(ans);
    }

    public static int marsMessage(String str){
        int messages, i, ans;
        messages = str.length()/3;

        for(i=0, ans=0 ; i<messages ; i++){
            ans += anomaly(str.substring(3*i, 3*(i+1)));
        }

        return ans;
    }

    public static int anomaly(String str){
        String message = "SOS";
        int i, ans=0;

        for(i=0 ; i<str.length() ; i++){
            if(str.charAt(i)!=message.charAt(i))
                ans++;
        }

        return ans;
    }
}
