package com.devtiago.erp_mock_track_app.enums;

public enum OperationType {

    RECEPTION("Reception"),
    HOUSING("Housing"),
    PACKAGING("Packaging"),
    EXPEDITION("Expedition");

    private final String displayName;

    OperationType (String displayName){
        this.displayName = displayName;
    }
}
