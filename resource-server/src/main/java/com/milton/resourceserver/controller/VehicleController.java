package com.milton.resourceserver.controller;

import com.milton.resourceserver.model.Vehicle;
import com.milton.resourceserver.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/vehicles/make/{make}", produces = "application/json")
    @Operation(summary = "Returns vehicles for a given make")
    @ApiResponses( value = { @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request / Error in the request payload"),
            @ApiResponse(responseCode = "500", description = "internal server error") })
    public ResponseEntity<List<Vehicle>> getVehicles(@PathVariable("make") @NotBlank String make) {
        List<Vehicle> vehicles = vehicleService.getVehicles(make);
        return ResponseEntity.ok(vehicles);
    }
}
