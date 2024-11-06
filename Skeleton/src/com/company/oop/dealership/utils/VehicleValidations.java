package com.company.oop.dealership.utils;

import static java.lang.String.format;

public class VehicleValidations {
    //  VEHICLE BASE
    private static final int MAKE_MIN_LENGTH = 2;
    private static final int MAKE_MAX_LENGTH = 15;
    private static final int MODEL_MIN_LENGTH = 1;
    private static final int MODEL_MAX_LENGTH = 15;
    private static final String INVALID_MAKE_STRING_LENGTH_MASSAGE = "Make must be between %d and %d characters long!";
    private static final String INVALID_MODEL_STRING_LENGTH_MASSAGE = "Model must be between %d and %d characters long!";
    private static final double PRICE_MIN_VALUE = 0;
    private static final double PRICE_MAX_VALUE = 1000000;
    private static final String INVALID_PRICE_MESSAGE = "Price must be between %.1f and %.1f!";
    //  MOTORCYCLE
    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!", CATEGORY_LEN_MIN, CATEGORY_LEN_MAX);
    //  TRUCK
    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!", WEIGHT_CAP_MIN, WEIGHT_CAP_MAX);
    //  CAR
    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!", CAR_SEATS_MIN, CAR_SEATS_MAX);



    //  VEHICLE BASE
    public static void validateMake(String make) {
        ValidationHelpers.validateIntRange(
                make.length(),
                MAKE_MIN_LENGTH,
                MAKE_MAX_LENGTH,
                String.format(INVALID_MAKE_STRING_LENGTH_MASSAGE, MAKE_MIN_LENGTH, MAKE_MAX_LENGTH));
    }

    //  VEHICLE BASE
    public static void validateModel(String model) {
        ValidationHelpers.validateIntRange(
                model.length(),
                MODEL_MIN_LENGTH,
                MODEL_MAX_LENGTH,
                String.format(INVALID_MODEL_STRING_LENGTH_MASSAGE, MODEL_MIN_LENGTH, MODEL_MAX_LENGTH));
    }

    //  VEHICLE BASE
    public static void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(
                price,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                String.format(INVALID_PRICE_MESSAGE, PRICE_MIN_VALUE, PRICE_MAX_VALUE));
    }

    //  MOTORCYCLE
    public static void validateCategory(String category) {
        ValidationHelpers.validateIntRange(
                category.length(), CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
    }

    //  TRUCK
    public static void validateWeightCapacity(int weightCap) {
        ValidationHelpers.validateIntRange(weightCap, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
    }

    //  CAR
    public static void validateSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
    }

}
