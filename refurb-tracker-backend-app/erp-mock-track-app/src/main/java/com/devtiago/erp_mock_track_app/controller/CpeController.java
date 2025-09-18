package com.devtiago.erp_mock_track_app.controller;

import com.devtiago.erp_mock_track_app.entity.dto.CpeDto;
import com.devtiago.erp_mock_track_app.service.CpeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpes")
@RequiredArgsConstructor
public class CpeController {

    private final CpeService cpeService;

    @GetMapping
    public List<CpeDto> getAll(){
        return cpeService.getAll();
    }

    @GetMapping("/{id}")
    public CpeDto getById(@PathVariable Long id){
        return cpeService.findById(id);
    }
}
