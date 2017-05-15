package de.pandigo.cars.models.car;

import java.io.Serializable;
import java.time.LocalDate;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import de.pandigo.cars.models.stereo.AbstractStereo;


@ApiObject(name = "Car", description = "That is a rather simple car.")
public class Car implements Serializable {

	private static final long serialVersionUID = -2643637573568965735L;

	@ApiObjectField(description = "The id of the car.", required = true)
	private int carId;
	@ApiObjectField(description = "The amount of seats available in the car.", required = true)
	private int seats;
	@ApiObjectField(description = "The brand of the car.", required = true)
	private Brand brand;
	@ApiObjectField(description = "The date when the car was produced.", required = true)
	private LocalDate productionDate;
	@ApiObjectField(description = "The actual kilometer count of the car.", required = true)
	private int km;
	@ApiObjectField(description = "The stereo playing device which is used in the car.")
	private AbstractStereo stereo;


	public int getId() {
		return this.carId;
	}

	void setId(final int carId) {
		this.carId = carId;
	}

	public AbstractStereo getStereo() {
		return this.stereo;
	}

	void setStereo(final AbstractStereo stereo) {
		this.stereo = stereo;
	}

	public int getSeats() {
		return this.seats;
	}

	void setSeats(final int seats) {
		this.seats = seats;
	}

	public Brand getBrand() {
		return this.brand;
	}

	void setBrand(final Brand brand) {
		this.brand = brand;
	}

	public LocalDate getProductionDate() {
		return this.productionDate;
	}

	void setProductionDate(final LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	public int getKm() {
		return this.km;
	}

	void setKm(final int km) {
		this.km = km;
	}
}
