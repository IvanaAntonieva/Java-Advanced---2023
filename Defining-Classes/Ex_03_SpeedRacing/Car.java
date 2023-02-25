package Ex_03_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double consumptionFuelPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumptionFuelPerKm = fuelCostPerOneKm;
        this.distanceTraveled = 0;
    }
    public boolean drive(int kmDrive) {
        double needFuel = kmDrive * this.consumptionFuelPerKm;
        if (needFuel <= this.fuelAmount) {
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return  true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
