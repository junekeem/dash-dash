package com.dashdash.backend.menu.controller;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.service.MenuService;
import org.springframework.http.*;
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
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        Menu updatedMenu = menuService.save(menu);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedMenu);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenu(@PathVariable UUID menuId) {
        Menu menu = menuService.getById(menuId);

        return menu != null ?
                ResponseEntity.status(HttpStatus.OK).body(menu)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable UUID menuId, @RequestBody Menu menu) {
        Menu updatedMenu = menuService.updateById(menuId, menu);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedMenu);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Menu> deleteMenu(@PathVariable UUID menuId) {
        Menu menu = menuService.getById(menuId);
        menuService.deleteById(menuId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menu);
    }
}
