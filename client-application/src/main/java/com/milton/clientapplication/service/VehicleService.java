package com.milton.clientapplication.service;

import com.milton.clientapplication.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getVehicles(String make);
}
