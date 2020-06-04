import java.util.Scanner;

public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1, str2, ans;
        int k;

        str1=s.next();
        str2=s.next();
        k=s.nextInt();

        ans = operation(str1, str2, k);
        System.out.println(ans);
    }

    public static String operation(String str1, String str2, int k){
        int i, j, change, pointer;
        String temp_str1, temp_str2, ans="NO";

        if(str1.length()>=str2.length()){
            temp_str1=str1;
            temp_str2=str2;
        }
        else{
            temp_str1=str2;
            temp_str2=str1;
        }

        for(i=temp_str1.length()-1, change=0, pointer=temp_str1.length() ; i>=0 ; i--){
            if(temp_str2.length()<=i) {
                change++;
                pointer--;
            }

            else if(temp_str1.charAt(i)!=temp_str2.charAt(i)){
                change+=2*(pointer-i);
                pointer--;
            }
        }

        if(change==k)
            ans = "YES";

        else if(k<change)
            ans = "NO";

        else if((k-change)%2==0){
            ans = "YES";
        }

        else if((temp_str1.length()+temp_str2.length())<=k){
            ans = "YES";
        }

        return ans;
    }
}
