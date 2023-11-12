package com.dashdash.backend.restaurant.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.menu.model.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Restaurant extends BaseEntity {
    private List<Menu> menus;
}
