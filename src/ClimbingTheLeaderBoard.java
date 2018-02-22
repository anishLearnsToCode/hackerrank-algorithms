import java.util.Scanner;

public class ClimbingTheLeaderBoard {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, i;

        System.out.print("Size : ");
        size= s.nextInt();

        int score[] = new int[size];
        int rank[]  = new int[size];

        for(i=0 ; i<score.length ; i++){
            score[i] = s.nextInt();
            if(i==0)
                rank[i]=1;
            else if(score[i]==score[i-1])
                rank[i]=rank[i-1];
            else
                rank[i] = rank[i-1] + 1;
        }

        //arr_display(score);
        arr_display(rank);

        System.out.println("Enter levels crossed : ");
        size = s.nextInt();
        int arr[] = new int[size];

        for(i=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();
        }

        game(score, rank, arr);
    }

    public static void arr_display(int arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
        System.out.println("");
    }

    public static void game(int score[], int rank[], int arr[]){
        int i, j, position;

        for(i=0 ; i<arr.length ; i++){
            position = binarySearch(arr[i], score);
            System.out.println(position);


                if (score[position] == arr[i])
                    System.out.println(rank[position]);
                else if (arr[i] < score[position])
                    System.out.println(rank[position] + 1);
                else if((arr[i] > score[position]) && (rank[position]!=1))
                    System.out.println(rank[position] - 1);
                else
                    System.out.println("1");

            System.out.println("");
        }
    }

    public static int binarySearch(int element , int arr[]){
        int tail, head;

        for(tail = 0, head = arr.length ; (tail != head) && !(tail >=arr.length-1) && !(head<=0) && (Math.abs(head - tail)!=1); ){
            if(element==arr[(tail + head)/2]){
                return (tail + head)/2;
            }
            else if(element < arr[(tail + head)/2]){
                tail = (tail + head)/2;
            }
            else
                head = (tail + head)/2;
        }

        return (tail + head)/2;
    }
}
