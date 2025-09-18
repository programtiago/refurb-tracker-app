package com.devtiago.erp_mock_track_app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum OperationType {

    RECEPTION("Reception"),
    TESTING("Testing"),
    HOUSING("Housing"),
    PACKAGING("Packaging"),
    EXPEDITION("Expedition");

    private final String displayName;
}
