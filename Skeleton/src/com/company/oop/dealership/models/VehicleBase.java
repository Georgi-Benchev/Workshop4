package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Commentable;
import com.company.oop.dealership.models.contracts.Vehicle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.VehicleValidations;

import java.util.ArrayList;
import java.util.List;

abstract class VehicleBase implements Vehicle, Commentable {


    private String make;
    private String model;
    private double price;
    protected int wheels;
    protected VehicleType vehicleType;
    private List<Comment> comments;

    protected VehicleBase(String make, String model, double price) {
        setMake(make);
        setModel(model);
        setPrice(price);
        comments = new ArrayList<>();
    }

    private void setMake(String make) {
        VehicleValidations.validateMake(make);
        this.make = make;
    }

    public void setModel(String model) {
       VehicleValidations.validateModel(model);
        this.model = model;
    }



    public void setPrice(double price) {
       VehicleValidations.validatePrice(price);
        this.price = price;
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
        String output = String.format("#. %s:\n" +
                "Make: %s\n" +
                "Model: %s\n" +
                "Wheels: %d\n" +
                "Price: $%.2f\n", vehicleType, make, model, wheels, price);
        return output;
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }


}
