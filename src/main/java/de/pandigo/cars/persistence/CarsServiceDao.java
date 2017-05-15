package de.pandigo.cars.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import de.pandigo.cars.models.car.Brand;
import de.pandigo.cars.models.car.Car;
import de.pandigo.cars.models.car.CarBuilder;
import de.pandigo.cars.models.stereo.KenwoodStereoImpl;

@Service
public class CarsServiceDao implements CarsService {

	private final List<Car> cars = new ArrayList<>();
	private static final int MAX_KM_AMOUNT = 200000;
	private static final int MIN_SEATS = 2;
	private static final int MAX_SEATS = 7;
	private static final int MIN_YEAR = 1960;
	private static final int MAX_YEAR = 2017;
	private static final int MIN_MONTH = 1;
	private static final int MAX_MONTH = 12;
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 28;

	private final Random random = new Random();

	private LocalDate randomDate() {
		return LocalDate.of(this.random.nextInt(MAX_YEAR - MIN_YEAR) + MIN_YEAR, this.random.nextInt(MAX_MONTH - MIN_MONTH) + MIN_MONTH,
		        this.random.nextInt(MAX_DAY - MIN_DAY) + MIN_DAY);
	}

	public CarsServiceDao() {
		for (int i = 1; i <= 10; i++) {
			this.cars.add(new CarBuilder()
					.withId(i)
					.withBrand(Brand.randomBrand())
					.withKmDriven(this.random.nextInt(MAX_KM_AMOUNT))
					.withNumberOfSeats(this.random.nextInt(MAX_SEATS - MIN_SEATS) + MIN_SEATS)
					.withProductionDate(randomDate())
					.withStereoDevice(new KenwoodStereoImpl())
					.build());
		}
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
