package Cars;


import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<Car>();

    //add cars
    public String addCar(Car car) {
        this.cars.add(car);
        System.out.println("\n");
        return car.name + " added successfully";
    }
    //getAllCars (view cars)

    public ArrayList<Car> getAllCars() {
        return cars;
    }


    //getSingleCar (view specific car)

    public Car getSingleCar(int carID) {
        return this.cars.get(carID);
    }
    //removeCar


    public String removeCar(int carID) {
        try {
            cars.remove(carID);
        } catch (Exception ex) {
            return "Unable to remove specified car";
        }
        return "Car Removed Successfully";
    }

    public Car findByName(String name) {
        //Loop over the cars in the showroom and check each name equals to the specified name
        //Return the car if  true.
        for (Car car : cars) {
            if (car.name.equals(name)) {
                return car;
            }
        }
        return null; //
    }
    //create array list of cars of the same manufacturer name array list .

    public ArrayList<Car> findByManufacturer(String manufacturer) {
        ArrayList <Car> list = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.manufacturer.equals(manufacturer)) {
               list.add(car);
            }
        }
        return list; // in case there is nothing to return it returns nothing
    }

    public Car findByType(String type) {
        for (Car car : cars) {
            if (car.type.equals(type)) {
                return car;
            }
        }
        return null; //
    }

    public Car updateCar(int carIndex, Car car) {
        return cars.set(carIndex, car);
    }

    public Car updateCarByManufacturer(int carIndex, Car car) {
        return cars.set(carIndex, car);
    }

    public Car updateCarByType(int carIndex, Car car) {
        return cars.set(carIndex, car);
    }
}
