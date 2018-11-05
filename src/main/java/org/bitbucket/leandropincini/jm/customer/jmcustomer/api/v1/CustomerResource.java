package org.bitbucket.leandropincini.jm.customer.jmcustomer.api.v1;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Relation(value = "customer", collectionRelation = "customers")
class CustomerResource extends ResourceSupport {
    @NotBlank
    private String name;

    @NotBlank
    private String documentNumber;
}
