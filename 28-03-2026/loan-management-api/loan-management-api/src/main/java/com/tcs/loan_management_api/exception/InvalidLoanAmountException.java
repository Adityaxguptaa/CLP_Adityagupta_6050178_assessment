package com.tcs.loan_management_api.exception;

public class InvalidLoanAmountException extends RuntimeException {
    public InvalidLoanAmountException(String message) {
        super(message);
    }
}