package com.prostor.prostorApp.modules.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "Название товара обязательно")
    @Size(max = 150, message = "Название не должно превышать 150 символов")
    private String name;

    @NotNull(message = "Цена обязательна")
    @Positive(message = "Цена должна быть положительной")
    private Double price;

    @NotNull(message = "ID продавца обязателен")
    private Integer sellerId;

    @NotNull(message = "ID категории обязателен")
    private Integer categoryId;

   
    @Positive(message = "ID родительского товара (если указан) должен быть положительным")
    private Integer parentId;

   
}