package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.VehicleValidations;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    private static final int NUMBER_OF_WHEELS_ON_MOTORCYCLE = 2;
    private static final VehicleType VEHICLE_TYPE = VehicleType.MOTORCYCLE;
    private final String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price, NUMBER_OF_WHEELS_ON_MOTORCYCLE, VEHICLE_TYPE);

        VehicleValidations.validateCategory(category);
        this.category = category;
    }


    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: %s\n", category);
    }
}