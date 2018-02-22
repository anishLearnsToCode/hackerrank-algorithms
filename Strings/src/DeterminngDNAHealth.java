import java.util.Scanner;
public class DeterminngDNAHealth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i, strands;

        System.out.print("Genes : ");
        n = s.nextInt();

        String[] gene = new String[n];
        System.out.println("Enter gene strings : ");
        for(i=0 ; i<n ; i++){
            gene[i] = s.next();
        }

        int geneHealth[] = new int[n];
        System.out.println("Enter gene healths : ");
        for(i=0 ; i<n ; i++){
            geneHealth[i] = s.nextInt();
        }

        System.out.print("No. of DNA Strands : ");
        strands = s.nextInt();

        String dna[] = new String[strands];
        int start[] = new int[strands];
        int end[] = new int[strands];

        System.out.println("Enter DNA Strands as start end DNA : ");
        for(i=0 ; i<strands ; i++){
            start[i] = s.nextInt();
            end[i] = s.nextInt();
            dna[i] = s.next();
        }

        DNAHealth(gene, geneHealth, start, end, dna);
    }

    public static void DNAHealth(String gene[], int geneHealth[], int start[], int end[], String dna[]){

    }
}
