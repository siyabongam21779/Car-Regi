package com.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int menuOption;

        System.out.println("🚗 Welcome to the Vehicle Registration App!");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("(1) Capture vehicle details");
            System.out.println("(2) View vehicle report");
            System.out.println("(3) Search for vehicle by VIN");
            System.out.println("(4) Delete a vehicle by VIN");
            System.out.println("(5) Exit app");
            System.out.print("Your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.next();
            }
            menuOption = input.nextInt();

            switch (menuOption) {
                case 1:
                    Car carObj = new Car();

                    System.out.print("Enter make: ");
                    String make = input.next();

                    System.out.print("Enter model: ");
                    String model = input.next();

                    String vinNum;
                    do {
                        System.out.print("Enter VIN (17 characters): ");
                        vinNum = input.next();
                    } while (vinNum.length() != 17);

                    System.out.print("Enter plate number: ");
                    String plateNum = input.next();

                    System.out.print("Enter mileage: ");
                    int mileage = input.nextInt();

                    System.out.print("Enter year: ");
                    int year = input.nextInt();

                    carObj.setMake(make);
                    carObj.setModel(model);
                    carObj.setVin(vinNum);
                    carObj.setPlateNumber(plateNum);
                    carObj.setMillage(mileage);
                    carObj.setYear(year);

                    cars.add(carObj);
                    System.out.println("✅ Vehicle registered successfully!");
                    break;

                case 2:
                    if (cars.isEmpty()) {
                        System.out.println("No vehicles have been captured yet.");
                    } else {
                        System.out.println("\n📋 Vehicle Report (" + cars.size() + " total):");
                        for (Car car : cars) {
                            System.out.println(car);
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter VIN to search: ");
                    String searchVin = input.next();
                    boolean found = false;
                    for (Car car : cars) {
                        if (car.getVin().equalsIgnoreCase(searchVin)) {
                            System.out.println("\n✅ Vehicle found:");
                            System.out.println(car);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("🚫 No vehicle found with that VIN.");
                    break;

                case 4:
                    System.out.print("Enter VIN to delete: ");
                    String deleteVin = input.next();
                    boolean removed = cars.removeIf(car -> car.getVin().equalsIgnoreCase(deleteVin));
                    if (removed) {
                        System.out.println("✅ Vehicle removed successfully.");
                    } else {
                        System.out.println("🚫 No vehicle found with that VIN.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Thanks for using the app. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        } while (menuOption != 5);

        input.close();
    }
}
