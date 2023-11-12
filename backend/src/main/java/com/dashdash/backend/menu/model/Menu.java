package com.dashdash.backend.menu.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.restaurant.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Menu extends BaseEntity {
    private Restaurant restaurant;
    private String name;
    private BigDecimal price;
    private String options;
    private byte[] image;
}
