package com.devtiago.erp_mock_track_app.utils.mapper;

import com.devtiago.erp_mock_track_app.entity.Cpe;
import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CpeMapper {
    public CpeDto toDto(Cpe cpe){
        if (cpe == null) return null;

        return new CpeDto(
                cpe.getSap(),
                cpe.getDesign(),
                cpe.getPartNo(),
                cpe.getEan(),
                cpe.isActive()
        );
    }

    public List<CpeDto> toListDto(List<Cpe> cpes){
        return cpes.stream()
                .map(this::toDto)
                .toList();
    }
}
