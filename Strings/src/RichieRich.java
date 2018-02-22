import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RichieRich {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.print("Enter K : ");
        int k = s.nextInt();

        String ans = palindromeString(str, k);
        System.out.println("\n" + ans);
    }

    private static String palindromeString(String str, int k){
        int change = palindromeChange(str), i, j;
        HashMap<Integer, Boolean> indexMap = hashing(str);
        System.out.println(change);
        PrintClass.print(indexMap);

        if(change > k){
            return "-1";
        }

        String ans = "";

        for(i=0 ; i<(str.length()+1)/2 ; i++) {
            System.out.println(ans);
            if(indexMap.get(i)){
                if(k - 2 >= change-1){
                    ans += "9";
                    k-=2;
                    change--;
                }else {
                    ans += Math.max(Num(str.charAt(i)), Num(str.charAt(str.length()-1-i))) + "";
                    k--; change--;
                }
            } else if(k > change){
                if(str.length() % 2 == 0){
                    int numOfNines = numOfNine(str.charAt(i), str.charAt(str.length()-1-i));
                    if(k - 2 + numOfNines >= change){
                        ans += "9";
                        k-= (2-numOfNines);
                    } else ans += str.charAt(i);
                } else {
                    if(i == (str.length()-1)/2){
                        if(k-1 >= change){
                            ans += "9";
                            k--;
                        } else ans += str.charAt(i);
                    } else {
                        int numOfNines = numOfNine(str.charAt(i), str.charAt(str.length()-1-i));
                        if(k-2+numOfNines >= change){
                            ans += "9";
                            k -= (2 - numOfNines);
                        } else ans += str.charAt(i);
                    }
                }
            } else {
                ans += str.charAt(i);
            }
        }

        String end;

        if(str.length() % 2 == 0) end = reverse(ans);
        else end = reverse(ans).substring(1);

        return ans +  end;
    }

    private static int numOfNine(char ch1, char ch2) {
        return (ch1 == '9' ? 1 : 0) + (ch2 == '9' ? 1 : 0);
    }

    private static int Num(char ch) {
        return (int)ch-48;
    }

    private static String reverse(String str) {
        String ans = "";
        for(int i=str.length()-1 ; i>=0 ; i--){
            ans += str.charAt(i);
        }
        return ans;
    }

    private static int palindromeChange(String str){
        int i, change;
        for(i=0, change=0 ; i<(str.length()+1)/2 ; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                change++;
        }
        return change;
    }

    private static HashMap<Integer, Boolean> hashing(String str) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0 ; i<(str.length()+1)/2 ; i++){
            map.put(i, str.charAt(i) != str.charAt(str.length() -1 -i));
        }
        return map;
    }
}
