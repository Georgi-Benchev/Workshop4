package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.VehicleValidations;


public class TruckImpl extends VehicleBase implements Truck {

    private static final int NUMBER_OF_WHEELS_ON_TRUCK = 8;
    private static final VehicleType VEHICLE_TYPE = VehicleType.TRUCK;
    private final int weightCap;

    public TruckImpl(String make, String model, double price, int weightCap) {
        super(make, model, price, NUMBER_OF_WHEELS_ON_TRUCK, VEHICLE_TYPE);

        VehicleValidations.validateWeightCapacity(weightCap);
        this.weightCap = weightCap;
    }


    @Override
    public int getWeightCapacity() {
        return weightCap;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Weight Capacity: %dt\n", getWeightCapacity());
    }
}