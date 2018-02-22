import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class TwoCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;

        str = s.next();
        if(str.length() == 1 ){
            System.out.println("0");
            return;
        }

        HashMap<String, ArrayList<Integer>> posMap = hashing(str);

        int ans = maxLength(str, posMap);
        System.out.println("\nAns : " + ans);
    }

    private static HashMap<String, ArrayList<Integer>> hashing(String str){
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0 ; i<str.length() ; i++){
            if(map.containsKey(str.charAt(i) + "")){
                ArrayList<Integer> smallList = map.get(str.charAt(i)+"");
                smallList.add(i);
                map.put(str.charAt(i)+"", smallList);
            }else {
                ArrayList<Integer> smallList = new ArrayList<>();
                smallList.add(i);
                map.put(str.charAt(i)+"", smallList);
            }
        }

        return map;
    }

    private static ArrayList<Character> characterIndexing(String str) {
        HashSet<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0 ; i<str.length() ; i++){
            if(!set.contains(str.charAt(i))) {
                list.add(str.charAt(i));
                set.add(str.charAt(i));
            }
        }
        return list;
    }

    private static int maxLength(String str, HashMap<String, ArrayList<Integer>> map) {
        int i, j, ans;
        ArrayList<Character> characterSet = characterIndexing(str);

        for(i=0, ans=Integer.MIN_VALUE ; i<characterSet.size()-1 ; i++){
            for(j=i+1 ; j<characterSet.size() ; j++){
                ans = Math.max(ans, getMaxLength(characterSet.get(i), characterSet.get(j), map, str));
            }
        }
        return ans;
    }

    private static int getMaxLength(char ch1, char ch2, HashMap<String, ArrayList<Integer>> map, String str) {
        ArrayList<Integer> indexList= combine(map.get(ch1+""), map.get(ch2+""));
        System.out.println(""); print(indexList);
        return isAlternating(indexList, str) ? indexList.size() : 0;
    }

    private static ArrayList<Integer> combine(ArrayList<Integer> index1List, ArrayList<Integer> index2List){
        return merge(index1List, index2List);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i, j, k, t;

        for(i=0, j=0 ; i<=list1.size() && j<=list2.size() ; ){
            if(i == list1.size()){
                for(; j<list2.size() ; ans.add(list2.get(j)), j++);
                break;
            }else if(j == list2.size()){
                for( ; i<list1.size() ; ans.add(list1.get(i)), i++);
                break;
            }

            if(list1.get(i) <= list2.get(j)){
                ans.add(list1.get(i));
                i++;
            }else {
                ans.add(list2.get(j));
                j++;
            }
        }

        return ans;
    }

    private static boolean isAlternating(ArrayList<Integer> list, String str){
        for(int i=0 ; i<list.size()-1 ; i++){
            if(str.charAt(list.get(i)) == str.charAt(list.get(i+1)))
                return false;
        }
        return true;
    }

    private static void print(HashMap<String, ArrayList<Integer>> map) {
        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print("\n" + entry.getKey() + " : ");
            print(entry.getValue());
        }
    }

    private static <T>void print(ArrayList<T> list) {
        for(int i=0 ; i<list.size() ; i++)
            System.out.print(list.get(i) + " ");
    }
}
