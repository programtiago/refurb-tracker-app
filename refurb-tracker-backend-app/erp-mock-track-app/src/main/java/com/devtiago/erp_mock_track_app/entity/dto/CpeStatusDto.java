package com.devtiago.erp_mock_track_app.entity.dto;

import java.time.LocalDateTime;

public record CpeStatusDto(
        Long receptionId,
        Long testingId,
        String receptionIdentifier,
        String purchaseOrder,
        String palletId,
        String sn,
        String mac,
        LocalDateTime startTest,
        LocalDateTime endTest,
        String status
) { }
