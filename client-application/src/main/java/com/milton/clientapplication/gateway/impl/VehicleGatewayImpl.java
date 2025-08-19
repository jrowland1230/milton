package com.milton.clientapplication.gateway.impl;

import com.milton.clientapplication.error.ErrorCode;
import com.milton.clientapplication.exception.MiltonClientException;
import com.milton.clientapplication.gateway.VehicleGateway;
import com.milton.clientapplication.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.oauth2.client.web.client.RequestAttributeClientRegistrationIdResolver.clientRegistrationId;

@Component
@Slf4j
public class VehicleGatewayImpl implements VehicleGateway {

    private final RestClient restClient;

    public VehicleGatewayImpl(RestClient restClient) {
        this.restClient = restClient;
    }
    @Override
    public List<Vehicle> getVehiclesByMake(String make) {

        String uriString = UriComponentsBuilder.fromUriString("http://localhost:8081/api/v1/vehicles/make/")
                .path(make).toUriString();;

        Vehicle[] vehicles = restClient.get().uri(uriString)
                .attributes(clientRegistrationId("milton-client"))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                    throw new MiltonClientException((HttpStatus)response.getStatusCode(),
                            ErrorCode.MILTON_SERVICE_GATEWAY_ERROR, "My Error Message");
                }))
                .body(Vehicle[].class);

        if (ObjectUtils.isNotEmpty(vehicles)) {
            return Arrays.asList(vehicles);
        } else {
            return List.of();
        }
    }
}
