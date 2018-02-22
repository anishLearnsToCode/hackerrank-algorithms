import java.util.Scanner;

public class LisaWorkbook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int chapter, problem, i, ans;

        System.out.print("Chapters : ");
        chapter = s.nextInt();
        System.out.print("Problems : ");
        problem = s.nextInt();

        int arr[] = new int[chapter];

        for(i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);

        ans = specialPages(arr, problem);
        System.out.println(ans);
    }

    public static int specialPages(int arr[], int problem){
        int chapterPage, pagesCovered, page, firstIndex, lastIndex, i, j, counter;

        for(i=0, counter=0, pagesCovered=0 ; i<arr.length ;pagesCovered += chapterPage, i++){
            chapterPage = ceil(arr[i], problem);
            //System.out.println(chapterPage);

            for(j=0 ; j<chapterPage ; j++){
                page = pagesCovered + j + 1;

                if(page < j*problem + 1)
                    break;

                firstIndex = j*problem + 1;
                if(arr[i] < j*problem + problem)
                    lastIndex = arr[i];
                else
                    lastIndex = j*problem + problem;

                if((page >= firstIndex) && (page <= lastIndex )){
                    counter++;
                    //System.out.println(page);
                }
            }
        }

        return counter;
    }

    public static int ceil(int n, int m){
        int ans;

        if(n%m == 0)
            ans = n/m;
        else
            ans = n/m + 1;

        return ans;
    }
}
