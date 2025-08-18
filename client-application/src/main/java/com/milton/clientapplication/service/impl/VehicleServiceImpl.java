package com.milton.clientapplication.service.impl;

import com.milton.clientapplication.gateway.VehicleGateway;
import com.milton.clientapplication.model.Vehicle;
import com.milton.clientapplication.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleGateway vehicleGateway;

    public VehicleServiceImpl(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public List<Vehicle> getVehicles(String make) {

        log.info("Get vehicles by make: {}", make);

        List<Vehicle> vehicles = vehicleGateway.getVehiclesByMake(make);

        log.info("Returned vehicles count: {}", vehicles.size());
        return vehicles;
    }
}
