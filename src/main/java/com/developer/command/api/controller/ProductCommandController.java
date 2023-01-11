package com.developer.command.api.controller;

import com.developer.command.api.commands.CreateCommandProduct;
import com.developer.command.api.model.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway ;

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel productRestModel)
    {
        CreateCommandProduct createCommandProduct =
                CreateCommandProduct.builder()
                        .productId(UUID.randomUUID().toString())
                        .name(productRestModel.getName())
                        .price(productRestModel.getPrice())
                        .quantity(productRestModel.getQuantity())
                        .build();
        String result = commandGateway.sendAndWait(createCommandProduct);
        return result;
    }
}
