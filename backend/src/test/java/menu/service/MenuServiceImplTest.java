package menu.service;

import com.dashdash.backend.menu.model.Menu;
import com.dashdash.backend.menu.model.MenuDto;
import com.dashdash.backend.menu.repository.MenuRepository;
import com.dashdash.backend.menu.service.MenuServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MenuServiceImplTest {

    @InjectMocks
    private MenuServiceImpl menuService;

    @Mock
    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        MenuDto menuDto = createMenuDto();
        Menu menu = createMenu();
        when(menuRepository.save(any(Menu.class))).thenReturn(menu);

        MenuDto savedMenuDto = menuService.save(menuDto);

        assertEquals(menuDto.getName(), savedMenuDto.getName());
        assertEquals(menuDto.getPrice(), savedMenuDto.getPrice());
    }

    @Test
    void testGetById() {
        Menu menu = createMenu();
        when(menuRepository.findById(anyLong())).thenReturn(Optional.of(menu));

        MenuDto menuDto = menuService.getById(1L);

        assertEquals(menu.getName(), menuDto.getName());
        assertEquals(menu.getPrice(), menuDto.getPrice());
    }

    @Test
    void testUpdateById() {
        MenuDto menuDto = createMenuDto();
        Menu menu = createMenu();
        when(menuRepository.findById(anyLong())).thenReturn(Optional.of(menu));
        when(menuRepository.save(any(Menu.class))).thenReturn(menu);

        MenuDto updatedMenuDto = menuService.updateById(1L, menuDto);

        assertEquals(menuDto.getName(), updatedMenuDto.getName());
        assertEquals(menuDto.getPrice(), updatedMenuDto.getPrice());
    }

    @Test
    void testDeleteById() {
        menuService.deleteById(101L);

        verify(menuRepository, times(1)).deleteById(101L);
    }

    @Test
    void testGetByIdWhenMenuNotExist() {
        when(menuRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> menuService.getById(101L));
    }

    @Test
    void testUpdateByIdWhenMenuNotExist() {
        MenuDto menuDto = createMenuDto();

        when(menuRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> menuService.updateById(101L, menuDto));
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

    private Menu createMenu() {
        return Menu.builder()
                .name("Test Menu")
                .price(new BigDecimal("10.00"))
                .options("Option 1, Option 2")
                .image(new byte[]{1, 2, 3, 4})
                .build();
    }
}