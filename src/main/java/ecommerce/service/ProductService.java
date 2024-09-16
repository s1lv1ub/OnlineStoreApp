package ecommerce.service;

import ecommerce.dto.ProductDTO;
import ecommerce.dto.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {

   ProductDTO addProduct(Long CategoryId, ProductDTO productDTO);

   ProductResponse getAllProcucts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

   ProductResponse searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

   ProductResponse searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

   ProductDTO updateProduct(Long productId, ProductDTO productDTO);

   ProductDTO deleteById(Long productId);

   ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
