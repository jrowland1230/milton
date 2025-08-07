package com.milton.resourceserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.milton.resourceserver.model.Vehicle;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DataUtil {

    public static List<Vehicle> getVehicleData() {

        String fileUrl = Paths.get("src/test", "resources",
                "customerTestData.json").toFile().toURI().toString();
        String jsonString = ResourceUtil.getResourceAsString(fileUrl);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(jsonString, Vehicle[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
