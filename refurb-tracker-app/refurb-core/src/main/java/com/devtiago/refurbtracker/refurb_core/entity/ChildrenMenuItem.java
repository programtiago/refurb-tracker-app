package com.devtiago.refurbtracker.refurb_core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildrenMenuItem {

    private String title;
    private String path;
    private String icon;
    private String description;
}
