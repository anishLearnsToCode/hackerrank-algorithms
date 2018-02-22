import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        str = s.nextLine();

        System.out.println(str.substring(str.length()));
        System.out.println(str.substring(str.length()-1, str.length()));
    }
}
