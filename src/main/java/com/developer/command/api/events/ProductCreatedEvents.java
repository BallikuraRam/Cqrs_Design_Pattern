package com.developer.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.ArrayLen;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductCreatedEvents {

    private String productId ;
    private String name ;
    private BigDecimal price ;
    private Integer quantity ;
}
