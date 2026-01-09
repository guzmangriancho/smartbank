package com.qaracter.smartbank.repository;

import com.qaracter.smartbank.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final Map<Long, Customer> customers = new HashMap<>();
    private long idCounter = 1;

    public Customer save(Customer c) {
        if (c.getId() == null) {
            c.setId(idCounter++);
        }
        customers.put(c.getId(), c);
        return c;
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public Customer findById(Long id) {
        return customers.get(id);
    }

    public void deleteById(Long id) {
        customers.remove(id);
    }
}