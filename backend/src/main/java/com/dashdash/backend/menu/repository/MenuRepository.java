package com.dashdash.backend.menu.repository;

import com.dashdash.backend.menu.model.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuRepository {

    Menu save(Menu menu);

    Menu findById(UUID id);

    Menu updateById(UUID id, Menu menu);

    void deleteById(UUID id);
}
