package com.milton.resourceserver.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Vehicle {
    @Size(max = 17, message = "max length is 17 characters")
    private String vin;
    @Pattern(regexp = "\\d{4}", message = "must be 4 digits")
    private String year;
    @Size(max = 50, message = "max length is 50 characters")
    private String make;
    @Size(max = 50, message = "max length is 50 characters")
    private String model;
    @Size(max = 50, message = "max length is 50 characters")
    private String color;
    @Size(max = 50, message = "must be at most 50 characters")
    private String licensePlate;
    @Size(max = 50, message = "max length of 50 alphabets")
    private String licensePlateState;
    private String dateCreated;
}
