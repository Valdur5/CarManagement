package de.pandigo.cars.models.car;

import java.time.LocalDate;

import de.pandigo.cars.exceptions.CarConfigRuntimeException;
import de.pandigo.cars.models.stereo.AbstractStereo;

public class CarBuilder {

    private final Car car;
    private static final int MAX_SEATS_POSSIBLE = 10;
    private static final int MAX_KM_DRIVEN = 10000000;
    private static final LocalDate EARLIEST_PROD_DATE = LocalDate.of(1900, 1, 1);

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder withNumberOfSeats(final int numberOfSeats) {
        if(numberOfSeats < 1 && numberOfSeats > MAX_SEATS_POSSIBLE) {
            throw new CarConfigRuntimeException("The amount of seats you have chosen is not allowed.");
        }
        this.car.setSeats(numberOfSeats);
        return this;
    }

    public CarBuilder withKmDriven(final int kmDriven) {
        if(kmDriven < 0 && kmDriven > MAX_KM_DRIVEN) {
            throw new CarConfigRuntimeException("The amount of km driven makes no sense.");
        }
        this.car.setKm(kmDriven);
        return this;
    }

    public CarBuilder withBrand(final Brand brand) {
        this.car.setBrand(brand);
        return this;
    }

    public CarBuilder withProductionDate(final LocalDate productionDate) {
        if(LocalDate.now().isBefore(productionDate) || EARLIEST_PROD_DATE.isAfter(productionDate) ) {
            throw new CarConfigRuntimeException("The Date you have chosen is not possible as production date");
        }
        this.car.setProductionDate(productionDate);
        return this;
    }

    public CarBuilder withStereoDevice(final AbstractStereo stereoDevice) {
        this.car.setStereo(stereoDevice);
        return this;
    }

    public Car build() {
        return this.car;
    }
}
