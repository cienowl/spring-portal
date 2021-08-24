package io.string.portal.exception;

public class InvalidAccessTokenException extends RuntimeException {
    public InvalidAccessTokenException(String msg, Throwable t) {
        super(msg, t);
    }
    public InvalidAccessTokenException(String msg) {
        super(msg);
    }
    public InvalidAccessTokenException() {
        super();
    }
}
