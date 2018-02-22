import java.util.Scanner;
public class BotSavesPrincess {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;

        System.out.print("Grid : ");
        n = s.nextInt();

        String str[]= new String[n];

        for(int i=0 ; i<n ; i++){
            str[i]=s.next();
        }

        princessBot(str);
    }

    public static void princessBot(String str[]){
        int knight[] = new int[2];
        int damsel[] = new int[2];
        int i, j;

        for(i=0 ; i<str.length ; i++){
            for(j=0 ; j<str[0].length() ; j++){
                if(str[i].charAt(j)=='m'){
                    knight[0] = i;
                    knight[1] = j;
                }
                if(str[i].charAt(j)=='p'){
                    damsel[0] = i;
                    damsel[1] = j;
                }
            }
        }

        //Coloumn
        for(i=0 ; i<Math.abs(knight[0] - damsel[0]) ; i++){
            if(knight[0] > damsel[0])
                System.out.println("UP");
            else
                System.out.println("DOWN");
        }
        //Row
        for(i=0 ;i<Math.abs(knight[1] - damsel[1]) ; i++){
            if(knight[1] > damsel[1])
                System.out.println("LEFT");
            else
                System.out.println("RIGHT");
        }
    }
}
