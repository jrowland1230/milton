package com.milton.resourceserver.service.impl;

import com.milton.resourceserver.error.ErrorCode;
import com.milton.resourceserver.exception.MiltonResourceException;
import com.milton.resourceserver.model.Vehicle;
import com.milton.resourceserver.service.VehicleService;
import com.milton.resourceserver.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
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
            String errorMessage = String.format("Unable to retrieve vehicles for parameter: %s", make);
            log.error(errorMessage, exception);
            throw new MiltonResourceException(HttpStatus.BAD_REQUEST,
                    ErrorCode.MILTON_SERVICE_BAD_REQUEST_ERROR, errorMessage);
        }
    }
}
