import java.util.Scanner;

public class ACM_ICPC_TEAM {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size, m, i, j, c;

        System.out.print("Enter no. of peoplle : ");
        size = s.nextInt();

        String str[] = new String[size];

        System.out.print("\nEnter no. of subjects : ");
        m = s.nextInt();

        for (i=0 ; i<size ; i++) {
            str[i] = s.next();
        }

        int answer[] = maxAcmTeams(str, m, str.length);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] maxAcmTeams(String[] people, int subjects, int contestants) {
        int answer[] = new int[] {0, 0}, currentAbility;

        for (int team1=0 ; team1 < contestants - 1 ; team1++) {
            for (int team2=team1+1 ; team2 < contestants ; team2++) {
                currentAbility = maxAbility(people[team1], people[team2], subjects);
                if (currentAbility > answer[0]) {
                    answer[0] = currentAbility;
                    answer[1] = 1;
                } else if (currentAbility == answer[0] ) {
                    answer[1]++;
                }
            }
        }
        return answer;
    }

    private static int maxAbility(String firstTeam, String secondTeam, int subjects) {
        int answer = 0;
        for (int index=0 ; index < subjects ; index++) {
            answer += number(firstTeam.charAt(index)) | number(secondTeam.charAt(index));
        }
        return answer;
    }

    private static int number(char character) {
        return (int)character - 48;
    }

    public static int team(String str[], int position, int n, int m){
        int i;

        if(position == str.length-2){
            for(i=0 ; i<m ; i++){
            }
        }
        return 1;
    }
}