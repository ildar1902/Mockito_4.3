package me.ildar.mockito.exception;

public class UserNonUniqueException extends RuntimeException {
    public UserNonUniqueException() {
    }

    public UserNonUniqueException(String message) {
        super("пользователь с таким логином уже существует");
    }
}
