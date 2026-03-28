package com.tcs.loan_management_api.repository;


import com.tcs.loan_management_api.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}