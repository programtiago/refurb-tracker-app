package com.devtiago.refurbtracker.refurb_core.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorResponse(
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        String errorCode
) { }
