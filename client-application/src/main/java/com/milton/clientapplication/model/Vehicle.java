package com.milton.clientapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private String vin;
    private String year;
    private String make;
    private String model;
    private String color;
    private String licensePlate;
    private String licensePlateState;
}

