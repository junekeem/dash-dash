package com.dashdash.backend.menu.controller;

import com.dashdash.backend.application.model.response.SingleApiResultResponse;
import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<SingleApiResultResponse<MenuDto>> saveMenu(@RequestBody MenuDto menuDto) {
        MenuDto updatedMenu = menuService.save(menuDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SingleApiResultResponse<>(updatedMenu));
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<SingleApiResultResponse<MenuDto>> getMenu(@PathVariable Long menuId) {
        MenuDto menu = menuService.getById(menuId);

        return menu != null ?
                ResponseEntity.status(HttpStatus.OK).body(new SingleApiResultResponse<>(menu))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/{menuId}")
    public ResponseEntity<SingleApiResultResponse<MenuDto>> updateMenu(@PathVariable Long menuId, @RequestBody MenuDto menuDto) {
        MenuDto updatedMenu = menuService.updateById(menuId, menuDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SingleApiResultResponse<>(updatedMenu));
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<SingleApiResultResponse<MenuDto>> deleteMenu(@PathVariable Long menuId) {
        MenuDto menu = menuService.getById(menuId);
        menuService.deleteById(menuId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SingleApiResultResponse<>(menu));
    }
}
