package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Default ----> read committed
     *
     * READ_UNCOMMITTED
     * READ_COMMITTED
     * REPEATABLE_READ
     * SERIALIZABLE
     *
     * PROBLEMS
     * - dirty reads
     * - repeatable reads
     * - phantom reads
     *
     * T1--------10------------20--------->
     *
     * T2--------------20--------------->
     */

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void addTenProduct() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct("Product " + i);

        }
    }
}
