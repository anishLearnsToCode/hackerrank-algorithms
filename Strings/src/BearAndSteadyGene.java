import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int ans = minCostBearDNA(str);
        System.out.println("\nAns : " + ans);
    }

    private static int minCostBearDNA(String str) {
        HashMap<Character, Integer> frequencyMap = indexing(str);
        HashMap<Character, ArrayList<Integer>> indexMap = hashing(str);
        hashing(frequencyMap, str);
        HashMap<Character, Integer> discrepancyMap = geneProperty.discrepancyMap;
        int totalDiscrepancy = geneProperty.totalDiscrepancy, ans=str.length(), discrepancy;

        print(frequencyMap);
        PrintClass.print(indexMap);
        System.out.println("\n");
        print(discrepancyMap);
        System.out.println(totalDiscrepancy);

        //CODE
        if(totalDiscrepancy <= 1) {
            return totalDiscrepancy;
        }

        ArrayList<Character> characterSet = prepareSet(discrepancyMap);
        PrintClass.print(characterSet);

        if(characterSet.size() == 1){
            discrepancy = discrepancyMap.get(characterSet.get(0));
            ArrayList<Integer> indexList = indexMap.get(characterSet.get(0));

            for(int i=0 ; i<indexList.size() - discrepancy + 1 ; i++){
                ans = Math.min(ans, indexList.get(i+discrepancy-1) - indexList.get(i) + 1);
                if(ans == discrepancy) break;
            }

        } else if(characterSet.size() == 2){
            int discrepancy1 = discrepancyMap.get(characterSet.get(0)), discrepancy2 = discrepancyMap.get(characterSet.get(1));
            ArrayList<Integer> list1 = indexMap.get(characterSet.get(0));
            ArrayList<Integer> list2 = indexMap.get(characterSet.get(1));

            if(discrepancy1 == 1){
                int j=0;
                for(int i=0 ; i<list1.size() ; ) {

                    if(discrepancy2 == 1){

                        ans = Math.min(ans, Math.abs(list1.get(i) - list2.get(j)) + 1);
                        if(ans == totalDiscrepancy) break;

                        if(list2.get(j) < list1.get(i) && j != list2.size()-1) j++;
                        else i++;

                    } else {

                        int extra = isIncluded(i, j, j+discrepancy2-1, list1, list2) ? 0 :
                                Math.min( Math.abs(list2.get(j) - list1.get(i)), Math.abs(list2.get(j+discrepancy2-1) - list1.get(i))) ;

                        ans = Math.min(ans, list2.get(j+discrepancy2-1) - list2.get(j) + 1 + extra );
                        if(ans == totalDiscrepancy) break;

                        if(list2.get(j) < list1.get(i) && j+discrepancy2-1 < list2.size()-1) j++;
                        else i++;
                    }
                }

            } else {
                if(discrepancy2 == 1){
                    int j=0;
                    for(int i=0 ; i<list1.size() - discrepancy1 +1 ; ){

                        int extra = isIncluded(j, i, i+discrepancy1-1, list2, list1) ? 0 :
                                Math.min( Math.abs(list1.get(i) - list2.get(j)), Math.abs(list1.get(i+discrepancy1-1) - list2.get(j)) );
                        ans = Math.min(ans, list1.get(i+discrepancy1-1) - list1.get(i) + 1 + extra);
                        if(ans == totalDiscrepancy) break;

                        if(list2.get(j) < list1.get(i+discrepancy1-1) && j < list2.size()-1) j++;
                        else i++;
                    }
                } else {
                    int j=0;
                    for(int i=0 ; i < list1.size() - discrepancy1 + 1 ; ) {

                        int extra = isIncluded(i, i+discrepancy1-1, j, j+discrepancy2-1, list1, list2) ? 0 :
                                Math.min( Math.abs(list1.get(i) - list2.get(j)),
                                        Math.abs(list1.get(i+discrepancy1-1) - list2.get(j+discrepancy2-1)));
                        ans  = Math.min(ans, list1.get(i+discrepancy1-1) - list1.get(i) + 1 + extra);
                        if(ans == totalDiscrepancy) break;

                        if(list2.get(j) < list1.get(i+discrepancy1-1) && j+discrepancy2-1 < list2.size()-1) j++;
                        else i++;
                    }
                }
            }

        } else if(characterSet.size() == 3){
            int discrepancy1 = discrepancyMap.get(characterSet.get(0)); ArrayList<Integer> list1 = indexMap.get(characterSet.get(0));
            int discrepancy2 = discrepancyMap.get(characterSet.get(1)); ArrayList<Integer> list2 = indexMap.get(characterSet.get(1));
            int discrepancy3 = discrepancyMap.get(characterSet.get(2)); ArrayList<Integer> list3 = indexMap.get(characterSet.get(2));
        }

        return ans;
    }

    private static boolean isInRange(int start, ArrayList<Integer> list2, ArrayList<Integer> list1, int index){
        return Math.abs(list2.get(start) - list1.get(index)) == 1;
    }

    private static boolean isInRange(int index, int start, int end, ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if(list1.get(index) < list2.get(end) && list1.get(index) > list2.get(start))
            return true;
        if(list1.get(index) == list2.get(start)-1  ||  list1.get(index) == list2.get(end) + 1)
            return true;

        return false;
    }

    private static boolean isIncluded(int index, int start, int end, ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list1.get(index) < list2.get(end) && list1.get(index) > list2.get(start);
    }

    private static boolean isIncluded(int start1, int end1, int start2, int end2, ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list2.get(start2) > list1.get(start1) && list2.get(end2) < list1.get(end1);
    }

    private static HashMap<Character, Integer> indexing(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Character arr[] = new Character[4];
        arr[0] = 'A'; arr[1] = 'C'; arr[2] = 'G'; arr[3] = 'T';
        for(int i=0 ; i<arr.length ; map.put(arr[i], 0), i++);

        for(int i=0 ; i<str.length() ; i++){
            if(map.containsKey(str.charAt(i))){
                int previousValue = map.get(str.charAt(i));
                map.put(str.charAt(i), previousValue + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return map;
    }

    private static HashMap<Character, ArrayList<Integer>> hashing(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0 ; i<str.length() ; i++){
            if(map.containsKey(str.charAt(i))){
                ArrayList<Integer> smallList = map.get(str.charAt(i));
                smallList.add(i);
                map.put(str.charAt(i), smallList);
            } else{
                ArrayList<Integer> smallList = new ArrayList<>();
                smallList.add(i);
                map.put(str.charAt(i), smallList);
            }
        }
        return map;
    }

    private static void hashing(HashMap<Character, Integer> map, String str) {
        int totalFrequency = str.length(), geneFrequency = totalFrequency/4, discrepancy, totalDiscrepancy=0;
        HashMap<Character, Integer> discrepancyMap = new HashMap<>();

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            discrepancy = entry.getValue() - geneFrequency;
            totalDiscrepancy += discrepancy > 0 ? discrepancy : 0;
            discrepancyMap.put(entry.getKey(), discrepancy);
        }

        geneProperty.discrepancyMap = discrepancyMap;
        geneProperty.totalDiscrepancy = totalDiscrepancy;
    }

    private static ArrayList<Character> prepareSet(HashMap<Character, Integer> map) {
        ArrayList<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0)
                list.add(entry.getKey());
        }
        return list;
    }

    private static void print(HashMap<Character, Integer> map){
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}


class geneProperty{
    public static int totalDiscrepancy;
    public static HashMap<Character, Integer> discrepancyMap;
}