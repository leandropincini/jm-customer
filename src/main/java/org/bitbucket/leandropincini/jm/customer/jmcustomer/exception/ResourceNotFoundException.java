package org.bitbucket.leandropincini.jm.customer.jmcustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(final String resourceName, final String fieldName, final Object fieldValue) {
        super(String.valueOf(new StringBuilder(resourceName).append(" not found with ").append(fieldName).append(": '").append(fieldValue).append("'")));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
