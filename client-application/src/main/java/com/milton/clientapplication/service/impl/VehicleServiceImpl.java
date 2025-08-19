package com.milton.clientapplication.service.impl;

import com.milton.clientapplication.error.ErrorCode;
import com.milton.clientapplication.exception.MiltonClientException;
import com.milton.clientapplication.gateway.VehicleGateway;
import com.milton.clientapplication.model.Vehicle;
import com.milton.clientapplication.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        try {
            log.info("Get vehicles by make: {}", make);

            List<Vehicle> vehicles = vehicleGateway.getVehiclesByMake(make);

            log.info("Returned vehicles count: {}", vehicles.size());
            return vehicles;
        } catch (Exception exception) {
            String errorMessage = String.format("Unable to retrieve vehicles for parameter: %s", make);
            log.error(errorMessage, exception);
            throw new MiltonClientException(HttpStatus.BAD_REQUEST,
                    ErrorCode.MILTON_SERVICE_ERROR, errorMessage);
        }
    }
}
