package com.dashdash.backend.user.model;

import com.dashdash.backend.application.model.BaseEntity;
import com.dashdash.backend.order.model.Order;
import com.dashdash.backend.restaurant.model.Restaurant;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class User extends BaseEntity {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

}
