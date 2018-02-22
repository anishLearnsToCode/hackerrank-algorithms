import java.util.Scanner;

public class QueenAttackII {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ans, n, k, queen_row , queen_col, i, j;

        System.out.print("Rows : ");
        n=s.nextInt();
        System.out.print("Obstacles : ");
        k=s.nextInt();
        int obstacle_row[] = new int[k];
        int obstacle_col[] = new int[k];

        System.out.print("Enter position of queen : ");
        queen_row = s.nextInt();
        queen_col = s.nextInt();

        System.out.println("Enter obstacles : ");
        for(i=0 ; i<k ; i++){
            System.out.print("Row , Col : ");
            obstacle_row[i]=s.nextInt();
            obstacle_col[i]=s.nextInt();
        }

        boolean obstacle[][] = new boolean[n][n];
        for(i=0 ; i<n ; i++)
            for(j=0 ; j<n ; obstacle[i][j]=false, j++);

        for(i=0 ; i<k ; i++){
            obstacle[obstacle_row[i]-1][obstacle_col[i]-1]=true;
        }

        ans = chess(queen_row, queen_col, n, obstacle);
        System.out.println(ans);
        System.out.println(chess2(queen_row, queen_col, n, obstacle_row, obstacle_col));
    }

    public static int chess(int queen_row, int queen_col,int n, boolean obstacle[][]){
        int ans=0;

        ans += left(queen_row, queen_col, n, obstacle);
        ans += up(queen_row, queen_col, n, obstacle);
        ans += right(queen_row, queen_col, n, obstacle);
        ans += down(queen_row,queen_col, n, obstacle);
        ans += left_down(queen_row, queen_col, n, obstacle);
        ans += left_up(queen_row, queen_col, n, obstacle);
        ans += right_up(queen_row, queen_col, n, obstacle);
        ans += right_down(queen_row, queen_col, n, obstacle);

        return ans;
    }

    public static int left(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, ans;

        for(i=queen_col-2, ans=0 ; i>=0 ; i--){
            if(obstacle[queen_row-1][i])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int up(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, ans;

        for(i=queen_row-2, ans=0 ; i>=0 ; i--){
            if(obstacle[i][queen_col-1])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int right(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, ans;

        for(i=queen_col, ans=0 ; i<n ; i++){
            if(obstacle[queen_row-1][i])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int down(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, ans;

        for(i=queen_row, ans=0 ; i<n ; i++){
            if(obstacle[i][queen_col-1])
                break;

            else
                ans++;
        }

        return ans;
    }

    public static int left_down(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, j, ans;

        for(i=queen_row, j=queen_col-2, ans=0 ; (i<n) && (j>=0) ; i++, j--){
            if(obstacle[i][j])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int left_up(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, j, ans;

        for(i=queen_row-2, j=queen_col-2, ans=0 ; (i>=0) && (j>=0) ; i--, j--){
            if(obstacle[i][j])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int right_up(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, j, ans;

        for(i=queen_row-2, j=queen_col, ans=0 ; (i>=0) && (j<n) ; i--, j++){
            if(obstacle[i][j])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int right_down(int queen_row, int queen_col, int n, boolean obstacle[][]){
        int i, j, ans;

        for(i=queen_row, j=queen_col, ans=0 ; (i<n) && (j<n) ; i++, j++){
            if(obstacle[i][j])
                break;
            else
                ans++;
        }

        return ans;
    }

    public static int chess2(int queen_row, int queen_col, int n, int obstacle_row[], int obstacle_col[]){
        int ans=0;

        //ans += horizontal(queen_row, queen_col, n, obstacle_row, obstacle_col);
        //ans += vertical(queen_row, queen_col, n, obstacle_row, obstacle_col);
        ans += diagonal1(queen_row, queen_col, n, obstacle_row, obstacle_col);

        return ans;
    }

    public static int horizontal (int queen_row, int queen_col, int n, int obstacle_row[], int obstacle_col[]){
        int i, j, ans=0;
        boolean flag = true;

        for(i=0 ; i<obstacle_row.length ; i++){
            if(queen_row==obstacle_row[i]){

                for(j=0 ; j<queen_col-1 ; j++){
                    if(obstacle_col[i]==j){
                        ans = queen_col-j-1;
                    }
                }

                for(j=queen_col ; j<n ; j++){
                    if(obstacle_col[i]==j){
                        ans += j-queen_col-1;
                        break;
                    }
                }

                flag = false;
                break;
            }
        }

        if(flag)
            ans = n-1;

        return ans;
    }

    public static int vertical(int queen_row, int queen_col, int n, int obstacle_row[], int obstacle_col[]){
        int i, ans, j;
        boolean flag=true;

        for(i=0, ans=0 ; i<obstacle_col.length ; i++){
            if(obstacle_col[i]==queen_col){
                for(j=0 ; j<queen_row-1 ; j++){
                    if(obstacle_row[i]==j){

                    }
                }

                flag = false;
                break;
            }
        }

        if(flag)
            ans = n-1;

        return ans;
    }

    public static int diagonal1(int queen_row, int queen_col, int n, int obstacle_row[], int obstacle_col[]) {
        int i, ans, row, col;
        boolean flag = true;

        for (i = 0, ans = 0; i < obstacle_col.length; i++) {
            for (row = queen_row - queen_col, col = 0, ans = 0; (row < queen_row) && (col < queen_col); row++, col++) {
                if ((obstacle_row[i] == row) && (obstacle_col[i] == col)) {
                    ans = queen_row - row - 1;
                    flag = false;
                }
            }
        }

        if (flag) {
            ans = queen_row - 1;
            System.out.println(ans);
        }

        for (i = 0, flag = true; i < obstacle_row.length; i++) {
            for (row = queen_row, col = queen_col ; (row < n) && (col < n); row++, col++) {
                if ((obstacle_row[i] == row) && (obstacle_col[i] == col)) {
                    ans += obstacle_row[i] - queen_row - 1;
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            ans += n-queen_row;
            System.out.println(ans);
        }

        return ans;
    }

}
