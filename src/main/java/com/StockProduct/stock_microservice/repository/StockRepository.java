package com.StockProduct.stock_microservice.repository;

import com.StockProduct.stock_microservice.entity.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockProduct, Long> {

    Optional<StockProduct> findByCode(String code);

}
