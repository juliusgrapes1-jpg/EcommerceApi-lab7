package com.ws101.Ubas.EcommerceApi.repository;
import com.ws101.Ubas.EcommerceApi.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}