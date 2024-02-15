package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController ProductController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @Test
    void testCreateProductPage() {
        String result = ProductController.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void createProductPost() {
        Product product = new Product();
        String result = ProductController.createProductPost(product ,model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testProductListPage() {
        String result = ProductController.productListPage(model);
        assertEquals("ProductList", result);
    }

    @Test
    void testEditProductPage() {
        String result = ProductController.editProductPage("1", model);
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        String result = ProductController.editProductPost(product, model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testDeleteProduct() {
        String result = ProductController.deleteProduct("1");
        assertEquals("redirect:/product/list", result);
    }
}