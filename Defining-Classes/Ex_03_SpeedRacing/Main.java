package Ex_03_SpeedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNumbers = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < carNumbers; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int fuel = Integer.parseInt(data[1]);
            double costFuelPerKm = Double.parseDouble(data[2]);

            Car car = new Car(model, fuel, costFuelPerKm);
            cars.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String carModelToDrive = command.split("\\s+")[1];
                    int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

                    Car carToDrive = cars.get(carModelToDrive);

                    if (!carToDrive.drive(kmToDrive)) {
                        System.out.println("Insufficient fuel for the drive");
                    }
            command = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
