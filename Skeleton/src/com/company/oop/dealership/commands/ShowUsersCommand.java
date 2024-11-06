package com.company.oop.dealership.commands;


import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.contracts.User;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    private final static String USERS_HEADER = "--USERS--";


    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        if (getVehicleDealershipRepository().getLoggedInUser().isAdmin()) {

            StringBuilder output = new StringBuilder(USERS_HEADER);
            List<User> users = getVehicleDealershipRepository().getUsers();

            for (int i = 0; i < users.size(); i++) {
                output.append(String.format("\n%d. %s", i + 1, users.get(i).printUserInfo()));
            }

            return output.toString();
        }
        throw new IllegalArgumentException("You are not an admin!");
    }


    @Override
    protected boolean requiresLogin() {
        return true;
    }

}