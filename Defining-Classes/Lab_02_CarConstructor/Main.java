package Lab_02_CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String brand = info[0];
            String model = "unknown";
            int hp = -1;
            if (info.length == 3) {
                model = info[1];
                hp = Integer.parseInt(info[2]);
            } else if (info.length == 2) {
                if (Character.isDigit(info[1].charAt(0))) {
                    hp = Integer.parseInt(info[1]);
                } else {
                    model = info[1];
                }
            }
            Car currentCar = new Car(brand, model, hp);
            carList.add(currentCar);
        }
        for (Car car : carList) {
            System.out.println(car.carInfo());
        }
    }
}

