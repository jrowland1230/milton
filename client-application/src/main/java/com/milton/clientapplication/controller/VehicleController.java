package com.milton.clientapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import static org.springframework.security.oauth2.client.web.client.RequestAttributeClientRegistrationIdResolver.clientRegistrationId;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    private final RestClient restClient;

    public VehicleController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping(value = "/vehicles/make/{make}", produces = "application/json")
    @Operation(summary = "Returns vehicles for a given make")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request / Error in the request payload"),
            @ApiResponse(responseCode = "500", description = "internal server error")})
    public String getVehicles(@PathVariable("make") @NotBlank String make) {

        try {
            return restClient.get().uri("http://localhost:8081/api/v1/vehicles/make/" + make)
                    .attributes(clientRegistrationId("milton-client"))
                    .retrieve()
                    .body(String.class);
        } catch (Exception ex) {
            Exception s = ex;
            return null;
        }
    }
}