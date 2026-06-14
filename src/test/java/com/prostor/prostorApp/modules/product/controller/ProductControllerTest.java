package com.prostor.prostorApp.modules.product.controller;

import com.prostor.prostorApp.modules.product.dto.ProductResponse;
import com.prostor.prostorApp.modules.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testSortingByPriceDesc() {
        // given
        PageRequest expectedPageable = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "price"));
        Page<ProductResponse> mockPage = new PageImpl<>(List.of(
                new ProductResponse(/* заполните тестовыми данными */)
        ), expectedPageable, 1);

        when(productService.filter(any(), any(), any(), any(), any(), any(PageRequest.class)))
                .thenReturn(mockPage);

        // when
        Page<ProductResponse> result = productController.getAll(null, null, null, null, null, "price", expectedPageable).getBody();

        // then
        assertNotNull(result);
        assertTrue(result.getSort().isSorted());
        assertEquals("price", result.getSort().getOrderFor("price").getProperty());
        assertTrue(result.getSort().getOrderFor("price").isDescending());
    }
}