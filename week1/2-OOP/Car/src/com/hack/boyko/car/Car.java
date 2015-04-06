package com.hack.boyko.car;
import java.util.List;
import java.util.Scanner;

public class Car {

    Scanner sc = new Scanner(System.in);
    private String brand;
    private String model;
    private int engineCapacity;
    private int numberOfDoors;
    private String color;
    private int year;
    private int maxSpeed;

    public Car() {

    }

    public Car(String brand, String model, int engineCapacity, int numberOfDoors, String color, int year, int maxSpeed) {

        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.numberOfDoors = numberOfDoors;
        this.color = color;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2000 || year > 2015) {
            System.out.println("Invalid year");

        } else {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return "brand ==> " + brand + "\nmodel ==> " + model + "\nengineCapacity ==> " + engineCapacity
                + "\nnumberOfDoors ==> " + numberOfDoors + "\ncolor ==> " + color + "\nyear ==> " + year + "\n";
    }

    public String SetupCar() {
        Garage garage = Garage.getInstance();
        System.out.println("Setup Brand ");
        setBrand(brand = sc.next());

        return brand;

    }

    public void drive(Car car) {

        boolean breaks = false;
        int speedUpDown = 0;
        int fuel = 20;
        System.out.println("Gazz");

        while (!breaks) {

            if (speedUpDown == 30) {
                System.out.printf("\nchange gear to %d    ", 3);
            } else if (speedUpDown == 60) {
                System.out.printf("\nchange gear to %d    ", 4);
            } else if (speedUpDown == 90) {

                System.out.printf("\nchange gear to %d    ", 5);
            } else if (speedUpDown == 120) {
                System.out.printf("\nchange gear to %d    ", 6);
            }

            int gazz = sc.nextInt();

            switch (gazz) {

                case 1:

                    System.out.printf("%s moves with %d km\\h", car.getBrand(), speedUpDown += 30);
                    fuel -= 2;

                    break;
                case 2:
                    if (speedUpDown > 0) {

                        System.out.printf("%s moves with %d km\\h", car.getBrand(), speedUpDown -= 30);

                    }

                    break;

                default:

                    breaks = true;
                    System.out.println("stop");
                    break;

            }
            if (fuel <= 0) {
                speedUpDown = 0;

            }
            fuel = fuelTank(fuel);
            if (speedUpDown > 200 && speedUpDown < car.getMaxSpeed()) {
                fuel -= 5;
            }
            if (speedUpDown > car.getMaxSpeed()) {
                System.out.println("\nThe safety softwear is on and the car will permanently stop ");
                while (speedUpDown > 0) {
                    System.out.println(speedUpDown -= 30);
                }

            }

        }

    }

    public int fuelTank(int fuel) {
        if (fuel == 10) {
            System.out.println();
            System.out.println("\nThe red indicator is on ");
        } else if (fuel <= 0) {
            System.out.println("\nThe fuel is over");
            System.out.println("\nReload");
            fuel = sc.nextInt();
            System.out.print("indicator");
            for (int i = 0; i < fuel; i++) {
                System.out.print("|");
            }
        }

        return fuel;

    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
