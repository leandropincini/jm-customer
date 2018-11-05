package org.bitbucket.leandropincini.jm.customer.jmcustomer.api.v1;

import org.bitbucket.leandropincini.jm.customer.jmcustomer.domain.orm.Customer;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler extends ResourceAssemblerSupport<Customer, CustomerResource> {
    public CustomerResourceAssembler() {
        super(CustomerRestController.class, CustomerResource.class);
    }

    @Override
    public CustomerResource toResource(Customer customer) {
        CustomerResource customerResource = createResourceWithId(customer.getId(), customer);
        customerResource.setName(customer.getName());
        customerResource.setDocumentNumber(customer.getDocumentNumber());

        return customerResource;
    }

    Customer toDomain(CustomerResource customerResource) {
        return Customer.builder()
            .name(customerResource.getName())
            .documentNumber(customerResource.getDocumentNumber())
            .build();
    }

    private void addLinks(CustomerResource customerResource) {
        customerResource.add(new Link("http://localhost:8006/customer/v1/customers/name/foo", "foo"));
        customerResource.add(new Link("http://localhost:8006/customer/v1/customers/name/bar", "bar"));
    }
}
