package com.dashdash.backend.menu.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
public class MenuDto {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String options;
    private byte[] image;
}
