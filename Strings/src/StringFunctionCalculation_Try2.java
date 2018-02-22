import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringFunctionCalculation_Try2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        long ans = maxValue(str);
        System.out.println(ans);
    }

    private static long maxValue(String str) {
        HashMap<Character, ArrayList<Integer>> indexMap = hashing(str);
        HashMap<Integer, ArrayList<Character>> frequencyMap = hashing(indexMap);
        ArrayList<Integer> frequencyList = indexing(frequencyMap);
        ArrayList<property> priorityList = preparePriorityList(frequencyMap, frequencyList);
        priorityList = mergeSort(priorityList);

        print(priorityList, 1);

        boolean flag = false;
        int i, j, k, currentFrequency;
        long ans = Math.max(frequencyList.get(frequencyList.size()-1), str.length());
        long temp = frequencyList.get(frequencyList.size()-1);
        final long MAX_ANS = Math.max( ((temp + 1)/2) * (temp/2 + 1), str.length());
        System.out.println("\n" + MAX_ANS + " " + ans);

        for(i=priorityList.size()-1 ; i>=0 ; i--) {
            if(ans == MAX_ANS || ans >= priorityList.get(i).maxLen){
                break;
            }

            property currentObj = priorityList.get(i);
            for(j=0 ; j<currentObj.list.size() ; j++){

                if(isTogether(currentObj.strLen, currentObj.instances, currentObj.list.get(j), str, indexMap)){
                    ans = currentObj.maxLen;
                    flag = true;
                    break;
                } else if(isTogether(currentObj.instances, currentObj.strLen, currentObj.list.get(j), str, indexMap)){
                    ans = currentObj.maxLen;
                    flag = true;
                    break;
                }
            }

            if(flag) {
                break;
            }
        }

        return ans;
    }

    private static boolean isTogether(int length, int instances, Character ch, String str, HashMap<Character, ArrayList<Integer>> map) {
        int i, j, count;
        ArrayList<Integer> indexList = map.get(ch);

        for(i=0, count=0 ; i<indexList.size()-length+1 ; i++) {
            if(indexList.get(i+length-1) - indexList.get(i) + 1 == length) count++;
        }

        return count >= instances ;
    }

    private static ArrayList<property> preparePriorityList(HashMap<Integer, ArrayList<Character>> frequencyMap, ArrayList<Integer> frequencyList) {
        int i, j, frequency;
        ArrayList<property> ans = new ArrayList<>();

        for(i=frequencyList.size()-1 ; i>=0 ; i--) {
            frequency = frequencyList.get(i);
            ArrayList<Character> smallList = frequencyMap.get(frequencyList.get(i));

            for(j=2 ; j<=(frequency + 1)/2 ; j++) {
                property obj1 = new property(j, frequency-j+1, j * (frequency-j+1), smallList);
                ans.add(obj1);
            }
        }

        return ans;
    }

    private static ArrayList<Integer> indexing(HashMap<Integer, ArrayList<Character>> map) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Character>> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
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

    private static HashMap<Integer, ArrayList<Character>> hashing(HashMap<Character, ArrayList<Integer>> map) {

        HashMap<Integer, ArrayList<Character>> frequencyMap = new HashMap<>();

        for(Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            if(frequencyMap.containsKey(entry.getValue().size())){
                ArrayList<Character> smallList = frequencyMap.get(entry.getValue().size());
                smallList.add(entry.getKey());
                frequencyMap.put(entry.getValue().size(), smallList);
            } else {
                ArrayList<Character> smallList = new ArrayList<>();
                smallList.add(entry.getKey());
                frequencyMap.put(entry.getValue().size(), smallList);
            }
        }

        return frequencyMap;
    }

    private static ArrayList<property> mergeSort(ArrayList<property> list) {
        if(list.size() == 1 || list.size() == 0){
            return list;
        }

        ArrayList<property> smallList1 = new ArrayList<>();
        ArrayList<property> smallList2 = new ArrayList<>();
        int i;

        for(i=0 ; i<list.size()/2 ; smallList1.add(list.get(i)), i++);
        for( ; i<list.size() ; smallList2.add(list.get(i)), i++);

        ArrayList<property> ans1 = mergeSort(smallList1);
        ArrayList<property> ans2 = mergeSort(smallList2);

        return merge(ans1, ans2);
    }

    private static ArrayList<property> merge(ArrayList<property> list1, ArrayList<property> list2) {
        ArrayList<property> ans = new ArrayList<>();
        int i, j, k, t;

        for(i=0, k=0, j=0 ; i<=list1.size() && j<=list2.size() ; ) {
            if(i == list1.size()){
                for(t=0 ; t<list2.size() - j ; ans.add(list2.get(j+t)), t++);
                break;
            } else if(j == list2.size()) {
                for(t=0 ; t<list1.size()-i ; ans.add(list1.get(i+t)), t++);
                break;
            }

            if(list1.get(i).maxLen <= list2.get(j).maxLen) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }

        return ans;
    }

    private static <T, E>void print(HashMap<T, E> map) {
        for(Map.Entry<T, E> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void print(ArrayList<Integer> list){
        for(int i=0 ; i<list.size() ; i++){
            System.out.print(list.get(i) + " ");
        }
    }

    private static void print(ArrayList<Character> list, char a) {
        System.out.println(list);
    }

    private static void print(ArrayList<property> list, int a) {
        for(int i=0 ; i<list.size() ; i++){
            System.out.println(list.get(i).instances + " " + list.get(i).strLen + " " + list.get(i).maxLen);
            print(list.get(i).list, 'a');
        }
    }

    private static void print(Stack<property> stack) {
        for(int i=0 ; i<stack.size() ; i++){
            System.out.println(stack.elementAt(i).instances + " " + stack.elementAt(i).strLen + " " + stack.elementAt(i).maxLen);
        }
    }
}


class property {
    public int instances, strLen, maxLen;
    public ArrayList<Character> list = new ArrayList<>();

    property(int instances, int strLen, int maxLen, ArrayList<Character> list){
        this.instances = instances;
        this.maxLen = maxLen;
        this.strLen = strLen;
        this.list = list;
    }
}