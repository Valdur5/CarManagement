package de.pandigo.cars.models.car;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Brand {
	Toyota, BMW, Audi, Mercedes, VW;

	private static final List<Brand> VALUES = Arrays.asList(values());

	public static Brand randomBrand() {
		return VALUES.get(new Random().nextInt(VALUES.size()));
	}
}
