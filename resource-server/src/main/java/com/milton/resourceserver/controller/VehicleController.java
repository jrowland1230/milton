package com.milton.resourceserver.controller;

import com.milton.resourceserver.model.Vehicle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    @GetMapping(value = "/vehicle/make/{make}", produces = "application/json")
    @Operation(summary = "Returns vehicles for a given make")
    @ApiResponses( value = { @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request / Error in the request payload"),
            @ApiResponse(responseCode = "500", description = "internal server error") })
    public ResponseEntity<List<Vehicle>> getVehicles() {

        //List<Vehicle> vehicles =

        return null;

    }
}
