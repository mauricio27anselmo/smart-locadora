package br.com.smartlocadora.exception;

public class NotFoundObjectException extends RuntimeException{

    public NotFoundObjectException(String message) {
        super(message);
    }
}
