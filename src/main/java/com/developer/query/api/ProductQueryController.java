package com.developer.query.api;

import com.developer.command.api.model.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> productRestModels()
    {
        GetProductQuery getProductQuery =
                new GetProductQuery();

        List<ProductRestModel> productRestModels = queryGateway.query(getProductQuery
        , ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
        return  null ;
    }
}
