import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintClass {
    public static <T,E> void print(HashMap<T, E> map){
        for(Map.Entry<T, E> entry : map.entrySet()) {
            System.out.print("\n" + entry.getKey() + " : ");
            print(entry.getValue());
        }
    }

    public static <T>void print(ArrayList<T> list) {
        for(int i=0 ; i<list.size() ; i++)
            System.out.print(list.get(i) + " ");
    }

    private static <T>void print(T data){
        System.out.print(data);
    }
}
