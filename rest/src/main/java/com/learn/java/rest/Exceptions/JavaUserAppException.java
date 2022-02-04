package com.learn.java.rest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("ALL")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class JavaUserAppException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public JavaUserAppException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
