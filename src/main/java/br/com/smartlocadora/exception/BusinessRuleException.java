package br.com.smartlocadora.exception;

public class BusinessRuleException extends RuntimeException{

    public BusinessRuleException(String message) {
        super(message);
    }
}
