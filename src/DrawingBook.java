import java.util.Scanner;

public class DrawingBook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, page, ans;

        System.out.print("Enter total pages : ");
        n = s.nextInt();
        System.out.print("Enter page no. : ");
        page = s.nextInt();

        ans = FrontPageTurns(n, page, 1);
        System.out.println(ans);

        ans = BackPageTurns(n, page, parse(n));
        System.out.println(ans);

        ans = book(n, page);
        System.out.println(ans);
    }

    public static int FrontPageTurns(int n, int page, int CurrentPage){
        if(page <= CurrentPage){
            return 0;
        }

        return 1+ FrontPageTurns(n, page, CurrentPage+2);
    }

    public static int BackPageTurns(int n, int page, int CurrentPage){
        if(CurrentPage <= page){
            return 0;
        }

        return 1+ BackPageTurns(n, page, CurrentPage-2);
    }

    public static int parse(int n){
        int ans;

        if(n%2==0)
            ans = n+1;
        else
            ans = n;

        return ans;
    }

    public static int book(int n, int page){
        int front, back;

        front = page/2;
        back = n/2 - front;

        return Math.min(front, back);
    }
}
