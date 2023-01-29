package com.example.nevasikspring.exception;

// Здесь будут хранятся ошибки для разных ситуаций
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}