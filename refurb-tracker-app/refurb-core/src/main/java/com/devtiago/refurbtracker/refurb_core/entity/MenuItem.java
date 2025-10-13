package com.devtiago.refurbtracker.refurb_core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    private String title;
    private String path;
    private String description;
    private List<ChildrenMenuItem> subMenuItems;
}
