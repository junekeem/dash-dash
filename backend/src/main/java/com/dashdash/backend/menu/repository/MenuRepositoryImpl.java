package com.dashdash.backend.menu.repository;

import com.dashdash.backend.menu.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    private Map<UUID, Menu> db = new HashMap<>();

    @Override
    public Menu save(Menu menu) {
        menu.setId(UUID.randomUUID());
        db.put(menu.getId(), menu);
        return menu;
    }

    @Override
    public Menu findById(UUID id) {
        return db.get(id);
    }

    @Override
    public Menu updateById(UUID id, Menu updatedMenu) {
        if (db.containsKey(id)) {
            db.put(id, updatedMenu);
            return updatedMenu;
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(UUID id) {
        db.remove(id);
    }
}
