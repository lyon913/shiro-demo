package com.whr.dto;

/**
 * Created by Lyon on 2017/7/13.
 */
public class ValidationResult
{
    private boolean validationError;
    private String property;
    private String message;

    public ValidationResult(String property, String message, boolean isValidationError){
        this.property = property;
        this.message = message;
        this.validationError = isValidationError;
    }

    public boolean isValidationError() {
        return validationError;
    }

    public void setValidationError(boolean validationError) {
        this.validationError = validationError;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
