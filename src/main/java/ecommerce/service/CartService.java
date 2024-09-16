package ecommerce.service;

import ecommerce.dto.CartDTO;

public interface CartService {
     CartDTO addProductToCart(Long productId, Integer quantity);
}
