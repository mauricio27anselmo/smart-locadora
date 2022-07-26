package br.com.smartlocadora.exception;

import java.util.Arrays;
import java.util.List;

public class SmartLocadoraErrors {

    public List<String> errors;

    public SmartLocadoraErrors(List<String> errors) {
        this.errors = errors;
    }

    public SmartLocadoraErrors(String message) {
        this.errors = Arrays.asList(message);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
