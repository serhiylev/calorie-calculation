package com.polytech.caloriecalculation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductSetsDTO {
    private int id;
    private int grams;
    private int product_id;
    private int set_id;
}

/*
    {
        "id": 8,
            "grams": 243,
            "product_id": 1,
            "set_id": 2
    }
* */
