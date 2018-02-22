import java.util.Scanner;

public class Cavitymap {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n, i, j;
        String ans[];

        System.out.print("Size : ");
        n=s.nextInt();

        String row[] = new String[n];
        for(i=0 ; i<row.length ; i++){
            row[i] = s.next();
        }

        ans = cavity(row);
        for(i=0 ; i<ans.length ; i++){
            System.out.println(ans[i]);
        }
    }

    public static String[] cavity(String str[]){
        int i, j, position;
        String ans[] = new String[str.length];
        boolean flag;

        for(i=1, flag = true, position=-1 ; i<str.length-1 ; flag = true, i++, position=-1){
            for(j=1 ; j<str[0].length()-1 ; j++){
                if(check(i, j, str)){
                    if(position==-1){
                        ans[i] = str[i].substring(0, j) + "X";
                    }else {
                        ans[i] += str[i].substring(position + 1, j) + "X";
                    }
                    flag = false;
                    position = j;
                }
            }

            if(flag)
                ans[i] = str[i];
            else
                ans[i] += str[i].substring(position + 1);
        }

        ans[0] = str[0];
        ans[str.length-1] = str[str.length-1];

        return ans;
    }

    public static boolean check(int row, int col, String str[]){
        boolean flag = true;

        flag = flag && (str[row].charAt(col) > str[row].charAt(col+1)) && (str[row].charAt(col) > str[row].charAt(col-1)) && (str[row].charAt(col) > str[row+1].charAt(col)) && (str[row].charAt(col) > str[row-1].charAt(col));
        return flag;
    }
}
