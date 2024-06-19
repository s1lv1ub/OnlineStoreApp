package ing.store.controller;

import ing.store.dto.ProductDTO;
import ing.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO,
                                                 @PathVariable(name = "categoryId") Long categoryId) {

        ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDTO);
    }
}
