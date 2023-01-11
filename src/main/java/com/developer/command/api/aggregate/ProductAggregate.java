package com.developer.command.api.aggregate;


import com.developer.command.api.commands.CreateCommandProduct;
import com.developer.command.api.events.ProductCreatedEvents;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId ;
    private String name ;
    private BigDecimal price ;
    private Integer quantity ;

    @CommandHandler
    public ProductAggregate(CreateCommandProduct createCommandProduct) {
        // You can perform all the validations
        ProductCreatedEvents productCreatedEvents =
                new ProductCreatedEvents();
        BeanUtils.copyProperties(createCommandProduct , productCreatedEvents);
        AggregateLifecycle.apply(productCreatedEvents);
    }

    public ProductAggregate() {
    }
    @EventSourcingHandler
    public  void  on(ProductCreatedEvents productCreatedEvents)
    {
        this.name = productCreatedEvents.getName();
        this.price = productCreatedEvents.getPrice();
        this.quantity = productCreatedEvents.getQuantity();
        this.productId = productCreatedEvents.getProductId();
    }
}
