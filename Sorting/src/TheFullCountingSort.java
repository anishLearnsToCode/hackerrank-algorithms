import java.util.ArrayList;
import java.util.Scanner;

public class TheFullCountingSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, data;
        String str;

        System.out.print("Size : ");
        size = s.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0 ; i<size ; i++){
            data = s.nextInt();
            str = s.next();

            if(i < size/2)
                list.add(new Node("-", data));
            else
                list.add(new Node(str, data));
        }

        list = mergeSort(list);
        for(int i=0 ; i<list.size() ; i++){
            System.out.print(list.get(i).str + " ");
        }
    }

    private static ArrayList<Node> mergeSort(ArrayList<Node> list) {
        if(list.size() == 1 || list.size() == 0){
            return list;
        }

        ArrayList<Node> smallList1 = new ArrayList<>();
        ArrayList<Node> smallList2 = new ArrayList<>();
        int i;

        for(i=0 ; i<list.size()/2 ; smallList1.add(list.get(i)), i++);
        for( ; i<list.size() ; smallList2.add(list.get(i)), i++);

        ArrayList<Node> ans1 = mergeSort(smallList1);
        ArrayList<Node> ans2 = mergeSort(smallList2);

        return merge(ans1, ans2);
    }

    private static ArrayList<Node> merge(ArrayList<Node> list1, ArrayList<Node> list2) {
        int i, j, k, t;
        ArrayList<Node> ans = new ArrayList<>();

        for(i=0, j=0, k=0 ; i<=list1.size() && j<=list2.size() ; ) {
            if(i == list1.size()) {
                for(t=0 ; t<list2.size() - j ; ans.add(list2.get(j+t)), t++);
                break;
            } else if(j == list2.size()) {
                for(t=0 ; t<list1.size() - i ; ans.add(list1.get(i+t)), t++);
                break;
            }

            if(list1.get(i).data <= list2.get(j).data){
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }

        return ans;
    }
}


class Node {
    String str;
    int data;

    Node(String str, int data){
        this.data = data;
        this.str = str;
    }
}
