package com.devtiago.erp_mock_track_app.utils.mapper;

import com.devtiago.erp_mock_track_app.entity.OperationHistory;
import com.devtiago.erp_mock_track_app.entity.dto.CpeStatusDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OperationHistoryMapper {

    public CpeStatusDto toDto(OperationHistory oph){
        return new CpeStatusDto(
                oph.getReception().getId(),
                oph.getTesting().getId(),
                oph.getReception().getReceptionIdentifier(),
                oph.getReception().getPurchaseOrder(),
                oph.getReception().getPalletId(),
                oph.getReception().getSn(),
                oph.getTesting().getMac(),
                oph.getTesting().getStartTest(),
                oph.getTesting().getEndTest(),
                oph.getTesting().getStatus().name()
        );
    }
}
