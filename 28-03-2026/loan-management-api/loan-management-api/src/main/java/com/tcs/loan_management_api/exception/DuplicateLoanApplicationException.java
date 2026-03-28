package com.tcs.loan_management_api.exception;

public class DuplicateLoanApplicationException extends RuntimeException {
    public DuplicateLoanApplicationException(String message) {
        super(message);
    }
}
