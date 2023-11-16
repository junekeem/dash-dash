package com.dashdash.backend.menu.service;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.model.MenuDto;

import java.util.UUID;

public interface MenuService {
    MenuDto save(MenuDto menuDto);

    MenuDto getById(UUID id);

    MenuDto updateById(UUID id, MenuDto menuDto);

    void deleteById(UUID id);

    default MenuDto entityToDto(Menu menu) {
        return MenuDto.builder()
                .name(menu.getName())
                .price(menu.getPrice())
                .options(menu.getOptions())
                .image(menu.getImage())
                .build();
    }

    default Menu dtoToEntity(MenuDto menuDto) {
        return Menu.builder()
                .name(menuDto.getName())
                .price(menuDto.getPrice())
                .options(menuDto.getOptions())
                .image(menuDto.getImage())
                .build();
    }
}
