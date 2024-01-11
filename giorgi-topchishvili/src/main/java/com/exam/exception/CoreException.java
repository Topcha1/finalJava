package com.exam.exception;


import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {

    private final String message;

    public CoreException(String message) {
        this.message = message;
    }

}
