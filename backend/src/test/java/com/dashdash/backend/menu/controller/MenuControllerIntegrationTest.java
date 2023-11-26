package com.dashdash.backend.menu.controller;

import com.dashdash.backend.application.exception.ResourceNotFoundException;
import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MenuController.class)
public class MenuControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuService menuService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getMenu() throws Exception {
        Long menuId = 1L;
        MenuDto menuDto = createMenuDto();

        when(menuService.getById(menuId)).thenReturn(menuDto);

        this.mockMvc.perform(get("/api/menus/{menuId}", menuId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.backendResult.isError").value(false))
                .andExpect(jsonPath("$.data.id").value(menuDto.getId()))
                .andExpect(jsonPath("$.data.name").value(menuDto.getName()))
                .andExpect(jsonPath("$.data.price").value(menuDto.getPrice()))
                .andExpect(jsonPath("$.data.options").value(menuDto.getOptions()))
                .andDo(print());

        verify(menuService, times(1)).getById(menuId);
    }

    @Test
    public void getMenu_with_ResourceNotFoundException() throws Exception {
        Long nonExistingMenuId = 999L;
        doThrow(new ResourceNotFoundException("Menu not found"))
                .when(menuService)
                .getById(anyLong());

        this.mockMvc.perform(get("/api/menus/{menuId}", nonExistingMenuId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.backendResult.isError").value(true))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andDo(print());

        verify(menuService, times(1)).getById(nonExistingMenuId);
    }

    @Test
    public void saveMenu() throws Exception {
        MenuDto menuDto = createMenuDto();

        when(menuService.save(any(MenuDto.class))).thenReturn(menuDto);

        this.mockMvc.perform(post("/api/menus")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.backendResult.isError").value(false))
                .andExpect(jsonPath("$.data.id").value(menuDto.getId()))
                .andExpect(jsonPath("$.data.name").value(menuDto.getName()))
                .andExpect(jsonPath("$.data.price").value(menuDto.getPrice()))
                .andExpect(jsonPath("$.data.options").value(menuDto.getOptions()))
                .andDo(print());
    }

    @Test
    public void updateMenu() throws Exception {
        MenuDto menuDto = createMenuDto();

        when(menuService.updateById(menuDto.getId(), menuDto)).thenReturn(menuDto);

        this.mockMvc.perform(put("/api/menus/{menuId}", menuDto.getId())
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.backendResult.isError").value(false))
                .andDo(print());
    }

    @Test
    public void updateMenu_with_ResourceNotFoundException() throws Exception {
        Long nonExistingMenuId = 999L;
        doThrow(new ResourceNotFoundException("Menu not found"))
                .when(menuService)
                .updateById(anyLong(), any(MenuDto.class));

        this.mockMvc.perform(put("/api/menus/{menuId}", nonExistingMenuId)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createMenuDto())))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.backendResult.message").value("Menu not found"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andDo(print());
    }

    @Test
    public void deleteMenu() throws Exception {
        Long menuId = 1L;
        MenuDto menuDto = createMenuDto();

        when(menuService.getById(menuId)).thenReturn(menuDto);

        this.mockMvc.perform(delete("/api/menus/{menuId}", menuId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.backendResult.isError").value(false))
                .andExpect(jsonPath("$.data.id").value(menuDto.getId()))
                .andExpect(jsonPath("$.data.name").value(menuDto.getName()))
                .andExpect(jsonPath("$.data.price").value(menuDto.getPrice()))
                .andExpect(jsonPath("$.data.options").value(menuDto.getOptions()))
                .andDo(print());

        verify(menuService, times(1)).getById(menuId);
        verify(menuService, times(1)).deleteById(menuId);
    }

    private MenuDto createMenuDto() {
        return MenuDto.builder()
                .id(1L)
                .name("Test Menu")
                .price(new BigDecimal("8.95"))
                .options("Option 1, Option 2")
                .image(new byte[]{1, 2, 3, 4})
                .build();
    }
}