package com.StockProduct.stock_microservice.controller;

import com.StockProduct.stock_microservice.entity.StockProduct;
import com.StockProduct.stock_microservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public boolean stockAvailable(@PathVariable String code) {
        Optional<StockProduct> stock = stockRepository.findByCode(code);

        stock.orElseThrow(() -> new RuntimeException("Stock not found" + code));
        return stock.get().getQuantity() > 0;
    }

}
