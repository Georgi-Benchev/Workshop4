package com.company.oop.dealership.utils;

import static java.lang.String.format;

public class UserValidations {
    //  USERNAME
    private static final int USERNAME_LEN_MIN = 2;
    private static final int USERNAME_LEN_MAX = 20;
    private static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]+$";
    private static final String USERNAME_PATTERN_ERR = "Username contains invalid symbols!";
    private static final String USERNAME_LEN_ERR = format(
            "Username must be between %d and %d characters long!", USERNAME_LEN_MIN, USERNAME_LEN_MAX);
    //  PASSWORD
    private static final int PASSWORD_LEN_MIN = 5;
    private static final int PASSWORD_LEN_MAX = 30;
    private static final String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9@*_-]+$";
    private static final String PASSWORD_PATTERN_ERR = "Password contains invalid symbols!";
    private static final String PASSWORD_LEN_ERR = format(
            "Password must be between %s and %s characters long!", PASSWORD_LEN_MIN, PASSWORD_LEN_MAX);
    //  FIRST NAME
    private static final int FIRSTNAME_LEN_MIN = 2;
    private static final int FIRSTNAME_LEN_MAX = 20;
    private static final String FIRSTNAME_LEN_ERR = format(
            "Firstname must be between %s and %s characters long!", FIRSTNAME_LEN_MIN, FIRSTNAME_LEN_MAX);
    //  LAST NAME
    private static final int LASTNAME_LEN_MIN = 2;
    private static final int LASTNAME_LEN_MAX = 20;
    private static final String LASTNAME_LEN_ERR = format(
            "Lastname must be between %s and %s characters long!", LASTNAME_LEN_MIN, LASTNAME_LEN_MAX);




    public static void validateUsername(String username) {
        ValidationHelpers.validateIntRange(username.length(), USERNAME_LEN_MIN, USERNAME_LEN_MAX, USERNAME_LEN_ERR);
        ValidationHelpers.validatePattern(username, USERNAME_REGEX_PATTERN, USERNAME_PATTERN_ERR);
    }

    public static void validatePassword(String password) {
        ValidationHelpers.validateIntRange(password.length(), PASSWORD_LEN_MIN, PASSWORD_LEN_MAX, PASSWORD_LEN_ERR);
        ValidationHelpers.validatePattern(password, PASSWORD_REGEX_PATTERN, PASSWORD_PATTERN_ERR);
    }

    public static void validateFirstName(String firstName) {
        ValidationHelpers.validateIntRange(firstName.length(), FIRSTNAME_LEN_MIN, FIRSTNAME_LEN_MAX, FIRSTNAME_LEN_ERR);
    }

    public static void validateLastName(String lastName) {
        ValidationHelpers.validateIntRange(lastName.length(), LASTNAME_LEN_MIN, LASTNAME_LEN_MAX, LASTNAME_LEN_ERR);
    }
}
