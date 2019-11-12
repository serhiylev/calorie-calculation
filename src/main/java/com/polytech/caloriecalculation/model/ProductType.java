package com.polytech.caloriecalculation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    SALAD("SALAD"), FIRST_DISH("FIRST DISH"), SECOND_DISH("SECOND DISH"), DESSERT("DESSERT");

    private String name;

    public static ProductType getByName(String name) {
        for (ProductType value : ProductType.values()) {
            if (name.equals(value.getName())) {
                return value;
            }
        }
        throw new RuntimeException("Invalid product type");
    }
}
