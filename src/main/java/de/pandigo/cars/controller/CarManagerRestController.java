package de.pandigo.cars.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.pandigo.cars.models.car.Car;
import de.pandigo.cars.models.car.CarBuilder;
import de.pandigo.cars.persistence.CarsService;

@Api(name = "Car Management Service", description = "Methods for managing the car pool", group = "Main")
@RestController
@RequestMapping("/carManagerRestApi")
public class CarManagerRestController {

    private final Logger logger = LoggerFactory.getLogger(CarManagerRestController.class);

    @Autowired
    private CarsService carsService;

    @ApiMethod(description = "Returns all the cars from the car pool.")
    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars() {
        this.logger.debug("The list of all cars was requested");
        return this.carsService.getAllCars();
    }

    @ApiMethod(description = "Adds a car to the car pool.")
    @RequestMapping(value = "/cars/{carId}", method = RequestMethod.POST)
    public void addCar(@PathVariable final int carId) {
        this.carsService.addCar(new CarBuilder().withId(carId).build());
        this.logger.debug(String.format("Car add requested with carId: %1$d", carId));
    }

}
