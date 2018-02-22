import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TheFullCountingSort_Try2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for(int i=0 ; i<size ; i++){
            int data = s.nextInt();
            String str = s.next();

            if(map.containsKey(data)){
                ArrayList<String> smallList = map.get(data);
                if(i < size/2) smallList.add("-");
                else smallList.add(str);
                map.put(data, smallList);
            } else {
                ArrayList<String> smallList = new ArrayList<>();
                if(i < size/2) smallList.add("-");
                else  smallList.add(str);
                map.put(data, smallList);
            }
        }

        print(map);
    }

    private static void print(HashMap<Integer, ArrayList<String>> map) {
        for(int i=0 ; i<100 ; i++){
            if(map.containsKey(i)){
                print(map.get(i));
            }
        }
    }

    private static void print(ArrayList<String> list) {
        for(int i=0 ; i<list.size() ; System.out.print(list.get(i) + " "), i++);
    }
}
