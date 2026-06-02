package com.ws101.Ubas.EcommerceApi.controller;

import com.ws101.Ubas.EcommerceApi.model.CartItem;
import com.ws101.Ubas.EcommerceApi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }
}