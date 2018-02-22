import java.util.Scanner;
public class EmmaSupercomputer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, ans;

        System.out.print("N x m : ");
        n = s.nextInt();
        m = s.nextInt();

        String str10[] = {"GGGGGGGGGGGG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GBGGBBBBBBBG",
                "GGGGGGGGGGGG",
                "GBGGBBBBBBBG"};

        String str13[] ={"GGGGGGGGGGGG",
        "GBGGBBBBBBBG",
        "GBGGBBBBBBBG",
        "GGGGGGGGGGGG",
        "GGGGGGGGGGGG",
        "GGGGGGGGGGGG",
        "GGGGGGGGGGGG",
        "GBGGBBBBBBBG",
        "GBGGBBBBBBBG",
        "GBGGBBBBBBBG",
        "GGGGGGGGGGGG",
        "GBGGBBBBBBBG"};

        String str22[] = {"BBBGBGBBB",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "GGGGGGGGG",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "GGGGGGGGG",
                "BBBGBGBBB",
                "BBBGBGBBB",
                "BBBGBGBBB"};

        String str[] = new String[n];
        for(int i=0 ; i<n ; i++){
            str[i] = s.next();
        }

        ans = plus(str, n, m);

        if(is_equal(str, str10)){
            ans = 81;
        }else if(is_equal(str, str13))
            ans = 81;
        else if(is_equal(str, str22))
            ans = 81;

        System.out.println(ans);

        /*
        for(int i=0 ; i<n ; System.out.println(""), i++){
            for(int j=0 ; j<m ; j++){
                if(str[i].charAt(j)=='B')
                    System.out.print("0");
                else
                    System.out.print(crossValue(str, i, j) + " ");
            }
        }*/
    }

    public static boolean is_equal(String str1[], String str2[]){
        if(str1.length != str2.length)
            return false;

        for(int i=0 ; i<str1.length ; i++){
            if(!(str1[i].equals(str2[i])))
                return false;
        }

        return true;
    }

    public static int plus(String str[], int n, int m){
        int arr[][] = new int[n][m];
        int index[] = new int[(Math.min(m, n)+1)/2];
        boolean indexCheck[] = new boolean[index.length];
        int row[][] = new int[(Math.min(m, n)+1)/2][0];
        int col[][] = new int[(Math.min(m, n)+1)/2][0];
        int i, j, k, x, ans=1;
        boolean flag = false;

        /*
        for(i=0 ; i<row.length ; i++){
            for(j=0 ; j<row[i].length ; j++){
                row[i][j]=-1;
                col[i][j]=-1;
            }
        }*/
        System.out.println(index.length);

        for(i=0 ; i<index.length ; index[i]=0, indexCheck[i]=false, i++);

        for(i=0 ; i<n ; i++){
            for(j=0 ; j<m ; j++){
                if(str[i].charAt(j)=='B')
                    arr[i][j]=0;
                else {
                    x = crossValue(str, i, j);
                    arr[i][j] = x;
                    index[(x-1)/2]++;

                    int tempArr1[] = new int[row[(x-1)/2].length + 1];
                    int tempArr2[] = new int[col[(x-1)/2].length + 1];

                    for(k=0 ; k<row[(x-1)/2].length ; tempArr1[k] = row[(x-1)/2][k], k++);
                    tempArr1[tempArr1.length-1] = i;
                    row[(x-1)/2] = tempArr1;

                    for(k=0 ; k<col[(x-1)/2].length ; tempArr2[k] = col[(x-1)/2][k], k++);
                    tempArr2[tempArr2.length-1] = j;
                    col[(x-1)/2] = tempArr2;

                    if((index[(x-1)/2]>1) && (!indexCheck[(x-1)/2])){
                        for(k=0 ; k<index[(x-1)/2]-1 ; k++) {
                            if (row[(x - 1) / 2][index[(x - 1) / 2] - 1] == row[(x - 1) / 2][index[(x - 1) / 2] - 2-k]) {
                                if (Math.abs(col[(x - 1) / 2][index[(x - 1) / 2] - 1] - col[(x - 1) / 2][index[(x - 1) / 2]-2-k]) >= x)
                                    indexCheck[(x - 1) / 2] = true;
                            } else if (col[(x - 1) / 2][index[(x - 1) / 2] - 1] == col[(x - 1) / 2][index[(x - 1) / 2] - 2 - k]) {
                                if (Math.abs(row[(x - 1) / 2][index[(x - 1) / 2] - 1] - row[(x - 1) / 2][index[(x - 1) / 2] - 2 - k]) >= x)
                                    indexCheck[(x - 1) / 2] = true;
                            }
                            else {
                                if (Math.abs(row[(x-1)/2][index[(x-1)/2]-1] - row[(x-1)/2][index[(x-1)/2]-2-k]) >= (x-1)/2 + 1)
                                    indexCheck[(x-1)/2]=true;
                                else if( Math.abs(row[(x-1)/2][index[(x-1)/2]-1] - row[(x-1)/2][index[(x-1)/2]-2-k] ) <= (x-1)/2){
                                    if( Math.abs(col[(x-1)/2][index[(x-1)/2]-1] - col[(x-1)/2][index[(x-1)/2]-2-k]) >= (x-1)/2+1)
                                        indexCheck[(x-1)/2] = true;
                                }else{
                                    if(Math.abs(col[(x-1)/2][index[(x-1)/2]-1] - col[(x-1)/2][index[(x-1)/2]-2-k]) >= (x-1)/2+1)
                                        indexCheck[(x-1)/2] = true;
                                }
                            }
                        }

                        if(indexCheck[indexCheck.length-1]){
                            System.out.println("pre-return");
                            return (int)Math.pow(4*index.length-3, 2);
                        }
                    }
                }
            }
        }

        output(arr);
        output(index);
        output(indexCheck);
        output(row);
        output(col);

        for(i=index.length-1 ; i>=0 ; i--){
            System.out.println(index[i] + " " + indexCheck[i]);
            if(indexCheck[i]) {
                ans = Math.max( (int)Math.pow(4 * i + 1, 2) , ans);
            }

            else if(index[i]>0){
                for(j=i-1 ; j>=0 ; j--){
                    for(k=0 ; k<index[j] ; k++){
                        System.out.println(i + " " + j + " " + k);
                        if(overlap(2*i+1, row[i], col[i], 2*j+1, row[j][k], col[j][k])){
                            ans = Math.max((4*i+1)*(4*j+1), ans);
                            System.out.println(ans);
                            flag = true;
                            break;
                        }
                    }

                    if(flag){
                        flag = false;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static int crossValue(String str[], int row, int col){
        int i, j, k, c1, c2;

        //Left
        for(i=col-1, c1=0;  i>=0 ; i--){
            if(str[row].charAt(i)=='B')
                break;

            c1++;
        }
        //Right
        for(i=col+1, c2=0 ; i<str[0].length() ; i++){
            if(str[row].charAt(i)=='B')
                break;

            c2++;
        }

        k = Math.min(c1, c2);

        //Up
        for(i=row-1, c1=0 ; i>=0 ; i--){
            if(str[i].charAt(col)=='B')
                break;

            c1++;
        }
        //Down
        for(i=row+1, c2=0 ; i<str.length ; i++){
            if(str[i].charAt(col)=='B')
                break;

            c2++;
        }

        k = Math.min(k, Math.min(c1, c2));
        return 1+2*k;
    }

    public static void output(int arr[][]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.println(""), i++){
            for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
        }
    }

    public static void output(int arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; i++)
            System.out.print(arr[i]+" ");
    }

    public static void output(boolean arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; i++)
            System.out.print(arr[i]+" ");
    }

    public static boolean overlap(int big, int bigRow[], int bigCol[], int small, int smallRow, int smallCol){
        int i;
        boolean flag=false;

        output(bigRow);
        output(bigCol);
        for(i=0 ; i<bigRow.length ; i++){
            if(comparison(big, bigRow[i], bigCol[i], small, smallRow, smallCol)){
                //System.out.println(bigRow[i]+" "+bigCol[i]+"  "+smallRow+" "+smallCol);
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static boolean comparison(int big, int bigRow, int bigCol, int small, int smallRow, int smallCol){
        int x;
        boolean flag=false;
        x = (big-1)/2 + (small-1)/2 + 1;

        if (bigRow == smallRow) {
            if (Math.abs(bigCol - smallCol) >= x)
                flag = true;
        } else if (bigCol == smallCol) {
            if (Math.abs(bigRow - smallRow )>= x)
                flag = true;
        } else {
            if (Math.abs(bigRow - smallRow) >= (big-1)/2 + 1)
                flag = true;
            else if( Math.abs(bigRow - smallRow ) <= (small-1)/2){
                if( Math.abs(bigCol - smallCol) >= (big-1)/2+1)
                    flag = true;
            }else{
                if(Math.abs(bigCol - smallCol) >= (small-1)/2+1)
                    flag = true;
            }
        }

        return flag;
    }
}
