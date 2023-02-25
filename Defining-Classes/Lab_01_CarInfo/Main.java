package Lab_01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carBrand = carInfo[0];
            String carModel = carInfo[1];
            int hp = Integer.parseInt(carInfo[2]);
            Car currentCar = new Car(carBrand, carModel, hp);
            carList.add(currentCar);
        }
        for (Car car : carList) {
            System.out.println(car.carInfo());
        }
    }
}
