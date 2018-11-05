package org.bitbucket.leandropincini.jm.customer.jmcustomer.api.v1;

import lombok.AllArgsConstructor;
import org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.orm.Customer;
import org.bitbucket.leandropincini.jm.customer.jmcustomer.exception.ResourceNotFoundException;
import org.bitbucket.leandropincini.jm.customer.jmcustomer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/customers")
public class CustomerRestController {
    private final CustomerService customerService;
    private final CustomerResourceAssembler customerResourceAssembler;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping
    public List<CustomerResource> getAll() {
        throw new NotImplementedException();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public CustomerResource getById(@PathVariable final Long id) {
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()) {
            return customerResourceAssembler.toResource(customer.get());
        }

        throw new ResourceNotFoundException("Customer", "id", id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name/{name}")
    public CustomerResource getByName(@PathVariable final String name) {
        Optional<Customer> customer = customerService.findByName(name);

        if (customer.isPresent()) {
            return customerResourceAssembler.toResource(customer.get());
        }

        throw new ResourceNotFoundException("Customer", "name", name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "document/{documentNumber}")
    public CustomerResource getByDocumentNumber(@PathVariable final String documentNumber) {
        Optional<Customer> customer = customerService.findByDocumentNumber(documentNumber);

        if (customer.isPresent()) {
            return customerResourceAssembler.toResource(customer.get());
        }

        throw new ResourceNotFoundException("Customer", "documentNumber", documentNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResource save(@RequestBody @Valid final CustomerResource customerResource) {
        return customerResourceAssembler.toResource(customerService.save(customerResourceAssembler.toDomain(customerResource)));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public CustomerResource delete(@RequestBody @Valid final CustomerResource customerResource) {
        Optional<Customer> customer = customerService.delete(customerResourceAssembler.toDomain(customerResource));

        if (customer.isPresent()) {
            return customerResourceAssembler.toResource(customer.get());
        }

        throw new ResourceNotFoundException("Customer", "name", customerResource.getName());
    }
}
