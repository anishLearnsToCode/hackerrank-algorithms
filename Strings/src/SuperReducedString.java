import java.util.Scanner;
public class SuperReducedString {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;

        str = s.next();

        String ans  = reduce(str);

        if(ans.length()==0)
            ans = "Empty String";

        System.out.println(ans);
    }

    public static String reduceString(String str){
        String ans="";
        int i, j, operation;

        for(i=1, j=0, operation=0 ; i<str.length() ; ){
            if(i==str.length()-1){
                if(str.charAt(i)==str.charAt(j)){
                    operation++;
                    if(str.substring(j).length()%2==1){
                        ans += str.charAt(j);
                    }
                }else{
                    if(str.substring(j, i).length()%2==1){
                        ans = ans + str.charAt(j) + str.substring(i);
                    }else
                        ans = ans + str.substring(i);
                }

                break;
            }

            if(str.charAt(i)==str.charAt(j)){
                i++;
                operation++;
            }
            else{
                if(str.substring(j, i).length()%2==1)
                    ans += str.charAt(j);

                j=i;
                i++;
            }
        }

        //System.out.println(operation);

        return ans;
    }

    public static String reduce(String str){
        String ans;
        ans = reduceString(str);
        //System.out.println(ans);

        if(!ans.equals(str))
            ans = reduce(ans);

        return ans;
    }
}
