package com.dashdash.backend.restaurant.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.order.model.Order;
import com.dashdash.backend.user.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Restaurant extends BaseEntity {

    private String name;

    @ManyToOne
    private User owner;

    private String address;
    private String phone;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus;
}
