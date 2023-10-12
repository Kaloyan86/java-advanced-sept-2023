package iterators_and_comparators.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car bmw = new Car("BMW", 250);
        Car bmwDuplicate = new Car("BMW", 250);
        Car opel = new Car("Opel", 105);
        Car kia = new Car("KIA", 100);
        Car honda = new Car("HONDA", 180, "2020");

        Garage garage = new Garage(new Car[] {bmw, opel, kia, honda});

        //        System.out.println(CarComparator.carComparator.compare(bmw, bmwDuplicate));

        //        for (Car car : garage) {
        //            System.out.println(car);
        //        }

        garage.forEach(System.out::println);


    }
}
