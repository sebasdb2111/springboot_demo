package com.sebastiandiez.app.entity;

public final class UserNotFounfException extends RuntimeException {
	
	private final String errorCode;
    private final String errorMessage;

    public UserNotFounfException() {
        super("User not found");

        this.errorCode    = "500";
        this.errorMessage = "User not found";
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}
