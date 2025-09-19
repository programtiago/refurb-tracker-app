package com.devtiago.erp_mock_track_app.controller;

import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import com.devtiago.erp_mock_track_app.entity.dto.CpeStatusDto;
import com.devtiago.erp_mock_track_app.service.QueryErpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryErpController {

    private final QueryErpService queryErpService;
    @GetMapping("/cpes")
    public List<CpeDto> getAll(){
        return queryErpService.findAll();
    }

    @GetMapping("/cpes/{id}")
    public CpeDto findCpeById(@PathVariable Long id){
        return queryErpService.getCpeById(id);
    }

    @GetMapping("/status")
    public CpeStatusDto getStatusCpeBySn(@RequestParam("sn") String sn){
        return queryErpService.getStatusCpeBySn(sn);
    }
}
