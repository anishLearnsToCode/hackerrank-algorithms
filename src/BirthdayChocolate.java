import java.util.Scanner;

public class BirthdayChocolate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, d, i;

        System.out.print("Size : ");
        n=s.nextInt();

        int chocolate[] = new int[n];

        for(i=0 ; i<chocolate.length ; i++){
            chocolate[i]=s.nextInt();
        }

        System.out.print("Month : ");
        m=s.nextInt();
        System.out.print("Day : ");
        d=s.nextInt();

        System.out.println(birthday(chocolate, m, d));
    }

    public static int birthday(int chocolate[], int month , int day){
        int i, j, ans, sum;

        if(chocolate.length<month)
            ans = 0;

        else{
            for(i=0, ans=0 ; i<chocolate.length ; i++){
                for(j=i, sum=0 ; (j<month+i) && (j<chocolate.length) ; j++){
                    sum += chocolate[j];
                }
                if(sum==day)
                    ans++;
            }
        }

        return ans;
    }
}
