package com.company.oop.dealership.models;
import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.VehicleValidations;


public class CarImpl extends VehicleBase implements Car {

    private static final int NUMBER_OF_WHEELS_ON_CAR = 4;
    private static final VehicleType VEHICLE_TYPE = VehicleType.CAR;
    private final int seats;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price,NUMBER_OF_WHEELS_ON_CAR,VEHICLE_TYPE);

        VehicleValidations.validateSeats(seats);
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