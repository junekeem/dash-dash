package com.dashdash.backend.order.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.menu.model.Menu;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
public class OrderDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private int quantity;

    private BigDecimal totalAmount;

}
