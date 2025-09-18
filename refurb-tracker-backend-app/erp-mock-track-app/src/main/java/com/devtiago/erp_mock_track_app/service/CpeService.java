package com.devtiago.erp_mock_track_app.service;

import com.devtiago.erp_mock_track_app.entity.Cpe;
import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import com.devtiago.erp_mock_track_app.repository.CpeRepository;
import com.devtiago.erp_mock_track_app.utils.mapper.CpeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CpeService {

    private final CpeRepository cpeRepository;
    private final CpeMapper cpeMapper;

    public List<CpeDto> getAll(){
        return cpeMapper.toListDto(cpeRepository.findAll());
    }

    public CpeDto findById(Long id){
       Cpe cpeResult = cpeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No CPE found with the id " + id));

        return cpeMapper.toDto(cpeResult);
    }
}
