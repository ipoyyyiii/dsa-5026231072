import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("rentals.txt"));
        int n = scanner.nextInt();
        Rental[] rentals = new Rental[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();
            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days, units);
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days, units);
            }
        }
        scanner.close();
        for (Rental r : rentals) {
            System.out.println(r.summary());
        }
    }
}
