package com.hack.boyko.car;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Garage {
    private Map<Integer, Car> garage = new HashMap<Integer, Car>();
    private static Garage g = new Garage();
    private Scanner sc = new Scanner(System.in);
    int counter = 1;

    public Garage() {

    }

    public static Garage getInstance() {
        return g;
    }

    public void parkCar(Car car) {

        garage.put(counter++, car);
    }

    public Car chooseCar() {

        for (Car car : garage.values()) {
            System.out.println(car.toString());
        }
        System.out.println("Choose car for test");
        int key = sc.nextInt();
        Car car = (Car) garage.get(key);

        return car;
    }

}
