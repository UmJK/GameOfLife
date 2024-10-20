package com.chargepoint.gameOfLife.exception;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(String message) {
        super(message);
    }
}