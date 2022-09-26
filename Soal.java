import java.util.Scanner;

public class Soal{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n,i,j;

        System.out.print("Masukkan nilai n : ");
        n = inp.nextInt();

        for (i=1; i<=n; i++){
            for(j=n-1; j>=i; j--) {
                System.out.print(" ");
            }
            for(j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}