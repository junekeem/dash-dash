package com.dashdash.backend.menu.service;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.model.MenuDto;
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
    public MenuDto save(MenuDto menuDto) {
        Menu menu = dtoToEntity(menuDto);
        Menu savedMenu = menuRepository.save(menu);

        return entityToDto(savedMenu);
    }

    @Override
    public MenuDto getById(UUID id) {
        Menu menu = menuRepository.findById(id);

        return entityToDto(menu);
    }

    @Override
    public MenuDto updateById(UUID id, MenuDto menuDto) {
        Menu existingMenu = menuRepository.findById(id);

        if (existingMenu != null) {
            Menu updatedMenu = existingMenu.toBuilder()
                    .name(menuDto.getName())
                    .price(menuDto.getPrice())
                    .options(menuDto.getOptions())
                    .image(menuDto.getImage())
                    .build();

            return entityToDto(menuRepository.updateById(existingMenu.getId(), updatedMenu));
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(UUID id) {
        menuRepository.deleteById(id);
    }
}
