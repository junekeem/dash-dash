package com.dashdash.backend.menu.service;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getById(UUID id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu updateById(UUID id, Menu updatedMenu) {
        Menu existingMenu = this.getById(id);

        if (existingMenu != null) {
            existingMenu.setName(updatedMenu.getName());
            existingMenu.setPrice(updatedMenu.getPrice());
            existingMenu.setOptions(updatedMenu.getOptions());

            return menuRepository.updateById(existingMenu.getId(), existingMenu);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(UUID id) {
        menuRepository.deleteById(id);
    }
}
