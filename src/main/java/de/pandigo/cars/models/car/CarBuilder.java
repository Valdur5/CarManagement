package de.pandigo.cars.models.car;

import java.time.LocalDate;

import de.pandigo.cars.models.stereo.AbstractStereo;

public class CarBuilder {

    private final Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    public CarBuilder withNumberOfSeats(final int numberOfSeats) {
        this.car.setSeats(numberOfSeats);
        return this;
    }

    public CarBuilder withKmDriven(final int kmDriven) {
        this.car.setKm(kmDriven);
        return this;
    }

    public CarBuilder withBrand(final Brand brand) {
        this.car.setBrand(brand);
        return this;
    }

    public CarBuilder withProductionDate(final LocalDate productionDate) {
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
