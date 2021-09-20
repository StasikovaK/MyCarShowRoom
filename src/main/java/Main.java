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
            System.out.println("\n \n \nWelcome to the showroom, please choose an activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Specific Car");
            System.out.println("4. Remove Car");
            System.out.println("5. Remove Car By Name");
            System.out.println("6. Find Car By Name");
            System.out.println("7. Find Car By Manufacturer");
            System.out.println("8. Find Car By Type");
            System.out.println("9. Update Car By Name");
            System.out.println("10. Update Car By Manufacturer");
            System.out.println("11. Update Car By Type");
            System.out.println("\nType 'Quit' to end program");

            System.out.println("Choose A Number:");
            userInput = scanner.nextLine(); //nextLine method works for Strings

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
                case "5":
                    removeCarByName();
                    break;
                case "6":
                    findCarByName();
                    break;
                case "7":
                    findCarByManufacturer();
                    break;
                case "8":
                    findCarByType();
                    break;
                case "9":
                    updateCar();
                    break;
                case "10":
                    updateCarByManufacturer();
                    break;
                case "11":
                    updateCarByType();
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
    
    //this is a comment made on the remote server and ain't yet on my machine


    //This is the second comment
    void findCarByName() {
        System.out.println("Find car by name..");
        System.out.println("Enter car name: ");

        String carName = scanner.nextLine();

        Car car = showRoom.findByName(carName);

        System.out.println("car ID: " + car.ID);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);

    }
    void findCarByManufacturer() {
        System.out.println("Find car by manufacturer..");
        System.out.println("Enter car manufacturer: ");

        String carManufacturer = scanner.nextLine();

       ArrayList<Car> list = showRoom.findByManufacturer(carManufacturer);//change this to recieve an array list of cars

        for (Car car: list) {
                    System.out.println(car.name + " \t \t \t" + car.manufacturer + " \t \t \t" + car.type);

        //
//another loop to print each car in the array list (check list all cars method
//        System.out.println("car ID: " + car.ID);
//        System.out.println("car name: " + car.name);
//        System.out.println("car manufacturer: " + car.manufacturer);
//        System.out.println("car type: " + car.type);

    }
    void findCarByType() {
        System.out.println("Find car by type..");
        System.out.println("Enter car type: ");

        String carType = scanner.nextLine();

        Car car = showRoom.findByType(carType);

        System.out.println("car ID: " + car.ID);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);

    }

    void removeCarByName() {
        System.out.println("Remove Car By Name..");
        System.out.println("Enter  Car Name:");

        String carName = scanner.nextLine();
        Car car = showRoom.findByName(carName);

        int carIndex = showRoom.getAllCars().indexOf(car);

        System.out.println(showRoom.removeCar(carIndex));
    }


        void updateCar(){
            System.out.println("Update car");
            System.out.println("Enter car name: ");
            String carName = scanner.nextLine();

            Car car = showRoom.findByName(carName);

            int carIndex = showRoom.getAllCars().indexOf(car);
            System.out.println("Enter the property you would like to change: ");
            String property = scanner.nextLine();

            System.out.println("Enter the new value of: " + property);

            String value = scanner.nextLine();

            switch (property) {
                case "name":
                    car.name = value;
                    break;
                case "manufacturer":
                    car.manufacturer = value;
                    break;
                case "type":
                    car.type = value;
                    break;
                default:
                    System.out.println("Please provide a valid property");
                    break;
            }

            showRoom.updateCar(carIndex, car);
            System.out.println(car.name + " updated successfully");

        }

//    void updateCarByManufacturer(){
//        System.out.println("Update car");
//        System.out.println("Enter car manufacturer: ");
//        String carManufacturer = scanner.nextLine();
//
//        Car car = showRoom.findByManufacturer(carManufacturer);
//
//        int carIndex = showRoom.getAllCars().indexOf(car);
//        System.out.println("Enter the property you would like to change: ");
//        String property = scanner.nextLine();
//
//        System.out.println("Enter the new value of: " + property);
//
//        String value = scanner.nextLine();
//
//        switch (property) {
//            case "name":
//                car.name = value;
//                break;
//            case "manufacturer":
//                car.manufacturer = value;
//                break;
//            case "type":
//                car.type = value;
//                break;
//            default:
//                System.out.println("Please provide a valid property");
//                break;
//        }
//
//        showRoom.updateCarByManufacturer(carIndex, car);
//        System.out.println(car.name + " updated successfully");
//    }

    void updateCarByType(){
        System.out.println("Update car");
        System.out.println("Enter car manufacturer: ");
        String carType = scanner.nextLine();

        Car car = showRoom.findByType(carType);

        int carIndex = showRoom.getAllCars().indexOf(car);
        System.out.println("Enter the property you would like to change: ");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);

        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }

        showRoom.updateCarByType(carIndex, car);
        System.out.println(car.name + " updated successfully");
    }
}
