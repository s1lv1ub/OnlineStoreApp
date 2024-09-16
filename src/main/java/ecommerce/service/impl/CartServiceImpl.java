package ecommerce.service.impl;

import ecommerce.dto.CartDTO;
import ecommerce.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {
        return null;
    }
}
