package com.hack.boyko.car;
import java.util.Scanner;

public class CarTest {
    // private static List<Car> garage = new ArrayList<>();
    private static int findCar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car cars = new Car();
        
        Garage garage = Garage.getInstance();
        Car car1 = new Car("Audi", "Quattro", 2500, 5, "Green", 2015, 250);
        Car car2 = new Car("VW", "Sharan", 2000, 5, "Blue", 2001, 200);
        Car car3 = new Car("Peugeot", "Partner", 1900, 3, "White", 2000, 180);
        garage.parkCar(car1);
        garage.parkCar(car2);
        garage.parkCar(car3);

        System.out.println("Type 1 to check the Garage or 2 to setup your own Car");
        findCar = sc.nextInt();
        Car brand = null;
        switch (findCar) {
            case 1:
                brand = garage.chooseCar();
                System.out.println("1 for gazz 2 for breaks");
                break;
            case 2:
                System.out.println(cars.SetupCar());
                System.out.println("1 for gazz 2 for breaks");
                break;
            default:

                break;
        }

        cars.drive(brand);

    }

}
