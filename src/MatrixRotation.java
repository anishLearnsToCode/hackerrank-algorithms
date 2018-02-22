import java.util.Scanner;
public class MatrixRotation {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int row, col, rotation, i, j;

        System.out.print("Row and Col : ");
        row = s.nextInt();
        col = s.nextInt();

        int arr[][] = new int[row][col];

        System.out.print("Rotations : ");
        rotation = s.nextInt();

        System.out.println("Enter Grid : ");
        for(i=0 ; i<row ; i++){
            for(j=0 ; j<col ; j++){
                arr[i][j] = s.nextInt();
            }
        }

        matrixRotate(arr, row, col, rotation);
    }

    public static void matrixRotate(int arr[][], int row, int col, int turns){
        int i, j, frame, cycle, frameElements;
        frame = Math.min(row, col)/2;

        for(i=0 ; i<frame ; i++){
            frameElements = 2*(row + col -4*i) - 4;
            cycle = (turns + frameElements) % (frameElements);
            System.out.println(cycle);

            for(j=0 ; j<cycle ; j++){
                rotate(arr, i);
            }
        }

        output(arr);
    }

    public static void rotate(int arr[][], int frame){
        int i, j, k;
        int temp[] = new int[4];

        temp[0] = arr[frame][frame];   //TopLeft element
        temp[1] = arr[arr.length-1-frame][frame]; //BottomLeft element
        temp[2] = arr[arr.length-1-frame][arr[0].length-1-frame];  //BottomRight Element
        temp[3] = arr[frame][arr[0].length-1-frame];  //TopRight Element

        //Top Row
        for(i=frame ; i<arr[0].length-1-frame ; arr[frame][i] = arr[frame][i+1], i++);
        output(arr);

        //Left Column
        for(i=arr.length-frame-1 ; i>frame ; arr[i][frame] = arr[i-1][frame], i--);
        output(arr);

        //Bottom Row
        for(i= arr[0].length-frame-1 ; i>frame ; arr[arr.length-1-frame][i] = arr[arr.length-1-frame][i-1], i--);
        output(arr);

        //Right Column
        for(i=frame ; i<arr.length-1-frame ; arr[i][arr[0].length-1-frame] = arr[i+1][arr[0].length-1-frame], i++);

        //Assignment
        arr[frame+1][frame] = temp[0];
        arr[arr.length-1-frame][frame+1] = temp[1];
        arr[arr.length-1-frame-1][arr[0].length-1-frame] = temp[2];
        arr[frame][arr[0].length-2-frame] = temp[3];
    }

    public static void output(int arr[][]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.println(""), i++){
            for(int j=0 ; j<arr[i].length ; System.out.print(arr[i][j]+" "), j++);
        }
    }
}