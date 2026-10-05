import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedHashMap<String, Integer> data = new LinkedHashMap<String, Integer>();
        ArrayList<String> hasilCheck = new ArrayList<String>();
        int ditolak = 0;

        Scanner sc = new Scanner(new File("enrollment.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("")) {
                continue;
            }
            String[] p = line.split(" ");

            if (p[0].equals("REGISTER")) {
                String kode = p[1];
                int jumlah = Integer.parseInt(p[2]);
                if (jumlah <= 0) {
                    ditolak++;
                } else {
                    if (data.containsKey(kode)) {
                        int lama = data.get(kode);
                        data.put(kode, lama + jumlah);
                    } else {
                        data.put(kode, jumlah);
                    }
                }
            } else if (p[0].equals("WITHDRAW")) {
                String kode = p[1];
                int jumlah = Integer.parseInt(p[2]);
                if (jumlah <= 0) {
                    ditolak++;
                } else {
                    if (data.containsKey(kode) && data.get(kode) >= jumlah) {
                        int sisa = data.get(kode) - jumlah;
                        data.put(kode, sisa);
                    } else {
                        ditolak++;
                    }
                }
            } else if (p[0].equals("CHECK")) {
                String kode = p[1];
                if (data.containsKey(kode)) {
                    hasilCheck.add(kode + ": " + data.get(kode) + " students");
                } else {
                    hasilCheck.add(kode + ": Not found");
                }
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < hasilCheck.size(); i++) {
            System.out.println(hasilCheck.get(i));
        }
        System.out.println("===== Final Enrollment =====");
        for (String kode : data.keySet()) {
            System.out.println(kode + ": " + data.get(kode) + " students");
        }
        System.out.println("Rejected operations: " + ditolak);
    }
}
