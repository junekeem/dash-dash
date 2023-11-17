package com.dashdash.backend.menu.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.order.model.OrderDetail;
import com.dashdash.backend.restaurant.model.Restaurant;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String name;
    private BigDecimal price;
    private String options;
    private byte[] image;

    @OneToMany(mappedBy = "menu")
    private List<OrderDetail> orderDetails;

    @Builder(toBuilder = true)
    public Menu(String name, BigDecimal price, String options, byte[] image) {
        this.name = name;
        this.price = price;
        this.options = options;
        this.image = image;
    }
}
