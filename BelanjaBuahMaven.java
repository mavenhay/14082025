import java.util.ArrayList;
import java.util.Scanner;

public class BelanjaBuahMaven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
            !JUAL BELI BUAH DI SINI HANYA SEBATAS SIMULASI, JADI UANGNYA TIDAK TERBATAS!

            Modifikasi Toko Buah (Penjual) 
            Ketik 'selesai' dan enter di bagian masukkan nama buah, jika modifikasi sudah cukup
            Tambahkan buah di toko minimal 1 buah\n""");
        ArrayList<String> buahs = new ArrayList<>();
        ArrayList<Double> hargas = new ArrayList<>();
        ArrayList<Integer> stoks = new ArrayList<>();
        ArrayList<Integer> jumlahs = new ArrayList<>();
        ArrayList<String> buahb = new ArrayList<>();
        ArrayList<Double> hargab = new ArrayList<>();

        String buah= "", nama= "", selesai="", pp;
        Double harga=0.0, kembalian=0.0, total=0.0, bayar;
        Integer stok=0, x=0, jumlah=0;
        
        while (!buah.equalsIgnoreCase("selesai")) {
            System.out.println("Masukkan nama buah:");
            buah = input.nextLine();
            if (buah=="") {
                System.out.println("Tulisan kosong");
                continue;
            } else if (buahs.contains(buah)) {
                System.out.println("Buah yang ditambahkan sudah tersedia di toko");
                continue;
            } else if (buah.equalsIgnoreCase("selesai")){
                if (buahs.isEmpty()) {
                    System.out.println("Toko masih kosong, tambahkan minimal 1 buah");
                }
                continue;
            } else {
                buahs.add(buah.toLowerCase());
                nama = buahs.get(x);
            }
            System.out.println("Masukkan harga "+nama+":");
            harga = input.nextDouble();
            hargas.add(harga);
            System.out.println("Masukkan jumlah stok "+nama+":");
            stok = input.nextInt();
            stoks.add(stok);
            System.out.println("\n========================");
            for (String i:buahs) {
                System.out.println((buahs.indexOf(i)+1)+". "+i.substring(0,1).toUpperCase()+i.substring(1) +", harga = Rp"+hargas.get(buahs.indexOf(i))+", stok = "+stoks.get(buahs.indexOf(i)));
            }
            System.out.println("========================\n");
            System.out.println("...");
            pp = input.nextLine();
            x++;
        }
 
        System.out.println("""
            Beli buah yang diperlukan minimal 1 buah (Pembeli) 
            Ketik 'selesai' dan enter di bagian masukkan nama buah, jika merasa buah yang dibeli sudah cukup""");

        while (!nama.equals("selesai")) {
            System.out.println("\n========================");
            System.out.println("Buah yang tersedia:");
            for (String i:buahs) {
                System.out.println((buahs.indexOf(i)+1)+". "+i.substring(0,1).toUpperCase()+i.substring(1) +", harga = Rp"+hargas.get(buahs.indexOf(i))+", stok = "+stoks.get(buahs.indexOf(i)));
            }
            System.out.println("========================\n");
            System.out.println("Masukkan nama buah yang ingin dibeli");
            nama = input.next();
            nama = nama.toLowerCase();
            if (nama.equals("")) {
                System.out.println("Tulisan kosong");
                continue;
            } else if (!buahs.contains(nama)){
                System.out.println("Buah tidak tersedia");
                continue;
            } else {
                System.out.println("Masukkan jumlah "+nama+" yang ingin dibeli");
                jumlah=input.nextInt();
                if (jumlah > stoks.get(buahs.indexOf(nama))){
                    System.out.println("Stok kurang atau habis");
                    continue;
                }
                if (buahb.contains(nama)) {
                    jumlahs.set(buahb.indexOf(nama), jumlahs.get(buahb.indexOf(nama))+jumlah);
                } else {
                    jumlahs.add(jumlah);
                }
                
                buahb.add(nama);
                
                stoks.set(buahs.indexOf(nama), stoks.get(buahs.indexOf(nama))-jumlah);
            }
            
        }
        for (int i=0; i<buahb.size();i++) {
            System.out.println((i+1)+". "+buahb.get(i).substring(0,1).toUpperCase()+buahb.get(i).substring(1)+", "+jumlahs.get(i)+" X "+hargab.get(i)+" = "+(jumlahs.get(i)*hargab.get(i)));
            total+= hargab.get(i)*jumlahs.get(i);
            
        }
        System.out.println("Total: Rp"+total+"\n");
        while(true){
            System.out.println("Masukkan pembayaran:");
            bayar = input.nextDouble();
            if (bayar < total) {
                System.out.println("Maaf pembayaran tidak cukup");
                System.out.println("(Masukkan nominal yang sesuai atau lebih dari total harga yang ditentukan)");
            } else {
                kembalian= bayar-total;
                System.out.println("Kembalian: "+kembalian);
                System.out.println("Terima kasih telah berbelanja di toko kami!");
                break;
            }
        }
    }
}
