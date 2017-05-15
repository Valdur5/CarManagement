package de.pandigo.cars.persistence;

import java.util.List;

import de.pandigo.cars.models.car.Car;

public interface CarsService {

    /**
     * Returns all cars from the database.
     * @return list of cars.
     */
    List<Car> getAllCars();

    void addCar(Car aCar);
}
