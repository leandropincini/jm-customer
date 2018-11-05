package org.bitbucket.leandropincini.jm.customer.jmcustomer.service;

import lombok.AllArgsConstructor;
import org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.orm.Customer;
import org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(final Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> findByName(final String name) {
        return customerRepository.findByName(name);
    }

    public Optional<Customer> findByDocumentNumber(final String documentNumber) {
        return customerRepository.findByDocumentNumber(documentNumber);
    }

    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> delete(final Customer customer) {
        Optional<Customer> customerToDelete = findByDocumentNumber(customer.getDocumentNumber());

        if (customerToDelete.isPresent()) {
            customerRepository.delete(customerToDelete.get());
            return customerToDelete;
        }

        return Optional.empty();
    }
}
