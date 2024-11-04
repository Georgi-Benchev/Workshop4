package com.company.oop.dealership.models.contracts;

import com.company.oop.dealership.models.enums.VehicleType;

public interface Vehicle extends Commentable{

    int getWheels();

    VehicleType getType();

    String getMake();

    double getPrice();

    String getModel();

    void addComment(Comment comment);

    void removeComment(Comment comment);

}
