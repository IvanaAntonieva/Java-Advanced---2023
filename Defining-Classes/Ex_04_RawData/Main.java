package Ex_04_RawData;

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());

        HashMap<String, List<Car>> carsByCargoType = new LinkedHashMap<>();

        while (countCars-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tireList = new ArrayList<>();
            for (int tire = 5; tire <= 12 ; tire += 2) {
                Tire currentTire = new Tire(Double.parseDouble(carData[tire]), Integer.parseInt(carData[tire+1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            carsByCargoType.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargoType.get(cargoType).add(currentCar);
        }
        String command = scanner.nextLine();
        carsByCargoType.get(command).forEach(car -> car.extract(command));
    }
}
