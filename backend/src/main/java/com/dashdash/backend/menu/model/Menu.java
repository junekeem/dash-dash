package com.dashdash.backend.menu.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.restaurant.model.Restaurant;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class Menu extends BaseEntity {
    private Restaurant restaurant;
    private String name;
    private BigDecimal price;
    private String options;
    private byte[] image;
}
