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
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found!"));

        return entityToDto(menu);
    }

    @Override
    public MenuDto updateById(UUID id, MenuDto menuDto) {

        Menu savedMenu = menuRepository.findById(id)
                .map(menu -> {
                    menu.setName(menuDto.getName());
                    menu.setPrice(menuDto.getPrice());
                    menu.setOptions(menuDto.getOptions());
                    menu.setImage(menuDto.getImage());
                    return menuRepository.save(menu);
                })
                .orElseThrow(() -> new RuntimeException("Menu not saved!"));

        return entityToDto(savedMenu);

//            // This created new object, and trigger INSERT... instead of UPDATE...
//            Menu updatedMenu = existingMenu.toBuilder()
//                    .name(menuDto.getName())
//                    .price(menuDto.getPrice())
//                    .options(menuDto.getOptions())
//                    .image(menuDto.getImage())
//                    .build();
//
//            return entityToDto(menuRepository.save(menuFromDb));
    }

    @Override
    public void deleteById(UUID id) {
        menuRepository.deleteById(id);
    }
}
