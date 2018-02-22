import java.util.Scanner;

public class ElectronicsShop {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int money, size, ans;

        System.out.print("Total Money : ");
        money = s.nextInt();

        System.out.print("Keyboards : ");
        size = s.nextInt();
        int keyboard[] = new int[size];
        arr_input(keyboard);

        System.out.print("Drives : ");
        size = s.nextInt();
        int drive[] = new int[size];
        arr_input(drive);

        ans = spent(money, keyboard, drive);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i]=s.nextInt(), i++);
    }

    public static int spent(int money, int keyboard[], int drive[]){
        int i, j, ans, k;

        for(i=0, k=0 ; i<keyboard.length ; i++){
            if(keyboard[i]>money)
                continue;

            for(j=0 ; j<drive.length ; j++){
                if((drive[j]+keyboard[i])>money)
                    continue;

                if((drive[j]+keyboard[i])>k)
                    k=drive[j]+keyboard[i];
            }
        }

        if(k==0)
            ans = -1;
        else
            ans = k;

        return ans;
    }
}
