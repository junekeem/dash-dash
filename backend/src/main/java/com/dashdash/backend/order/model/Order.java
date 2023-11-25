package com.dashdash.backend.order.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.restaurant.model.Restaurant;
import com.dashdash.backend.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
