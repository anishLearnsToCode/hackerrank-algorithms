import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        long ans = totalUnorderedAnagramaticPairs(str);
        System.out.println(ans);
    }

    private static long totalUnorderedAnagramaticPairs(String str) {
        int indexArr[] = indexing(str);
        long ans =0;
        int i, j;

        for(i=0 ; i<indexArr.length ; ans += nC2(indexArr[i]), i++);
        System.out.println(ans);
        if(str.length() <= 1)
            return ans;

        //For other Cases(Substrings of String)
        for(i=0 ; i<str.length()-2 ; i++){

            //Initializing Index Arr[]
            indexArr = new int[26];
            for(j=0 ; j<indexArr.length ; indexArr[j]=0, j++);
            for(j=0 ; j<i+2 ; indexArr[str.charAt(j)-97]++, j++);

            //Initializing Map
            HashMap<String, Integer> frequencyMap = new HashMap<>();

            for(j=0 ; j<str.length()-1-i ; j++){
                String indexString  = compressedString(indexArr);
//                System.out.println(indexString);

                if(frequencyMap.containsKey(indexString)){
                    int previousValue = frequencyMap.get(indexString);
                    frequencyMap.put(indexString, previousValue + 1);
                } else {
                    frequencyMap.put(indexString, 1);
                }

                if(j <= str.length()-i-3) {
                    indexArr[str.charAt(j) - 97]--;
                    indexArr[str.charAt(j + 2 + i) - 97]++;
                }
            }

            System.out.println("\nMap : ");
            print(frequencyMap);
            for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                ans += nC2(entry.getValue());
            }
        }

        return ans;
    }

    private static long decimal(int arr[]){
        long ans;
        int i;
        for(i=arr.length-1, ans=0 ; i>=0 ; i--){
            ans += arr[i] * Math.pow(2, arr.length-i-1);
        }
        return ans;
    }

    private static String compressedString(int indexArr[]){
        String ans = "";

        for(int i=0 ; i<indexArr.length ; i++){
            if(indexArr[i] > 0){
                ans += (char)(i+97) + numToStr(indexArr[i]);
            }
        }
        return ans;
    }

    private static String numToStr(int n) {
        char ch = (char) (n+48);
        return ch+"";
    }

    private static long nC2(int n) {
        return n*(n-1)/2;
    }

    private static int[] indexing(String str) {
        int arr[] = new int[26];
        for(int i=0 ; i<arr.length ; arr[i] = 0, i++);
        for(int i=0 ; i<str.length() ; arr[str.charAt(i) - 97]++, i++);
        return arr;
    }

    private static void print(HashMap<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
