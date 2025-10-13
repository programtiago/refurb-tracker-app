package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_core.entity.dto.MenuItem;
import com.devtiago.refurbtracker.refurb_core.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RhMenuService implements MenuService {
    @Override
    //public List<MenuItem> getMenuFor(String role, String department) {
    public List<MenuItem> getMenuFor(String department) {
        List<MenuItem> menu = new ArrayList<>();

        if (department.equalsIgnoreCase("HR")){
            //if (role.equalsIgnoreCase("MANAGER")){}
            menu.add(new MenuItem("Employees", "/employees", "users", ""));
        }

        return menu;
    }
}
