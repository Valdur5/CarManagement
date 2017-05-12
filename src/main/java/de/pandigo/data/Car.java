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
package de.pandigo.data;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.time.LocalDate;

@ApiObject(name="Car", description = "That is a rather simple car.")
public class Car implements Serializable{

    private static final long serialVersionUID = -2643637573568965735L;

    @ApiObjectField(description = "The amount of seats available in the car.", required = true)
    private int seats;
    @ApiObjectField(description = "The brand of the car.", required = true)
    private Brand brand;
    @ApiObjectField(description = "The date when the car was produced.", required = true)
    private LocalDate productionDate;
    @ApiObjectField(description = "The actual kilometer count of the car.", required = true)
    private int km;

    public Car(int seats, Brand brand, LocalDate productionDate, int km) {
        this.seats = seats;
        this.brand = brand;
        this.productionDate = productionDate;
        this.km = km;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
