package com.milton.resourceserver.service.impl;

import com.milton.resourceserver.model.Vehicle;
import com.milton.resourceserver.service.VehicleService;
import com.milton.resourceserver.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public List<Vehicle> getVehicles(String make) {

        try {
            log.info("Get vehicles by make: {}", make);

            List<Vehicle> vehicles = DataUtil.getVehicleData();

            if (ObjectUtils.isNotEmpty(make) && !make.equalsIgnoreCase("All")) {
                vehicles = vehicles.stream().filter(v -> v.getMake().equalsIgnoreCase(make)).toList();
            }
            log.info("Returned vehicles count: {}", vehicles.size());
            return vehicles;
        } catch (Exception exception) {
            log.error("Error retrieving vehicles with message: {}", exception.getMessage(), exception);
            return List.of();
        }
    }
}
