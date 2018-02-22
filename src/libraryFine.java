import java.util.Scanner;

public class libraryFine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d1, m1, y1, d2_due, m2_due, y2_due, ans;

        System.out.print("Enter book delivery date : ");
        d1 = s.nextInt();
        m1 = s.nextInt();
        y1 = s.nextInt();

        System.out.print("Enter due date : ");
        d2_due = s.nextInt();
        m2_due = s.nextInt();
        y2_due = s.nextInt();

        ans = library(d1, m1 , y1, d2_due, m2_due, y2_due);
        System.out.println(ans);
    }

    public static int library(int d, int m, int y, int d_due, int m_due, int y_due){
        int fine=0;

        if((y<=y_due) && (m<=m_due) && (d>d_due)){
            fine = 15*(d-d_due);
        }

        else if((y<=y_due) && (m>m_due)){
            fine = 500 * (m-m_due);
        }

        else if(y>y_due){
            fine = 10000;
        }

        return fine;
    }
}
