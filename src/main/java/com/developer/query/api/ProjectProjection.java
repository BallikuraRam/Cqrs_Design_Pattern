package com.developer.query.api;

import com.developer.command.api.data.Product;
import com.developer.command.api.data.ProductRepository;
import com.developer.command.api.model.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectProjection {

    private final ProductRepository productRepository ;

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery)
    {
        List<Product> products =
                productRepository.findAll();
        List<ProductRestModel> productRestModels =
                products.stream().map(product -> ProductRestModel.builder()
                        .quantity(product.getQuantity()).
                        price(product.getPrice())
                        .name(product.getName()).build()).collect(Collectors.toList());
        return productRestModels;
    }

}
