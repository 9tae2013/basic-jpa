package com.domain.basicjpa;

import com.domain.basicjpa.customer.CustomerRepository;
import com.domain.basicjpa.model.Customer;
import com.domain.basicjpa.model.Product;
import com.domain.basicjpa.order.OrderRepository;
import com.domain.basicjpa.order.OrderService;
import com.domain.basicjpa.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BasicJpaApplication {
    protected transient Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    @Bean
    public ApplicationRunner appRun() {
        return __ -> {
            List<Customer> customers = Arrays.asList(
                    new Customer("customer1", 500),
                    new Customer("customer2", 300),
                    new Customer("customer3", 30)
            );
            customerRepository.saveAll(customers);


            List<Product> products = Arrays.asList(
                    new Product("product1", 20, 50),
                    new Product("product2", 10, 100),
                    new Product("product3", 0, 10),
                    new Product("product4", 100, 30)
            );
            productRepository.saveAll(products);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicJpaApplication.class, args);
    }
}
