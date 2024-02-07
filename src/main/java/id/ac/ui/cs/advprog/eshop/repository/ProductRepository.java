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

    public void updateProductQuantity(String productId, int newQuantity) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                product.setProductQuantity(newQuantity);
            }
        }
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
