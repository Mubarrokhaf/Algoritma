import java.util.Scanner;

public class Percabangan{
    public static void main(String[] args){
        String nama;
        int nilai;
        String keterangan;
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan nama : ");
        nama = inp.nextLine();
        System.out.print("Masukkan nilai : ");
        nilai = inp.nextInt();

        if (nilai >= 60) {
            keterangan= "Lulus";
        }else {
            keterangan= "Tidak Lulus";
        }

        System.out.print("Keterangan : " + keterangan);
    }
}