package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {

    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        String UniqueId = UUID.randomUUID().toString();
        product.setProductId(UniqueId);

        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product editProduct(Product product) {
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
        System.out.println(product.getProductQuantity());

        Product targetProduct = findById(product.getProductId());
        targetProduct.setProductName(product.getProductName());
        targetProduct.setProductQuantity(product.getProductQuantity());

        return targetProduct;
    }

    public Product delete(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                productData.remove(product);
                return product;
            }
        }
        return null;
    }
}
