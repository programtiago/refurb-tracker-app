package com.devtiago.erp_mock_track_app.entity.dto;

public record CpeDto(
        String sap,
        String design,
        String partNo,
        String ean,
        boolean active
) { }
