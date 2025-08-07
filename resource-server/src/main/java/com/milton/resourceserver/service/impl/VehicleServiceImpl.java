package com.milton.resourceserver.service.impl;

import com.milton.resourceserver.model.Vehicle;
import com.milton.resourceserver.service.VehicleService;
import com.milton.resourceserver.util.DataUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleServiceImpl implements VehicleService {
    @Override
    public List<Vehicle> getVehicles(String make) {



        try {
            List<Vehicle> vehicles = DataUtil.getVehicleData();

//            vehicles.stream().filter(v -> {
//
//            });

        } catch (Exception exception) {

        }
        return List.of();
    }
}
