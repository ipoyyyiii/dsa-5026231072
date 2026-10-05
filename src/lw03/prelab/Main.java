import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Problem 1 : playlist pakai List
        ArrayList<String> playlist = new ArrayList<String>();
        Scanner sc1 = new Scanner(new File("playlist.txt"));
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            if (line.equals("")) {
                continue;
            }
            String[] parts = line.split(" ", 3);
            if (parts[0].equals("ADD")) {
                String lagu = parts[1];
                if (parts.length > 2) {
                    lagu = parts[1] + " " + parts[2];
                }
                playlist.add(lagu);
            } else if (parts[0].equals("INSERT")) {
                int idx = Integer.parseInt(parts[1]);
                String lagu = parts[2];
                playlist.add(idx, lagu);
            } else if (parts[0].equals("REMOVE")) {
                String lagu = parts[1];
                if (parts.length > 2) {
                    lagu = parts[1] + " " + parts[2];
                }
                playlist.remove(lagu);
            }
        }
        sc1.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        // Problem 2 : peserta pakai Set
        LinkedHashSet<String> peserta = new LinkedHashSet<String>();
        int duplikat = 0;
        Scanner sc2 = new Scanner(new File("participants.txt"));
        while (sc2.hasNextLine()) {
            String nama = sc2.nextLine();
            if (nama.equals("")) {
                continue;
            }
            if (peserta.contains(nama)) {
                duplikat++;
            } else {
                peserta.add(nama);
            }
        }
        sc2.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + peserta.size());
        int no = 1;
        for (String nama : peserta) {
            System.out.println(no + ". " + nama);
            no++;
        }
        System.out.println("Duplicate registrations: " + duplikat);

        // Problem 3 : inventory pakai Map
        LinkedHashMap<String, Integer> stok = new LinkedHashMap<String, Integer>();
        int gagal = 0;
        Scanner sc3 = new Scanner(new File("inventory.txt"));
        while (sc3.hasNext()) {
            String tipe = sc3.next();
            String barang = sc3.next();
            int jumlah = sc3.nextInt();

            if (tipe.equals("ADD")) {
                if (stok.containsKey(barang)) {
                    int lama = stok.get(barang);
                    stok.put(barang, lama + jumlah);
                } else {
                    stok.put(barang, jumlah);
                }
            } else if (tipe.equals("SELL")) {
                if (stok.containsKey(barang) && stok.get(barang) >= jumlah) {
                    int sisa = stok.get(barang) - jumlah;
                    stok.put(barang, sisa);
                } else {
                    gagal++;
                }
            }
        }
        sc3.close();

        System.out.println("===== Problem 3 =====");
        for (String barang : stok.keySet()) {
            System.out.println(barang + ": " + stok.get(barang));
        }
        System.out.println("Failed sales: " + gagal);
    }
}
