package com.ws101.Ubas.EcommerceApi.service;

import com.ws101.Ubas.EcommerceApi.model.CartItem;
import com.ws101.Ubas.EcommerceApi.model.Product;
import com.ws101.Ubas.EcommerceApi.model.User;
import com.ws101.Ubas.EcommerceApi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartItem addToCart(User user, Product product, int quantity) {
        CartItem item = new CartItem();
        item.setUser(user);
        item.setProduct(product);
        item.setQuantity(quantity);
        return cartRepository.save(item);
    }

    public List<CartItem> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}