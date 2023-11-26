package com.dashdash.backend.menu.service;

import com.dashdash.backend.application.exception.ResourceNotFoundException;
import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

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
    public MenuDto getById(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu not found!"));

        return entityToDto(menu);
    }

    @Override
    public MenuDto updateById(Long id, MenuDto menuDto) {

        Menu savedMenu = menuRepository.findById(id)
                .map(menu -> {
                    menu.setName(menuDto.getName());
                    menu.setPrice(menuDto.getPrice());
                    menu.setOptions(menuDto.getOptions());
                    menu.setImage(menuDto.getImage());
                    return menuRepository.save(menu);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Menu not found!"));

        return entityToDto(savedMenu);
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }
}
