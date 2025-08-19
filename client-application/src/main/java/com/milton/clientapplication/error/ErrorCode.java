package com.milton.clientapplication.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCode {

    MILTON_SERVICE_ERROR("MiltonClientService-1000", "Error Message"),
    MILTON_SERVICE_GATEWAY_ERROR("MiltonClientService-1001", "Error Message");

    @Getter
    private final String errCode;

    @Getter
    private final String errorDescription;
}
