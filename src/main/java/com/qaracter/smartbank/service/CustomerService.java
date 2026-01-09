package com.qaracter.smartbank.service;

import com.qaracter.smartbank.exception.CustomerNotFoundException;
import com.qaracter.smartbank.model.Customer;
import com.qaracter.smartbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getById(Long id) {
        Customer customer = repo.findById(id);
        if (customer == null) throw new CustomerNotFoundException("Customer not found");
        return customer;
    }
}