package com.tcs.loan_management_api.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalid(InvalidLoanAmountException ex) {
        return new ErrorResponse("InvalidLoanAmountException", ex.getMessage());
    }

    @ExceptionHandler(DuplicateLoanApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDuplicate(DuplicateLoanApplicationException ex) {
        return new ErrorResponse("DuplicateLoanApplicationException", ex.getMessage());
    }

    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(LoanNotFoundException ex) {
        return new ErrorResponse("LoanNotFoundException", ex.getMessage());
    }
}
