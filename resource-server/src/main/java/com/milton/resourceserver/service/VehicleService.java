package com.milton.resourceserver.service;

import com.milton.resourceserver.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getVehicles(String make);
}
