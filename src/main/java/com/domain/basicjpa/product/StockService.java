package com.domain.basicjpa.product;

import com.domain.basicjpa.model.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StockService {
    protected transient Log logger = LogFactory.getLog(getClass());

    @Autowired
    ProductRepository productRepository;

    public Product getRemainProduct(Long productId, int amount) {
        return productRepository.getOne(productId);
    }

    public void reduceStock(Long productId, int amount) {
        Product product = productRepository.getOne(productId);
        int remain = product.getRemain() - amount;
        product.setRemain(remain);
    }
}
