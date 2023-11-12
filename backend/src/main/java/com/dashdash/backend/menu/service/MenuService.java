package com.dashdash.backend.menu.service;

import com.dashdash.backend.menu.model.Menu;

import java.util.UUID;

public interface MenuService {
    Menu save(Menu menu);

    Menu getById(UUID id);

    Menu updateById(UUID id, Menu menu);

    void deleteById(UUID id);
}
