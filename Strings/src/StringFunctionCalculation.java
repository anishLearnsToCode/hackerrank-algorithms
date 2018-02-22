import java.util.HashMap;
import java.util.Scanner;

public class StringFunctionCalculation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        long ans = maxValueFunction(str);
        System.out.println(ans);

        ans = maxValue(str);
        System.out.println(ans);
    }

    private static long maxValue(String str){
        return hashing(str);
    }

    private static long hashing(String str){
        HashMap<String, Integer> map = new HashMap<>();
        long ans =0;
        String subStr = "";
        int index1, index2;

        for(index1 =0 ; index1<str.length() ; index1++) {
            for(index2=0, subStr = str.charAt(index1)+"" ; index2<str.length()-index1 ; index2++) {
                if(index2 != 0){
                    subStr = subStr + str.charAt(index1 + index2);
                }

                if(map.containsKey(subStr)){
                    int previousValue = map.get(subStr);
                    map.put(subStr, previousValue + subStr.length());
                    ans = Math.max(ans, previousValue + subStr.length());
                } else {
                    map.put(subStr, subStr.length());
                    ans = Math.max(subStr.length(), ans);
                }
            }
        }
        return ans;
    }

    private static long maxValueFunction(String str) {
        String subStrings[] = subString(str);
        print(subStrings);
        return hashing(subStrings);
    }

    private static String[] subString(String str){
        int n = str.length(), i, j, pointer, slider;
        String ans[] = new String[n*(n+1)/2];

        for(i=0, pointer=0, slider=-1 ; i<str.length() ; i++){
//            System.out.println(pointer + " " + slider);
            for(j=0 ; j<str.length()-i ; j++){
                ans[pointer + j] = (slider == -1 ? "" : ans[slider + j]) + str.charAt(i+j);
            }
            pointer += (str.length() - i);
            slider += (slider == -1 ? 1 : (str.length()-i+1));
        }

        return ans;
    }

    private static long hashing(String str[]){
        HashMap<String, Integer> map = new HashMap<>();
        long ans =0;

        for(int index=0 ; index<str.length ; index++){
            if(map.containsKey(str[index])){
                int previousValue = map.get(str[index]);
                map.put(str[index], previousValue+str[index].length());
                ans = Math.max(ans, previousValue + str[index].length());
            } else {
                map.put(str[index], str[index].length());
                ans = Math.max(ans, str[index].length());
            }
        }

        return ans;
    }

    private static void print(String str[]) {
        for(int i=0 ; i<str.length ; i++){
            System.out.println(str[i]);
        }
    }
}
