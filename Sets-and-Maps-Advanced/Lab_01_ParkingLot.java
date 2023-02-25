import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab_01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String inOrOut = input.split(",\\s+")[0];
            String car = input.split(",\\s+")[1];
            if (inOrOut.equals("IN")) {
                parkingLot.add(car);
            } else {
                parkingLot.remove(car);
            }
            input = scanner.nextLine();
        }
            if (parkingLot.isEmpty()) {
                System.out.println("Parking Lot is Empty");
            } else {
                for (String carInTheParkingLot : parkingLot) {
                    System.out.println(carInTheParkingLot);
            }
        }
    }
}
