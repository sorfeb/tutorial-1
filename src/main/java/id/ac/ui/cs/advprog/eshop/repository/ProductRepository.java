package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository implements TemplateRepository<Product>{

    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(
                //Assign new UUID if the product ID is not yet set
                UUID.randomUUID().toString()
            );
        }
        if(product.getProductQuantity() < 0){
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
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

    public Product update(Product product) {

        Product targetProduct = findById(product.getProductId());

        targetProduct.setProductName(product.getProductName());

        if(product.getProductQuantity() < 0){
            throw new IllegalArgumentException("Product quantity cannot be negative");}
        targetProduct.setProductQuantity(product.getProductQuantity());

        return targetProduct;
    }

    public Product deleteById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                productData.remove(product);
                return product;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Product not found");
    }
}
