package com.company.oop.dealership.models;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.User;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.UserRole;
import com.company.oop.dealership.utils.UserValidations;
import java.util.ArrayList;
import java.util.List;


public class UserImpl implements User {
    private final static String NOT_AN_VIP_USER_VEHICLES_ADD = "You are not VIP and cannot add more than %d vehicles!";
    private final static String ADMIN_CANNOT_ADD_VEHICLES = "You are an admin and therefore cannot add vehicles!";
    private static final String YOU_ARE_NOT_THE_AUTHOR = "You are not the author of the comment you are trying to remove!";
    private final static String USER_TO_STRING = "Username: %s, FullName: %s %s, Role: %s";
    private final static String NO_VEHICLES_HEADER = "--NO VEHICLES--";
    private final static String USER_HEADER = "--USER %s--";
    private static final String NO_COMMENTS_HEADER = "--NO COMMENTS--";
    private static final int NORMAL_ROLE_VEHICLE_LIMIT = 5;


    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final List<Vehicle> vehicles;
    private final UserRole userRole;

    public UserImpl(String username, String firstName, String lastName, String password, UserRole userRole) {
        UserValidations.validateUsername(username);
        UserValidations.validateFirstName(firstName);
        UserValidations.validateLastName(lastName);
        UserValidations.validatePassword(password);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        vehicles = new ArrayList<>();
        this.userRole = userRole;
    }




    @Override
    public void addVehicle(Vehicle vehicle) {
        switch (userRole) {
            case NORMAL: {
                if (vehicles.size() < 5) {
                    vehicles.add(vehicle);
                } else {
                    throw new IllegalArgumentException(
                            String.format((NOT_AN_VIP_USER_VEHICLES_ADD), NORMAL_ROLE_VEHICLE_LIMIT));
                }
                break;
            }
            case VIP: {
                vehicles.add(vehicle);
                break;
            }
            case ADMIN: {
                throw new IllegalArgumentException(ADMIN_CANNOT_ADD_VEHICLES);
            }
        }
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public void addComment(Comment commentToAdd, Vehicle vehicleToAddComment) {
        vehicleToAddComment.addComment(commentToAdd);
    }


    @Override
    public void removeComment(Comment commentToRemove, Vehicle vehicleToRemoveComment) {
        if (commentToRemove.getAuthor().equals(getUsername())) {
            vehicleToRemoveComment.removeComment(commentToRemove);
        } else {
            throw new IllegalArgumentException(YOU_ARE_NOT_THE_AUTHOR);
        }
    }

    @Override
    public boolean isAdmin() {
        return userRole.equals(UserRole.ADMIN);
    }

    //  RETURNS STRING WITH ALL THE VEHICLES OF THE USER
    @Override
    public String printVehicles() {
        StringBuilder output = new StringBuilder(String.format(USER_HEADER, username));

        if (vehicles.isEmpty()) {
            output.append("\n");
            output.append(NO_VEHICLES_HEADER);
        } else {
            for (int i = 0; i < vehicles.size(); i++) {
                // PRINTING VEHICLE
                output.append("\n");
                output.append(i + 1).append(vehicles.get(i).toString());
                // PRINTING THE COMMENTS OF THE CURRENT VEHICLE
                if (vehicles.get(i).getComments().isEmpty()) {
                    output.append(NO_COMMENTS_HEADER);
                } else {
                    output.append(vehicles.get(i).printComments());
                }
            }
        }
        return output.toString();
    }

    //  RETURNS A STRING WITH THE INFORMATION OF THE USER
    public String printUserInfo() {
        return String.format(USER_TO_STRING, username, firstName, lastName, getRole());
    }


    //  GETTERS

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public UserRole getRole() {
        return this.userRole;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImpl user = (UserImpl) o;
        return username.equals(user.username) && firstName.equals(user.firstName)
                && lastName.equals(user.lastName) && userRole == user.userRole;
    }
}