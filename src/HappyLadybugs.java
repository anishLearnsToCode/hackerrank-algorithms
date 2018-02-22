import java.util.Scanner;

public class HappyLadybugs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i, j;
        int arr[] = new int[27];
        String ans;

        int t = s.nextInt();
        for(j=0 ; j<t ; j++) {
            for (i = 0; i < 27; arr[i] = 0, i++) ;

            System.out.print("No. of ladybugs : ");
            n = s.nextInt();

            String str;

            str = s.next();

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_')
                    arr[26]++;
                else
                    arr[str.charAt(i) - 65]++;
            }

            ans = ladyBug(str, arr);
            System.out.println(ans);
        }
    }

    public static String ladyBug(String str, int arr[]){
        int i, j;
        boolean flag = true;
        String ans="";

        if((str.length()==1) && (arr[26]==0)){
            flag = false;
        }
        else if(arr[26]==0){
            for(i=0 ; i<str.length() ;){
                if(i==str.length()-1){
                    if(!(str.charAt(i)==str.charAt(i-1)))
                        flag = false;

                    break;
                }

                if(str.charAt(i)==str.charAt(i+1))
                    i++;
                else if(i>0){
                    if(str.charAt(i) == str.charAt(i-1))
                        i++;
                    else{
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        else{
            for(i=0 ; i<arr.length-1 ; i++){
                if(arr[i]==1){
                    flag = false;
                    break;
                }
            }
        }

        if(flag)
            ans = "YES";
        else
            ans = "NO";

        return ans;
    }
}
