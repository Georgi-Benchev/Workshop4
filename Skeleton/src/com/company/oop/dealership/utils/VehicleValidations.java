package com.company.oop.dealership.utils;

import static java.lang.String.format;

public class VehicleValidations {
    // VEHICLE BASE
    public static final int MAKE_MIN_LENGTH = 2;
    public static final int MAKE_MAX_LENGTH = 15;
    public static final int MODEL_MIN_LENGTH = 1;
    public static final int MODEL_MAX_LENGTH = 15;
    public static final String INVALID_MAKE_STRING_LENGTH_MASSAGE = "Make must be between %d and %d characters long!";
    public static final String INVALID_MODEL_STRING_LENGTH_MASSAGE = "Model must be between %d and %d characters long!";
    public static final double PRICE_MIN_VALUE = 0;
    public static final double PRICE_MAX_VALUE = 1000000;
    public static final String INVALID_PRICE_MESSAGE = "Price must be between %.1f and %.1f!";
    // MOTORCYCLE
    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!", CATEGORY_LEN_MIN, CATEGORY_LEN_MAX);
    // TRUCK
    public static final int WEIGHT_CAP_MIN = 1;
    public static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!", WEIGHT_CAP_MIN, WEIGHT_CAP_MAX);


    public static void validateMake(String make) {
        ValidationHelpers.validateIntRange(
                make.length(),
                MAKE_MIN_LENGTH,
                MAKE_MAX_LENGTH,
                String.format(INVALID_MAKE_STRING_LENGTH_MASSAGE, MAKE_MIN_LENGTH, MAKE_MAX_LENGTH));
    }
    public static void validateModel(String model) {
        ValidationHelpers.validateIntRange(
                model.length(),
                MODEL_MIN_LENGTH,
                MODEL_MAX_LENGTH,
                String.format(INVALID_MODEL_STRING_LENGTH_MASSAGE, MODEL_MIN_LENGTH, MODEL_MAX_LENGTH));
    }

    public static void validatePrice(double price) {
        ValidationHelpers.validateDecimalRange(
                price,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                String.format(INVALID_PRICE_MESSAGE, PRICE_MIN_VALUE, PRICE_MAX_VALUE));
    }

    public static void validateCategory(String category) {
        ValidationHelpers.validateIntRange(
                category.length(), CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
    }

    public static void validateWeightCapacity(int weightCap) {
        ValidationHelpers.validateIntRange(weightCap, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
    }


}
