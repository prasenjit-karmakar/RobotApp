package com.xebia.robotapp.rules;

/**
 * @author Prasenjit
 */
public class Validation {
    private final boolean valid;
    private final String message;

    public Validation(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }
}
