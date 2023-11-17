package com.dashdash.backend.menu.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder(toBuilder = true)
public class MenuDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String options;
    private byte[] image;
}
