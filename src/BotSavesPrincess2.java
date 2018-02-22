import java.util.Scanner;
public class BotSavesPrincess2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i, j, princessRow=0, princessCol=0, playerRow, playerCol;
        boolean flag=true;

        System.out.print("Ener Grid size : ");
        n = s.nextInt();

        String str[] = new String[n];
        for(i=0 ; i<str.length ; i++) {
            str[i] = s.next();

            if(flag) {
                for (j = 0; j < n; j++) {
                    if (str[i].charAt(j) == 'p') {
                        princessCol = j;
                        princessRow = i;
                        flag = false;
                    }
                }
            }
        }

        System.out.print("Enter player co-ordinates : ");
        playerRow = s.nextInt();
        playerCol = s.nextInt();

        princessBot(str, n, princessRow, princessCol, playerRow, playerCol);
    }

    public static void princessBot(String str[], int n, int princessRow, int princessCol, int playerRow, int playerCol){
        if(princessCol < playerCol){
            System.out.println("LEFT");
        }
        else if(princessCol > playerCol)
            System.out.println("RIGHT");
        else if(princessRow < playerRow)
            System.out.println("UP");
        else if(princessRow > playerRow)
            System.out.println("DOWN");
    }
}
