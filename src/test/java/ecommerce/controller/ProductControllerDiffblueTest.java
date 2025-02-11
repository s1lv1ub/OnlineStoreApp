package ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.dto.ProductDTO;
import ecommerce.dto.ProductResponse;
import ecommerce.model.Cart;
import ecommerce.model.Category;
import ecommerce.model.Product;
import ecommerce.model.User;
import ecommerce.repositories.CategoryRepository;
import ecommerce.repositories.ProductRepository;
import ecommerce.service.FileService;
import ecommerce.service.ProductService;
import ecommerce.service.impl.ProductServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ProductControllerDiffblueTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Test {@link ProductController#addProduct(ProductDTO, Long)}.
     * <p>
     * Method under test: {@link ProductController#addProduct(ProductDTO, Long)}
     */
    @Test
    @DisplayName("Test addProduct(ProductDTO, Long)")
    @Tag("MaintainedByDiffblue")
    void testAddProduct() throws Exception {
        // Arrange
        when(productService.addProduct(Mockito.<Long>any(), Mockito.<ProductDTO>any())).thenReturn(new ProductDTO());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryName("Category Name");
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDiscount(10.0d);
        productDTO.setImage("Image");
        productDTO.setPrice(10.0d);
        productDTO.setProductName("Product Name");
        productDTO.setQuantity(1);
        productDTO.setSpecialPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/admin/categories/{categoryId}/product", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productName\":null,\"image\":null,\"description\":null,\"quantity\":null,\"price\":0.0,\"discount\":0.0,"
                                        + "\"specialPrice\":0.0,\"categoryName\":null}"));
    }

    /**
     * Test {@link ProductController#updateProduct(ProductDTO, Long)}.
     * <p>
     * Method under test: {@link ProductController#updateProduct(ProductDTO, Long)}
     */
    @Test
    @DisplayName("Test updateProduct(ProductDTO, Long)")
    @Tag("MaintainedByDiffblue")
    void testUpdateProduct() throws Exception {
        // Arrange
        when(productService.updateProduct(Mockito.<Long>any(), Mockito.<ProductDTO>any())).thenReturn(new ProductDTO());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryName("Category Name");
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDiscount(10.0d);
        productDTO.setImage("Image");
        productDTO.setPrice(10.0d);
        productDTO.setProductName("Product Name");
        productDTO.setQuantity(1);
        productDTO.setSpecialPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/admin/products/{productId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productName\":null,\"image\":null,\"description\":null,\"quantity\":null,\"price\":0.0,\"discount\":0.0,"
                                        + "\"specialPrice\":0.0,\"categoryName\":null}"));
    }

    /**
     * Test {@link ProductController#updateProductImage(Long, MultipartFile)}.
     * <ul>
     *   <li>Then StatusCode return {@link HttpStatus}.</li>
     * </ul>
     * <p>
     * Method under test:
     * {@link ProductController#updateProductImage(Long, MultipartFile)}
     */
    @Test
    @DisplayName("Test updateProductImage(Long, MultipartFile); then StatusCode return HttpStatus")
    @Tag("MaintainedByDiffblue")
    void testUpdateProductImage_thenStatusCodeReturnHttpStatus() throws IOException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        FileService fileService = mock(FileService.class);
        when(fileService.uploadImage(Mockito.<String>any(), Mockito.<MultipartFile>any())).thenReturn("Upload Image");

        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("Category Name");

        User user = new User();
        user.setCart(new Cart());
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setUserId(1L);
        user.setUserName("janedoe");

        Cart cart = new Cart();
        cart.setCartId(1L);
        cart.setTotalPrice(10.0d);
        cart.setUser(user);

        User user2 = new User();
        user2.setCart(cart);
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setUserId(1L);
        user2.setUserName("janedoe");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setDiscount(10.0d);
        product.setImage("Image");
        product.setPrice(10.0d);
        product.setProductId(1L);
        product.setProductName("Product Name");
        product.setQuantity(1);
        product.setSpecialPrice(10.0d);
        product.setUser(user2);
        Optional<Product> ofResult = Optional.of(product);

        Category category2 = new Category();
        category2.setCategoryId(1L);
        category2.setCategoryName("Category Name");

        Cart cart2 = new Cart();
        cart2.setCartId(1L);
        cart2.setTotalPrice(10.0d);
        cart2.setUser(new User());

        User user3 = new User();
        user3.setCart(cart2);
        user3.setEmail("jane.doe@example.org");
        user3.setPassword("iloveyou");
        user3.setUserId(1L);
        user3.setUserName("janedoe");

        Cart cart3 = new Cart();
        cart3.setCartId(1L);
        cart3.setTotalPrice(10.0d);
        cart3.setUser(user3);

        User user4 = new User();
        user4.setCart(cart3);
        user4.setEmail("jane.doe@example.org");
        user4.setPassword("iloveyou");
        user4.setUserId(1L);
        user4.setUserName("janedoe");

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setDescription("The characteristics of someone or something");
        product2.setDiscount(10.0d);
        product2.setImage("Image");
        product2.setPrice(10.0d);
        product2.setProductId(1L);
        product2.setProductName("Product Name");
        product2.setQuantity(1);
        product2.setSpecialPrice(10.0d);
        product2.setUser(user4);
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        ProductController productController = new ProductController(
                new ProductServiceImpl(fileService, productRepository, categoryRepository, new ModelMapper()));

        // Act
        ResponseEntity<ProductDTO> actualUpdateProductImageResult = productController.updateProductImage(1L,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

        // Assert
        verify(fileService).uploadImage(isNull(), isA(MultipartFile.class));
        verify(productRepository).findById(eq(1L));
        verify(productRepository).save(isA(Product.class));
        HttpStatusCode statusCode = actualUpdateProductImageResult.getStatusCode();
        assertTrue(statusCode instanceof HttpStatus);
        ProductDTO body = actualUpdateProductImageResult.getBody();
        assertEquals("Category Name", body.getCategoryName());
        assertEquals("Image", body.getImage());
        assertEquals("Product Name", body.getProductName());
        assertEquals("The characteristics of someone or something", body.getDescription());
        assertEquals(1, body.getQuantity().intValue());
        assertEquals(10.0d, body.getDiscount());
        assertEquals(10.0d, body.getPrice());
        assertEquals(10.0d, body.getSpecialPrice());
        assertEquals(200, actualUpdateProductImageResult.getStatusCodeValue());
        assertEquals(HttpStatus.OK, statusCode);
        assertTrue(actualUpdateProductImageResult.hasBody());
        assertTrue(actualUpdateProductImageResult.getHeaders().isEmpty());
    }

    /**
     * Test
     * {@link ProductController#getProductsByKeyword(String, Integer, Integer, String, String)}.
     * <p>
     * Method under test:
     * {@link ProductController#getProductsByKeyword(String, Integer, Integer, String, String)}
     */
    @Test
    @DisplayName("Test getProductsByKeyword(String, Integer, Integer, String, String)")
    @Tag("MaintainedByDiffblue")
    void testGetProductsByKeyword() throws Exception {
        // Arrange
        when(productService.searchProductByKeyword(Mockito.<String>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ProductResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/public/products/keyword/{keyword}",
                "Keyword");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"contend\":null,\"pageNumber\":null,\"pageSize\":null,\"totalPages\":null,\"totalElements\":null,\"lastPage"
                                        + "\":false}"));
    }

    /**
     * Test
     * {@link ProductController#getProductsByCategory(Long, Integer, Integer, String, String)}.
     * <p>
     * Method under test:
     * {@link ProductController#getProductsByCategory(Long, Integer, Integer, String, String)}
     */
    @Test
    @DisplayName("Test getProductsByCategory(Long, Integer, Integer, String, String)")
    @Tag("MaintainedByDiffblue")
    void testGetProductsByCategory() throws Exception {
        // Arrange
        when(productService.searchByCategory(Mockito.<Long>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ProductResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/admin/categories/{categoryId}/product", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"contend\":null,\"pageNumber\":null,\"pageSize\":null,\"totalPages\":null,\"totalElements\":null,\"lastPage"
                                        + "\":false}"));
    }

    /**
     * Test
     * {@link ProductController#getAllProducts(Integer, Integer, String, String)}.
     * <p>
     * Method under test:
     * {@link ProductController#getAllProducts(Integer, Integer, String, String)}
     */
    @Test
    @DisplayName("Test getAllProducts(Integer, Integer, String, String)")
    @Tag("MaintainedByDiffblue")
    void testGetAllProducts() throws Exception {
        // Arrange
        when(productService.getAllProcucts(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(),
                Mockito.<String>any())).thenReturn(new ProductResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/public/products");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"contend\":null,\"pageNumber\":null,\"pageSize\":null,\"totalPages\":null,\"totalElements\":null,\"lastPage"
                                        + "\":false}"));
    }

    /**
     * Test {@link ProductController#deleteProduct(Long)}.
     * <p>
     * Method under test: {@link ProductController#deleteProduct(Long)}
     */
    @Test
    @DisplayName("Test deleteProduct(Long)")
    @Tag("MaintainedByDiffblue")
    void testDeleteProduct() throws Exception {
        // Arrange
        when(productService.deleteById(Mockito.<Long>any())).thenReturn(new ProductDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/admin/products/{productId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"productName\":null,\"image\":null,\"description\":null,\"quantity\":null,\"price\":0.0,\"discount\":0.0,"
                                        + "\"specialPrice\":0.0,\"categoryName\":null}"));
    }
}
