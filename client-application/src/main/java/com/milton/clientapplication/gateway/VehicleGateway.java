package com.milton.clientapplication.gateway;

import com.milton.clientapplication.model.Vehicle;

import java.util.List;

public interface VehicleGateway {
    List<Vehicle> getVehiclesByMake(String make);
}
