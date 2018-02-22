import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeterminingDNAHealth {

    private static HashMap<String, String[]> stringMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("No. of beneficial genes : ");
        int genes = s.nextInt();

        String geneName[] = new String[genes];
        int geneHealth[] = new int[genes];

        System.out.print("Enter Gene Names : ");
        for(int i=0 ; i<genes ; geneName[i] = s.next(), i++);
        System.out.print("Enter Gene Healths : ");
        for(int i=0 ; i<genes ; geneHealth[i] = s.nextInt(), i++);

        System.out.print("\nEnter Number of genes : ");
        genes = s.nextInt();

        System.out.println("Enter the first, last and geneStrands : ");
        String geneStrand[] = new String[genes];
        int first[] = new int[genes];
        int last[]  = new int[genes];
        for(int i=0 ; i<genes ; i++){
            System.out.print("Enter " + i +" : ");
            first[i] = s.nextInt();
            last[i] = s.nextInt();
            geneStrand[i] = s.next();
        }

        printMinMaxGeneHealth(geneName, geneHealth, first, last, geneStrand);
    }

    private static void printMinMaxGeneHealth(String geneName[], int geneHealth[], int first[], int last[], String geneStrand[]){
        HashMap<String, ArrayList<Integer>> indexMap = hashing(geneName);
        long min, max, health;
        int i, j, k;

        for(i=0, min = Long.MAX_VALUE, max = Long.MIN_VALUE, health=0 ; i<geneStrand.length ; i++, health=0){

            String geneSlice[] = SubString.subString(geneStrand[i]);

            for(j=0 ; j<geneSlice.length ; j++){
                if(indexMap.containsKey(geneSlice[j])){
                    ArrayList<Integer> index = indexMap.get(geneSlice[j]);

                    for(k=0 ; k<index.size() ; k++){
                        if(isInRange(index.get(k), first[i], last[i])){
                            health += geneHealth[index.get(k)];
                        }
                    }
                }
            }

            min = Math.min(min, health);
            max = Math.max(max, health);
        }

        System.out.println(min + " " + max);
    }

    private static HashMap<String, ArrayList<Integer>> hashing(String name[]){
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0 ; i<name.length ; i++){
            if(map.containsKey(name[i])){
                ArrayList<Integer> smallList = map.get(name[i]);
                smallList.add(i);
                map.put(name[i], smallList);
            } else {
                ArrayList<Integer> smallList = new ArrayList<>();
                smallList.add(i);
                map.put(name[i], smallList);
            }
        }
        return map;
    }

    public  static String[] contigualSubString(String str){
        if(stringMap.containsKey(str))
            return stringMap.get(str);

        if(str.length() == 1){
            String ans[] = new String[1];
            ans[0] = str;

            if(!stringMap.containsKey(str))
                stringMap.put(str, ans);

            return ans;
        }

        int i, k;
        String smallString = str.substring(1);
        String charString = str.substring(0, 1);
        String smallAns[] = contigualSubString(smallString);
        String ans[] = new String[smallAns.length + 1 + smallString.length()];

        //Assigning previous
        for(i=0 ; i<smallAns.length ; ans[i] = smallAns[i], i++);
        //Adding new Char
        ans[i] = charString;
        //Concatenating Char with previous ans
        for(i++, k=0 ; i<ans.length ; i++, k++){
            ans[i] = charString + smallAns[smallAns.length - smallString.length() + k];
        }

        if(!stringMap.containsKey(str))
            stringMap.put(str, ans);

        return ans;
    }

    private static boolean isInRange(int index, int startIndex, int endIndex) {
        return (startIndex <= index) && (endIndex >= index);
    }

    private static <T, E>void print(HashMap<T, ArrayList<E>> map){
        for(Map.Entry<T, ArrayList<E>> entry : map.entrySet()){
            System.out.println("");
            System.out.print(entry.getKey() + " : ");
            print(entry.getValue());
        }
    }

    private static <T>void print(ArrayList<T> list) {
        for(int i=0 ; i<list.size() ; i++)
            System.out.print(list.get(i) + " ");
    }

    private static void print(String str[]){
        for(int i=0 ; i<str.length ; i++)
            System.out.println(str[i]);
    }
}
