package com.dashdash.backend.menu.controller;

import com.dashdash.backend.application.model.response.SingleApiResultResponse;
import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MenuControllerUnitTest {

    @Mock
    private MenuService menuService;

    @InjectMocks
    private MenuController menuController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createMenu() {
        MenuDto menuDto = createMenuDto();
        when(menuService.save(any(MenuDto.class))).thenReturn(menuDto);

        ResponseEntity<SingleApiResultResponse<MenuDto>> response = menuController.saveMenu(menuDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(menuDto, response.getBody().getData());
    }

    @Test
    public void fetchMenuById() {
        MenuDto menuDto = createMenuDto();
        when(menuService.getById(anyLong())).thenReturn(menuDto);

        ResponseEntity<SingleApiResultResponse<MenuDto>> response = menuController.getMenu(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(menuDto, response.getBody().getData());
    }

    @Test
    public void fetchMenuByIdWithResourceNotFoundException() {
        when(menuService.getById(anyLong())).thenReturn(null);

        ResponseEntity<SingleApiResultResponse<MenuDto>> response = menuController.getMenu(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void updateMenu() {
        MenuDto menuDto = createMenuDto();
        when(menuService.updateById(anyLong(), any(MenuDto.class))).thenReturn(menuDto);

        ResponseEntity<SingleApiResultResponse<MenuDto>> response = menuController.updateMenu(1L, menuDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(menuDto, response.getBody().getData());
    }

    @Test
    public void deleteMenuById() {
        MenuDto menuDto = createMenuDto();
        when(menuService.getById(anyLong())).thenReturn(menuDto);

        ResponseEntity<SingleApiResultResponse<MenuDto>> response = menuController.deleteMenu(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(menuDto, response.getBody().getData());

        verify(menuService, times(1)).deleteById(1L);
    }

    private MenuDto createMenuDto() {
        return MenuDto.builder()
                .id(1L)
                .name("Test Menu")
                .price(new BigDecimal("10.00"))
                .options("Option 1, Option 2")
                .image(new byte[]{1, 2, 3, 4})
                .build();
    }
}