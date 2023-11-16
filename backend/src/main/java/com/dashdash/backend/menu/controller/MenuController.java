package com.dashdash.backend.menu.controller;

import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuDto> saveMenu(@RequestBody MenuDto menuDto) {
        MenuDto updatedMenu = menuService.save(menuDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedMenu);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable UUID menuId) {
        MenuDto menu = menuService.getById(menuId);

        return menu != null ?
                ResponseEntity.status(HttpStatus.OK).body(menu)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/{menuId}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable UUID menuId, @RequestBody MenuDto menuDto) {
        MenuDto updatedMenu = menuService.updateById(menuId, menuDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedMenu);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<MenuDto> deleteMenu(@PathVariable UUID menuId) {
        MenuDto menu = menuService.getById(menuId);
        menuService.deleteById(menuId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menu);
    }
}
