package com.devtiago.erp_mock_track_app.entity;

import com.devtiago.erp_mock_track_app.enums.OperationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class Operation {

    @Enumerated(EnumType.STRING)
    protected OperationType operationType;

    public Operation(OperationType operationType){
        this.operationType = operationType;
    }

    public void processOperation(Operation operation){
        if (operation instanceof Reception reception){
            System.out.println("Processing Reception ID: " + reception.getId());
        }
    }
}
