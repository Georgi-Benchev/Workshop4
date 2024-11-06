package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Commentable;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.FormattingHelpers;
import com.company.oop.dealership.utils.VehicleValidations;

import java.util.ArrayList;
import java.util.List;

abstract class VehicleBase implements Vehicle, Commentable {

    private final String make;
    private final String model;
    private final double price;
    private final int wheels;
    private final VehicleType vehicleType;
    private final List<Comment> comments;


    protected VehicleBase(String make, String model, double price, int wheels, VehicleType vehicleType) {
        VehicleValidations.validatePrice(price);
        VehicleValidations.validateMake(make);
        VehicleValidations.validateModel(model);
        this.model = model;
        this.make = make;
        this.price = price;
        this.wheels = wheels;
        this.vehicleType = vehicleType;
        comments = new ArrayList<>();
    }


    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    @Override
    public String toString() {
        return String.format(". %s:\n" +
                        "Make: %s\n" +
                        "Model: %s\n" +
                        "Wheels: %d\n" +
                        "Price: $%s\n",
                vehicleType, make, model, wheels, FormattingHelpers.removeTrailingZerosFromDouble(price));
    }

    public String printComments() {
        StringBuilder output = new StringBuilder();
        output.append("--COMMENTS--");

        for (Comment comment : comments) {
            output.append(comment.toString());
        }

        output.append("\n");
        output.append("--COMMENTS--");

        return output.toString();
    }


    //  GETTERS

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
