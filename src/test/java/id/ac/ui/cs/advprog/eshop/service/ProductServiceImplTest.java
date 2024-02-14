package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private  ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Mockito.when(productRepository.create(product)).thenReturn(product);


        assertEquals(product, productService.create(product));
    }

    @Test
    void testFindAll() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Iterator<Product> productIterator = products.iterator();
        Mockito.when(productRepository.findAll()).thenReturn(productIterator);

        assertEquals(products, productService.findAll());
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Mockito.when(productRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);

        assertEquals(product, productService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6"));
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Mockito.when(productRepository.editProduct(product)).thenReturn(product);

        assertEquals(product, productService.editProduct(product));
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        Mockito.when(productRepository.delete("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);

        assertEquals(product, productService.deleteProduct("eb558e9f-1c39-460e-8860-71af6af63bd6"));
    }
}