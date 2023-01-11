package com.developer.command.api.events;


import com.developer.command.api.data.Product;
import com.developer.command.api.data.ProductRepository;
import com.developer.command.api.events.ProductCreatedEvents;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
@ProcessingGroup("product")
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public  void  on(ProductCreatedEvents events) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(events , product);
        productRepository.save(product);
        throw new Exception("Exception Occured ");
    }
    @ExceptionHandler
    public void hander(Exception exception) throws Exception {
        throw exception;
    }
}
