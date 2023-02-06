package me.ildar.mockito.exception;

public class UserNonUniqueException extends RuntimeException {
    public UserNonUniqueException(String message) {
        super(message);
    }
}
