package Cars;

import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<Car>();

    //add cars
    public String addCar(Car car){
        this.cars.add(car);
        return car.name + " added successfully";
    }
    //getAllCars (view cars)

    public ArrayList<Car> getAllCars() {
        return cars;
    }


    //getSingleCar (view specific car)

    public Car getSingleCar (int carID) {
        return this.cars.get(carID);
    }
    //removeCar



    public String removeCar(int carID){
        try{
            cars.remove(carID);
        } catch (Exception ex) {
            return "Unable to remove specified car";
        }
        return "Car Removed Successfully";
    }
}
