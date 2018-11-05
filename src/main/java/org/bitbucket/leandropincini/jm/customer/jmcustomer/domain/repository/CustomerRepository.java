package org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.repository;

import org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.orm.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(final String name);

    Optional<Customer> findByDocumentNumber(final String documentNumber);
}
