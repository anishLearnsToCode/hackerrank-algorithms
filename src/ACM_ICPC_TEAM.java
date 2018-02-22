import java.util.Scanner;

public class ACM_ICPC_TEAM {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, m, i, j, c;

        System.out.print("Enter no. of peoplle : ");
        size = s.nextInt();

        String str[] = new String[size];

        System.out.print("\nEnter no. of subjects : ");
        m = s.nextInt();

        boolean col[] = new boolean[m];
        for(i=0 ; i<m ; col[i] = true, i++);

        for(i=0 ; i<str.length ; i++){
            str[i] = s.next();

            for(j=0 ; j<m ; j++){
                if(col[j]){
                    if(str[i].charAt(j)=='1')
                        col[j] = false;
                }
            }
        }

        for(i=0, c=0 ; i<col.length ; i++){
            if(!col[i])
                c++;
        }

        System.out.println(c);

        int ans = team(str, 0, str.length, str[0].length());
        System.out.println(ans);
    }

    public static int team(String str[], int position, int n, int m){
        int i;

        if(position == str.length-2){
            for(i=0 ; i<m ; i++){
            }
        }
        return 1;
    }
}
