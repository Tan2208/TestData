package com.example.TestData.Exception;

public enum ErrorCode
{
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Error"),
    INVALID_KEY(9001, "INVALID message key"),
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1003, "User must be at least 3 characters"),
    INVALID_PASSWORD(1004, "Invalid must be at least 8 characters"),
    USER_NOT_EXISTED(1005, "User not existed"),
    ;

    ErrorCode(int coded, String message) {
        this.coded = coded;
        this.message = message;
    }

    private int coded;
    private String message;

    public int getCoded() {
        return coded;
    }

    public void setCoded(int coded) {
        this.coded = coded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
