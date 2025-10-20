package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_core.entity.ChildrenMenuItem;
import com.devtiago.refurbtracker.refurb_core.entity.MenuItem;
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
            List<ChildrenMenuItem> employeesSubMenu = List.of(
                    new ChildrenMenuItem("List Employees", "/employees", "view_list", "View All Employees"),
                    new ChildrenMenuItem("Add Employee", "/employees/new", "add_circle", "Add a new employee"),
                    new ChildrenMenuItem("Update Employee", "/employees/edit/:id", "edit", "Update employee")
            );

            // Top-level Employees menu
            menu.add(new MenuItem("Employees", "/employees", "users", employeesSubMenu));
        }

        return menu;
    }
}
