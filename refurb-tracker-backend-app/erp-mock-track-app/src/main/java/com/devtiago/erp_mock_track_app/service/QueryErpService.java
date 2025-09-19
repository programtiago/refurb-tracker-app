package com.devtiago.erp_mock_track_app.service;

import com.devtiago.erp_mock_track_app.entity.Cpe;
import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import com.devtiago.erp_mock_track_app.repository.CpeRepository;
import com.devtiago.erp_mock_track_app.utils.mapper.CpeMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryErpService {

    private final CpeRepository cpeRepository;

    private final CpeMapper cpeMapper;

    public List<CpeDto> findAll(){
        return cpeMapper.toListDto(cpeRepository.findAll());
    }

    public CpeDto getCpeById(Long id) {
        Cpe cpe = cpeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No CPE found with id " + id));

        return cpeMapper.toDto(cpe);
    }
}
