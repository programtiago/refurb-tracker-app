package com.devtiago.erp_mock_track_app.entity.dto;

import java.time.LocalDateTime;

public record CpeStatusDto(
        Long id,
        Long receptionId,
        LocalDateTime receptionDate,
        Long testId,
        LocalDateTime testDate
) { }
