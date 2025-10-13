package com.devtiago.refurbtracker.refurb_core.service;

import com.devtiago.refurbtracker.refurb_core.entity.MenuItem;

import java.util.List;

public interface MenuService {

    List<MenuItem> getMenuFor(String department);
}
