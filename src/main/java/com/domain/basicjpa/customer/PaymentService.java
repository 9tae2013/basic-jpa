package com.domain.basicjpa.customer;

import com.domain.basicjpa.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentService {
    protected transient Log logger = LogFactory.getLog(getClass());

    @Autowired
    CustomerRepository customerRepository;

    public void payment(String customerName, double total) {
        Customer customer = customerRepository.getOne(customerName);
        double credit = customer.getCredit() - total;
        customer.setCredit(credit);
    }
}
