package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addOneProduct() {
        productRepository.addProduct("Beer");
        try {
            throw new RuntimeException(": (");
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
