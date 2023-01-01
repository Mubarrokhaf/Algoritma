import java.util.Scanner;
public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        System.out.println("Silahkan tambah data");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan NIM = ");
        String nim = scan.nextLine();
        System.out.print("Masukan Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData = jumlahData + 1;
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNim()+"  "+mahasiswa[i].getNama());
            i++;
        }
    }

    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. BUBBLE SORT");
        System.out.println("4. QUICK SORT");
        System.out.println("5. SHELL SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
                break;
            }
            case 4: {
                quickSort(mahasiswa, 0, jumlahData-1);
                break;
            }
            case 5: {
                shellSort();
                break;
            }
        }
    }

    public static void cariData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih metode cari data");
        System.out.println("1. LINEAR SEARCH");
        System.out.println("2. BINARY SEARCH");
        System.out.print("PILIH SEARCH = ");
        int search = scanner.nextInt();
        switch (search) {
            case 1: {
                linearSearch();
                break;
            }
            //case 2: {
                //binarySearch();
                //break;
            //}
        }
    }

    public static void editData() {
        Scanner edit = new Scanner(System.in);
        int x = 0;
        while (x<jumlahData){
            System.out.print(x+1+ ". ");
            System.out.println(mahasiswa[x].getNim() + " " + mahasiswa[x].getNama());
            x++;
        }
        System.out.print("Masukan Nomer Yang Akan Diubah = ");
        int data = edit.nextInt() - 1;
        System.out.print("Masukan NIM Baru = ");
        String nim = edit.next();
        System.out.print("Masukan Nama Baru = ");
        String nama = edit.next();

        mahasiswa[data].setNama(nama);
        mahasiswa[data].setNim(nim);
    }

    public static void hapusData() {
        Scanner hapus = new Scanner(System.in);
        int x = 0;
        int y;
        while (x<jumlahData){
            System.out.print(x +1 + ". ");
            System.out.println(mahasiswa[x].getNim() + " " + mahasiswa[x].getNama());
            x++;
        }
        System.out.print("Masukan Data Yang Akan Dihapus = ");
        int data = hapus.nextInt() - 1;

        System.out.println("Nim : "+mahasiswa[data].getNim());
        System.out.println("Nama: "+mahasiswa[data].getNama());
        System.out.println("Hapus Data ini? y/n");
        String pilihan= hapus.next();
        if(pilihan.equalsIgnoreCase("y")){
            mahasiswa[data]=null;
            for(x=0;x<jumlahData-1;x++){
                Mahasiswa temp;
                if(mahasiswa[x]==null){
                    temp=mahasiswa[x+1];
                    mahasiswa[x]=mahasiswa[x+1];
                    mahasiswa[x+1]=null;
    
                }
            }
            jumlahData=jumlahData-1;
    
            System.out.println("Data Terhapus!");
        }
        else{
    
        }
    }

    public static void uas(){
        if(jumlahData == 0){ 
            System.out.println("Tidak ada data");
        }else{ //O(1)
            int jarak = jumlahData - 1;
            int susut = 13;
            int urut = 0;
            while(urut == 0){ 
                jarak = (jarak*10)/susut;
                if(jarak <= 1){ 
                    jarak = 1;
                    urut = 1;
                    for(int i=0;i+jarak<jumlahData;i++){ 
                        int temp2 = Integer.parseInt(mahasiswa[i].getNim());
                        int temp3 = Integer.parseInt(mahasiswa[i+jarak].getNim());
                        if(temp2 >(temp3)){ 
                            Mahasiswa temp = mahasiswa[i];
                            mahasiswa[i] = mahasiswa[i+jarak];
                            mahasiswa[i+jarak] = temp;
                            urut = 0;
                        }
                    }
                }
            }
                System.out.println("Data telah diurutkan silahkan tampilkan data");
            }
        }

    public static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim().compareTo(arr[low].getNim())<=-1)
                swap(arr, ++p, j);
    
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void exchangeSort() {
        for (int x = 0; x<jumlahData; x++) {
            for (int y = x+1; y<jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim())>=1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void bubbleSort() {
        for (int x = 0; x < jumlahData - 1; x++) {
            for (int y = 0; y < jumlahData - x - 1; y++) {
                if (mahasiswa[y].getNim().compareTo(mahasiswa[y + 1].getNim())>1) {
                    Mahasiswa temp = mahasiswa[y];
                    mahasiswa[y] = mahasiswa[y + 1];
                    mahasiswa[y + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for (int x = 0; x < jumlahData-1; x++) {
            // Find the minimum element in unsorted array
            int min_idx = x;
            for (int y = x+1; y < jumlahData; y++) {
                if (mahasiswa[min_idx].getNim().compareTo(mahasiswa[y].getNim())>=1) {
                    min_idx = y;
 
                // Swap the found minimum element with the first
                // element
                    Mahasiswa temp = mahasiswa[min_idx];
                    mahasiswa[min_idx] = mahasiswa[x];
                    mahasiswa[x] = temp;
                }
            }
        }
    }

    public static void shellSort() {
        for (int interval = jumlahData / 2; interval > 0; interval /= 2) {
            for (int x = interval; x < jumlahData; x += 1) {
                Mahasiswa temp = mahasiswa[x];
                int y;
                for (y = x; y >= interval && mahasiswa[y - interval].getNim().compareTo(mahasiswa[x].getNim())>=1; y -= interval) {
                    mahasiswa[y] = mahasiswa[y - interval];
                }
                mahasiswa[y] = temp;
            }
        }
    }

    public static void linearSearch(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama/NIM = ");
        String data = scan.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            String temp = mahasiswa[i].getNama();
            String temp2 = mahasiswa[i].getNim();
            if (data.equals(temp)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
                System.out.println(" ");
            }
            else if (data.equals(temp2)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
                System.out.println(" ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();
            if (menu==1) {
                tambahData();
            } else if (menu==2) {
                tampilData();
            } else if (menu==3) {
                urutkanData();
            } else if (menu==4) {
                cariData();
            } else if (menu==5) {
                editData();
            } else if (menu==6) {
                hapusData();
            } else if (menu==7) {
                uas();
            }
        } while (menu!=8);
    }
}