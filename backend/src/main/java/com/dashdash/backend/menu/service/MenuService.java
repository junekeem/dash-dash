package com.dashdash.backend.menu.service;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.model.MenuDto;

public interface MenuService {
    MenuDto save(MenuDto menuDto);

    MenuDto getById(Long id);

    MenuDto updateById(Long id, MenuDto menuDto);

    void deleteById(Long id);

    default MenuDto entityToDto(Menu menu) {
        return MenuDto.builder()
                .id(menu.getId())
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
