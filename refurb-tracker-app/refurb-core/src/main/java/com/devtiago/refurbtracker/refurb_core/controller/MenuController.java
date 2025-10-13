package com.devtiago.refurbtracker.refurb_core.controller;

import com.devtiago.refurbtracker.refurb_core.entity.MenuItem;
import com.devtiago.refurbtracker.refurb_core.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    @GetMapping
    public ResponseEntity<List<MenuItem>> getMenu(@RequestParam String department){
        return ResponseEntity.ok(menuService.getMenuFor(department));
    }
}
