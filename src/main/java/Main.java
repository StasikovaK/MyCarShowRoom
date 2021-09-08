import Cars.Car;
import Cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();
    }
    void showMenu(){

        String userInput = "";

        do {
            System.out.println("\nWelcome to the showroom, please choose an activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Specific Car");
            System.out.println("4. Remove Car");
            System.out.println("\nType 'Quit' to end program");

            System.out.println("Choose A Number:");
            userInput = scanner.nextLine();
            //next line method works for Strings

            switch(userInput) {
                case "Quit":
                    System.out.println("Exiting Application...");
                    break;
                case "1":
                    //add car
                   addCar();
                   break;
                case "2":
                   //view all cars
                    viewAllCars();
                       break;
                case "3":
                    //view specific car
                    getSingleCar();
                    break;
                case "4":
                    //remove car
                    removeCar();
                    break;
                default:
                    break;
            }

        } while (!userInput.equalsIgnoreCase("Quit")); // while userInput is npt "quit" code continues to run and show the menu

        return;
    }

    void addCar(){

        System.out.println("Add Car");

        Car car = new Car();
        System.out.println("Enter Name: ");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer: ");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type: ");
        car.type = scanner.nextLine();

        car.ID = UUID.randomUUID();

        String message = showRoom.addCar(car);

        System.out.println(message);
    }

    void viewAllCars(){
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll Available Cars\n");
        System.out.println("Car Name\t Manufacturer\t Car Type");
        for (Car car: allCars) {
            System.out.println(car.name + " \t \t \t" + car.manufacturer + " \t \t \t" + car.type);
        }
    }

    void getSingleCar() {

        System.out.println("Please enter the car's ID: ");
        int carID = scanner.nextInt();

        Car car = showRoom.getSingleCar(carID);
        System.out.println("Car Number: " + car.ID);
        System.out.println("Car Name: " + car.name);
        System.out.println("Car Manufacturer: " + car.manufacturer);
        System.out.println("Car Type: " + car.type);


    }

    void removeCar() {
        //input to enter ID of the car for removal

        System.out.println("Please enter the ID of the car you want to remove: ");
        int carID = scanner.nextInt();

        String message = showRoom.removeCar(carID);
        System.out.println(message);

    }
}
