import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s, t, a, b, m, n, i, apple_count, orange_count;

        System.out.print("Apples : ");
        m=scan.nextInt();

        int apple[] = new int[m];
        System.out.println("Enter d values :-");
        for(i=0 ; i<apple.length ; i++)
            apple[i]=scan.nextInt();

        System.out.print("Oranges : ");
        n=scan.nextInt();

        int orange[] = new int[n];
        System.out.println("Enter d values :-");
        for(i=0 ; i<orange.length ; i++)
            orange[i]=scan.nextInt();

        System.out.print("Enter house coordinates : ");
        s=scan.nextInt();
        t=scan.nextInt();

        System.out.print("Enter tree coordinates (Apple, Orange) : ");
        a=scan.nextInt();
        b=scan.nextInt();


        apple_count  = fruit(s, t, a, apple);
        orange_count = fruit(s, t, b, orange);

        System.out.println(apple_count);
        System.out.println(orange_count);
    }

    public static int fruit(int position1, int position2, int tree, int distance[]){
        int i, c;

        for(i=0, c=0 ; i<distance.length ; i++){
            if(((tree+distance[i])<=position2) && ((tree+distance[i])>=position1))
                c++;
        }

        return c;
    }
}
