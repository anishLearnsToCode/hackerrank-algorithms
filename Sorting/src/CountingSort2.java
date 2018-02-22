import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingSort2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];

        for(int i=0 ; i<size ; arr[i] = s.nextInt(), i++);  //Array Input

        int frequencyList[] = indexing(arr);
        print(frequencyList);

        System.out.println("");

        for(int i=0 ; i<frequencyList.length ; i++){
            for(int j=0 ; j<frequencyList[i] ; j++)
                System.out.print( (i+1) + " ");
        }
    }

    private static HashMap<Integer, Integer> hashing(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++) {
            if(map.containsKey(arr[i])){
                int previousValue = map.get(arr[i]);
                map.put(arr[i], previousValue + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return map;
    }

    private static int[] indexing(int arr[]) {
        int frequencyArr[] = new int[100];
        for(int i=0 ; i<frequencyArr.length ; frequencyArr[i] = 0, i++);
        for(int i=0 ; i<arr.length ; frequencyArr[arr[i]-1]++, i++);
        return frequencyArr;
    }

    private static void print(int arr[]) {
        System.out.println("");
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void print(HashMap<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
