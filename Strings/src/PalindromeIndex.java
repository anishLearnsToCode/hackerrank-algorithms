import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromeIndex {

    enum DataType{
        ODD, EVEN
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        int ans = palindromeIndex(str);
        System.out.println(ans);
    }

    private static int palindromeIndex(String str) {
        HashMap<Character, ArrayList<Integer>> indexMap = hashing(str);
        HashMap<Character, DataType> typeMap = hashing(indexMap);

        PrintClass.print(indexMap);
        print(typeMap);
        return 0;
    }

    private static HashMap<Character, ArrayList<Integer>> hashing(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0 ; i<str.length() ; i++){
            if(map.containsKey(str.charAt(i))){
                ArrayList<Integer> smallList = map.get(str.charAt(i));
                smallList.add(i);
                map.put(str.charAt(i), smallList);
            } else {
                ArrayList<Integer> smallList = new ArrayList<>();
                smallList.add(i);
                map.put(str.charAt(i), smallList);
            }
        }

        return map;
    }

    private static HashMap<Character, DataType> hashing(HashMap<Character, ArrayList<Integer>> map) {
        HashMap<Character, DataType> ans = new HashMap<>();
        for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            ans.put(entry.getKey(), entry.getValue().size() % 2 == 0 ? DataType.EVEN : DataType.ODD);
        }
        return ans;
    }

    private static void print(HashMap<Character, DataType> map) {
        for(Map.Entry<Character, DataType> entry : map.entrySet()) {
            System.out.println("");
            System.out.print(entry.getKey() + " : " );
            print(entry.getValue());
        }
    }

    private static void print(DataType obj) {
        System.out.print(obj);
    }
}
