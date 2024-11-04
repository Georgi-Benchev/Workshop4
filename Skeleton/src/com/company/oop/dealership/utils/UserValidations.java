package com.company.oop.dealership.utils;

import static java.lang.String.format;

public class UserValidations {
    public static final int USERNAME_LEN_MIN = 2;
    public static final int USERNAME_LEN_MAX = 20;
    private static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]+$";
    private static final String USERNAME_PATTERN_ERR = "Username contains invalid symbols!";
    private static final String USERNAME_LEN_ERR = format(
            "Username must be between %d and %d characters long!",
            USERNAME_LEN_MIN,
            USERNAME_LEN_MAX);

    public static final int PASSWORD_LEN_MIN = 5;
    public static final int PASSWORD_LEN_MAX = 30;
    private static final String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9@*_-]+$";
    private static final String PASSWORD_PATTERN_ERR = "Password contains invalid symbols!";
    private static final String PASSWORD_LEN_ERR = format(
            "Password must be between %s and %s characters long!",
            PASSWORD_LEN_MIN,
            PASSWORD_LEN_MAX);

    public static final int LASTNAME_LEN_MIN = 2;
    public static final int LASTNAME_LEN_MAX = 20;
    private static final String LASTNAME_LEN_ERR = format(
            "Lastname must be between %s and %s characters long!",
            LASTNAME_LEN_MIN,
            LASTNAME_LEN_MAX);

    public static final int FIRSTNAME_LEN_MIN = 2;
    public static final int FIRSTNAME_LEN_MAX = 20;
    private static final String FIRSTNAME_LEN_ERR = format(
            "Firstname must be between %s and %s characters long!",
            FIRSTNAME_LEN_MIN,
            FIRSTNAME_LEN_MAX);

    private final static String NOT_AN_VIP_USER_VEHICLES_ADD = "You are not VIP and cannot add more than %d vehicles!";
    private final static String ADMIN_CANNOT_ADD_VEHICLES = "You are an admin and therefore cannot add vehicles!";

    private static final String YOU_ARE_NOT_THE_AUTHOR = "You are not the author of the comment you are trying to remove!";
    private final static String USER_TO_STRING = "Username: %s, FullName: %s %s, Role: %s";
    private final static String NO_VEHICLES_HEADER = "--NO VEHICLES--";
    private final static String USER_HEADER = "--USER %s--";
    private static final int NORMAL_ROLE_VEHICLE_LIMIT = 5;


    public static void validateUsername(String username) {
        ValidationHelpers.validateIntRange(username.length(), USERNAME_LEN_MIN, USERNAME_LEN_MAX, USERNAME_LEN_ERR);
        ValidationHelpers.validatePattern(username, USERNAME_REGEX_PATTERN, USERNAME_PATTERN_ERR);
    }

    public static void validatePassword(String password) {
        ValidationHelpers.validateIntRange(password.length(), PASSWORD_LEN_MIN, PASSWORD_LEN_MAX,PASSWORD_LEN_ERR);
        ValidationHelpers.validatePattern(password, PASSWORD_REGEX_PATTERN,PASSWORD_PATTERN_ERR);
    }

    public static void validateFirstName(String firstName) {
        ValidationHelpers.validateIntRange(firstName.length(), FIRSTNAME_LEN_MIN, FIRSTNAME_LEN_MAX, FIRSTNAME_LEN_ERR);
    }
    public static void validateLastName(String lastName) {
        ValidationHelpers.validateIntRange(lastName.length(), LASTNAME_LEN_MIN,LASTNAME_LEN_MAX,LASTNAME_LEN_ERR);
    }
}
