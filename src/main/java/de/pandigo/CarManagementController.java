//@formatter:off
/**
 * $$Id$$
 * . * .
 * * RRRR  *    Copyright (c) 2016 EUIPO: European Union Intellectual
 * .   RR  R   .  Property Office (trade marks and designs)
 * *   RRR     *
 * .  RR RR  .   ALL RIGHTS RESERVED
 * * . _ . *
 */
//@formatter:on
package de.pandigo;

import de.pandigo.data.Brand;
import de.pandigo.data.Car;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Api(name = "Car Management Service", description = "Methods for managing the car pool", group = "Main")
@RestController
@RequestMapping("/carManager")
public class CarManagementController {

    private final Logger logger = LoggerFactory.getLogger(CarManagementController.class);

    @ApiMethod(description = "Returns all the cars from the car pool.")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars() {
        logger.debug("The list of all cars was requested");
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(4, Brand.randomBrand(), LocalDate.of(2005,04,17),112000));
        cars.add(new Car(6, Brand.randomBrand(), LocalDate.of(2015,11,11),42000));
        cars.add(new Car(5, Brand.randomBrand(), LocalDate.of(2011,02,12),222000));
        return cars;
    }

    @ApiMethod(description = "Returns a random car from the pool of cars.")
    @RequestMapping(value = "/randomCar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Car getRandomCar() {
        logger.debug("Random Car Requested");
        return new Car(4, Brand.randomBrand(), LocalDate.of(2005,04,17),112000);
    }

}
