import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class CommonChild {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next(), str2=s.next();

        int table[][] = DPTable(str1, str2);
        print(table);
        System.out.println(table[table.length-1][table[0].length-1]);
    }

    private static int[][] DPTable(String str1, String str2) {
        int table[][] = new int[str2.length() + 1][str1.length() + 1];
        int i, j;

        //First Row
        for(i=0 ; i<table[0].length ; table[0][i] = 0, i++);

        //First Column
        for(i=0 ; i<table.length ; table[i][0] = 0, i++);

        //Rest Of The Table
        for(i=1 ; i<table.length ; i++){
            for(j=1 ; j<table[0].length ; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1))
                    table[i][j] = table[i-1][j-1] + 1;
                else table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
            }
        }

        return table;
    }

    private static void print(int arr[][]){
        for(int i=0 ; i<arr.length ; System.out.println(""), i++)
            for(int j=0 ; j<arr[i].length ; System.out.print(arr[i][j] + " "), j++);
    }
}
