package de.pandigo.cars.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.pandigo.cars.models.car.Brand;
import de.pandigo.cars.models.car.Car;
import de.pandigo.cars.models.car.CarBuilder;
import de.pandigo.cars.models.stereo.JVCStereoImpl;
import de.pandigo.cars.models.stereo.KenwoodStereoImpl;

public class CarsServiceRandomMock implements CarsService {

	private final List<Car> cars = new ArrayList<>();

	public CarsServiceRandomMock() {
		this.cars.add(new CarBuilder().withBrand(Brand.randomBrand()).withKmDriven(5000).withNumberOfSeats(5)
		        .withProductionDate(LocalDate.of(2012, 4, 17)).withStereoDevice(new KenwoodStereoImpl()).build());
		this.cars.add(new CarBuilder().withBrand(Brand.randomBrand()).withKmDriven(55000).withNumberOfSeats(4)
		        .withProductionDate(LocalDate.of(2004, 1, 11)).withStereoDevice(new KenwoodStereoImpl()).build());
		this.cars.add(new CarBuilder().withBrand(Brand.randomBrand()).withKmDriven(125000).withNumberOfSeats(6)
		        .withProductionDate(LocalDate.of(2011, 4, 11)).withStereoDevice(new JVCStereoImpl()).build());
	}

	@Override
	public List<Car> getAllCars() {
		return this.cars;
	}

	@Override
	public void addCar(final Car aCar) {
		this.cars.add(aCar);
	}
}