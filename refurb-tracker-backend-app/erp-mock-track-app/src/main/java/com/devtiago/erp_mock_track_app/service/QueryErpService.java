package com.devtiago.erp_mock_track_app.service;

import com.devtiago.erp_mock_track_app.entity.Cpe;
import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import com.devtiago.erp_mock_track_app.entity.dto.CpeStatusDto;
import com.devtiago.erp_mock_track_app.repository.CpeRepository;
import com.devtiago.erp_mock_track_app.repository.OperationHistoryRepository;
import com.devtiago.erp_mock_track_app.utils.mapper.CpeMapper;
import com.devtiago.erp_mock_track_app.utils.mapper.OperationHistoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryErpService {

    private final CpeRepository cpeRepository;
    private final OperationHistoryRepository operationHistoryRepository;

    private final CpeMapper cpeMapper;
    private final OperationHistoryMapper operationHistoryMapper;

    public List<CpeDto> findAll(){
        return cpeMapper.toListDto(cpeRepository.findAll());
    }

    public CpeDto getCpeById(Long id) {
        Cpe cpe = cpeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No CPE found with id " + id));

        return cpeMapper.toDto(cpe);
    }

    public CpeStatusDto getStatusCpeBySn(String sn){
        return operationHistoryRepository.findByReceptionSn(sn)
                .map(operationHistoryMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SN not found"));
    }
}
