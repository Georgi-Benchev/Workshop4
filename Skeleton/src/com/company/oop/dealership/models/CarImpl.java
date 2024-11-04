package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {

    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!", CAR_SEATS_MIN, CAR_SEATS_MAX);


    private int seats;

    public CarImpl(String make, String model, double price, int seats) {

        super(make, model, price);
        setSeats(seats);
        this.wheels = 4;
        this.vehicleType = VehicleType.CAR;

    }


    private void setSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
        this.seats = seats;
    }

    @Override
    public int getSeats() {
        return seats;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("Seats: %d\n", seats);
    }


}